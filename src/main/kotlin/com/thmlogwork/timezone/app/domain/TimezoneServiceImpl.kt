package com.thmlogwork.timezone.app.domain

import com.thmlogwork.timezone.app.persistence.TimezoneRepository
import org.springframework.stereotype.Service

@Service
class TimezoneServiceImpl(val repository: TimezoneRepository) : TimezoneService {

    override fun getTimezoneInfo(latLng: LatLng): TimezoneInfo {
        val timezone = repository.getTimezone(latLng)
        return timezone
    }
}