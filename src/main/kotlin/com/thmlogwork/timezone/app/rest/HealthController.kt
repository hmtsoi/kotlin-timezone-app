package com.thmlogwork.timezone.app.rest

import com.thmlogwork.timezone.app.domain.HealthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {

    @Autowired
    private lateinit var service: HealthService

    @GetMapping("/health")
    fun health() = service.getHealth()

}