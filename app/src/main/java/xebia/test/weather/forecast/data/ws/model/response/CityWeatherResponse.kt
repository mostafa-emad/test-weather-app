package xebia.test.weather.forecast.data.ws.model.response

import com.google.gson.annotations.SerializedName
import xebia.test.weather.forecast.data.ws.model.weather.*

data class CityWeatherResponse (
    @SerializedName("id")
    var id: String,

    @SerializedName("name")
    var name: String,

    var coord: Coordinate,

    var sys: SysDetails,

    var main: Main,

    var wind: Wind,

    var clouds: Clouds,

    var weather: List<WeatherDetails>,

    var cod: String,

    var visibility: String,

    var base: String,

    var dt: String

) : BaseResponse()