package com.thmlogwork.timezone.app.persistence

import com.thmlogwork.timezone.app.domain.LatLng
import com.thmlogwork.timezone.app.domain.TimezoneInfo

interface TimezoneRepository {

    fun getTimezone(latLng: LatLng): TimezoneInfo
}