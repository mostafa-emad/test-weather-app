package xebia.test.weather.forecast.data.ws.model.weather

import xebia.test.weather.forecast.data.ws.model.BaseModel

class WeatherDetails (
    var id : Int,

    var main : String,

    var description : String,

    var icon : String

) : BaseModel()