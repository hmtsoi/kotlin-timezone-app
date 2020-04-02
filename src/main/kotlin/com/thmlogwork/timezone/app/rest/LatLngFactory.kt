package com.thmlogwork.timezone.app.rest

import com.thmlogwork.timezone.app.domain.LatLng
import org.springframework.stereotype.Component

@Component
class LatLngFactory {

    fun validateAndParseLatLonStr(latLonStr: String): LatLng {
        val arr = latLonStr.split(",").toTypedArray()
        require(arr.size == 2) {
            ("Please input longitude and latitude comma separated"
                    + " in form of {latitude},{longitude}")
        }

        val latitude = arr[0].toDouble()
        val longitude = arr[1].toDouble()
        require(!(latitude > 90 || latitude < -90)) { "Latitude should be between -90 and 90" }
        require(!(longitude > 180 || longitude < -180)) { "Longitude should be between -180 and 180" }
        return LatLng(latitude, longitude)
    }
}