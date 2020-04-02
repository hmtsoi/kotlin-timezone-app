package com.thmlogwork.timezone.app.persistence

import com.thmlogwork.timezone.app.domain.LatLng
import com.thmlogwork.timezone.app.domain.TimezoneInfo
import com.vividsolutions.jts.geom.Coordinate
import com.vividsolutions.jts.geom.GeometryFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TimezoneRepositoryImpl : TimezoneRepository {

    @Autowired
    private lateinit var jpaRepository: TimezonesJpaRepository

    override fun getTimezone(latLng: LatLng): TimezoneInfo {

        val point = GeometryFactory().createPoint(Coordinate(latLng.lon, latLng.lat));
        point.srid = 4326

        val entity = jpaRepository.getTimezone(point)
        return TimezoneInfo(utcFormat = entity!!.utc_format!!, timezoneName = entity.tz_name1st!!)
    }
}