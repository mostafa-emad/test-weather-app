package xebia.test.weather.forecast.data.ws.model.weather

import com.google.gson.annotations.SerializedName
import xebia.test.weather.forecast.data.ws.model.BaseModel

class Rain (

    @SerializedName("3h")
    var threeHours : String

) : BaseModel()