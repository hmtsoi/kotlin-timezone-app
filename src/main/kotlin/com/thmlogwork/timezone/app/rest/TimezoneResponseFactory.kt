package com.thmlogwork.timezone.app.rest

import com.thmlogwork.timezone.app.domain.TimezoneInfo
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset

@Component
class TimezoneResponseFactory {

    fun parseToResponse(info: TimezoneInfo): TimezoneResponse {
        return TimezoneResponse(
                info.timezoneName,
                info.utcFormat,
                Instant.now()
                        .atZone(ZoneId.of(info.timezoneName)).toLocalDateTime().toString(),
                Instant.now()
                        .atOffset(ZoneOffset.UTC).toString()
        )
    }

}