package com.thmlogwork.timezone.app.rest

import com.thmlogwork.timezone.app.domain.LatLng
import com.thmlogwork.timezone.app.domain.TimezoneService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/timeForLatLng"])
class TimezoneController(val service: TimezoneService,
                         val latLngFactory: LatLngFactory,
                         val timezoneResponseFactory: TimezoneResponseFactory) {

    @GetMapping("/{latLngStr}")
    fun getTimezoneInfo(@PathVariable latLngStr: String): ResponseEntity<Any> {

        val latLon: LatLng =
                try {
                    latLngFactory.validateAndParseLatLonStr(latLngStr)
                } catch (e: NumberFormatException) {
                    return ResponseEntity.badRequest().body("Number with wrong format: " + e.message)
                } catch (e: IllegalArgumentException) {
                    return ResponseEntity.badRequest().body(e.message);
                }

        val info = service.getTimezoneInfo(latLon)
        val response = timezoneResponseFactory.parseToResponse(info)

        return ResponseEntity.ok(response)
    }

}