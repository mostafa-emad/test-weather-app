package xebia.test.weather.forecast.data.ws.model.weather

import com.google.gson.annotations.SerializedName
import xebia.test.weather.forecast.data.ws.model.BaseModel

class ForecastDetails (
    var dt: String,

    var main: Main,

    var wind: Wind,

    var clouds: Clouds,

    var weather: List<WeatherDetails>,

    var rain: Rain,

    var sys: SysDetails,

    @SerializedName("dt_txt")
    var dtTxt: String

) : BaseModel()