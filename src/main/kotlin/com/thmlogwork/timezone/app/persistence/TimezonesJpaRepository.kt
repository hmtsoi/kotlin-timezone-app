package com.thmlogwork.timezone.app.persistence

import org.locationtech.jts.geom.Point
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TimezonesJpaRepository : JpaRepository<TimezoneEntity, Long> {

    @Query("SELECT e from TimezoneEntity e WHERE FUNCTION('st_contains', e.geom, :point) = TRUE")
    fun getTimezone(@Param("point") point: Point): TimezoneEntity?
}