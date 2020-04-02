package com.thmlogwork.timezone.app.domain

import com.thmlogwork.timezone.app.persistence.TimezoneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TimezoneServiceImpl : TimezoneService {

    @Autowired
    private lateinit var repository: TimezoneRepository

    override fun getTimezoneInfo(latLng: LatLng): TimezoneInfo {

        val timezone = repository.getTimezone(latLng)
        return timezone
    }
}