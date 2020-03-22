package xebia.test.weather.forecast.data.room.entity.weather

import androidx.room.Entity
import androidx.room.PrimaryKey
import xebia.test.weather.forecast.data.room.entity.BaseEntity

@Entity(tableName = "weather_cloud")
data class Clouds (
    @PrimaryKey
    var id:Int,
    var all : Double

) : BaseEntity()