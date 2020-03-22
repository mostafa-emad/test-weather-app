package xebia.test.weather.forecast.data.room.entity

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.PrimaryKey
import xebia.test.weather.forecast.data.ws.model.weather.*

//@Entity(tableName = "city_weather")
data class CityWeatherEntity (
        @PrimaryKey
        @NonNull
        var id: String,

        var name: String,

        @Embedded(prefix = "coor_")
        var coord: Coordinate,

        @Embedded(prefix = "sys_")
        var sys: SysDetails,

        @Embedded(prefix = "main_")
        var main: Main,

        @Embedded(prefix = "wind_")
        var wind: Wind,

        @Embedded(prefix = "clouds_")
        var clouds: Clouds,

        @Embedded(prefix = "weather_")
        var weather: List<WeatherDetails>,

        var cod: String,

        var visibility: String,

        var base: String,

        var dt: String

) : BaseEntity()