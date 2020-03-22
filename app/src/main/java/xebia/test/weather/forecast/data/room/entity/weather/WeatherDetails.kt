package xebia.test.weather.forecast.data.room.entity.weather

import androidx.room.Entity
import androidx.room.PrimaryKey
import xebia.test.weather.forecast.data.room.entity.BaseEntity

@Entity(tableName = "weather_details")
data class WeatherDetails (
    @PrimaryKey
    var id : Int,

    var main : String,

    var description : String,

    var icon : String

) : BaseEntity()