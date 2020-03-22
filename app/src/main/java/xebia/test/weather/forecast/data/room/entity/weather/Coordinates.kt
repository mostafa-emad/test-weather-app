package xebia.test.weather.forecast.data.room.entity.weather

import androidx.room.Entity
import androidx.room.PrimaryKey
import xebia.test.weather.forecast.data.room.entity.BaseEntity

@Entity(tableName = "coordinates")
data class Coordinates (
    @PrimaryKey
    var id : Int,
    var lon : Double,

    var lat : Double

) : BaseEntity()