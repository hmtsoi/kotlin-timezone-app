package com.thmlogwork.timezone.app.persistence

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.locationtech.jts.geom.Geometry


@Entity
@Table(name = "timezones")
class TimezoneEntity {
    @Id
    @GeneratedValue
    var gid: Long? = null
    var objectid: Int? = null
    var scalerank: Int? = null
    var featurecla: String? = null
    var map_color6: Int? = null
    var map_color8: Int? = null
    var note: String? = null
    var zone: Double? = null
    var places: String? = null
    var iso_8601: String? = null
    var dst_places: String? = null
    var tz_namesum: Int? = null
    var utc_format: String? = null
    var tz_name1st: String? = null
    var time_zone: String? = null
    var geom: Geometry? = null
}