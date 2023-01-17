package com.thmlogwork.timezone.app.persistence

import com.thmlogwork.timezone.app.domain.LatLng
import com.thmlogwork.timezone.app.domain.TimezoneInfo
import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.springframework.stereotype.Service

@Service
class TimezoneRepositoryImpl(val jpaRepository: TimezonesJpaRepository) : TimezoneRepository {

    override fun getTimezone(latLng: LatLng): TimezoneInfo {

        val point = GeometryFactory().createPoint(Coordinate(latLng.lon, latLng.lat));
        point.srid = 4326

        val entity = jpaRepository.getTimezone(point)
        return TimezoneInfo(utcFormat = entity!!.utc_format!!, timezoneName = entity.tz_name1st!!)
    }
}