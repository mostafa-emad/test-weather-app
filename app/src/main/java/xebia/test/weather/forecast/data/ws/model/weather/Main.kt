package xebia.test.weather.forecast.data.ws.model.weather

import com.google.gson.annotations.SerializedName
import xebia.test.weather.forecast.data.ws.model.BaseModel

data class Main (
    var temp : Double,

    var pressure : Double,

    var humidity : Double,

    @SerializedName("temp_kf")
    var tempKF : Double,

    @SerializedName("grnd_level")
    var grndLevel : Double,

    @SerializedName("sea_level")
    var seaLevel : Double,

    @SerializedName("temp_min")
    var tempMin : Double,

    @SerializedName("temp_max")
    var tempMax : Double

) : BaseModel()