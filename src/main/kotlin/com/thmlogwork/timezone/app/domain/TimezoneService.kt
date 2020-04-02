package com.thmlogwork.timezone.app.domain

interface TimezoneService {

    fun getTimezoneInfo(latLng: LatLng): TimezoneInfo
}