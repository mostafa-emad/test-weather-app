package xebia.test.weather.forecast.data.room.entity.weather

import androidx.room.Entity
import androidx.room.PrimaryKey
import xebia.test.weather.forecast.data.room.entity.BaseEntity

@Entity(tableName = "weather_wind")
data class Wind (
    @PrimaryKey
    var id:Int,

    var speed : Double,

    var deg : Double

) : BaseEntity()