package com.thmlogwork.timezone.app.rest

data class TimezoneResponse(val nameOfTimeZone: String,
                            val offsetFromUtc: String,
                            val currentLocalTime: String,
                            val currentUtcTime: String)
