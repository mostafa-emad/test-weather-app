package xebia.test.weather.forecast.data.ws.model.response

import xebia.test.weather.forecast.data.ws.model.CityModel
import xebia.test.weather.forecast.data.ws.model.weather.ForecastDetails

data class CityForecstResponse (
    var cod: String,

    var message: String,

    var cnt: String,

    var list: List<ForecastDetails> = arrayListOf(),

    var city: CityModel

) : BaseResponse()