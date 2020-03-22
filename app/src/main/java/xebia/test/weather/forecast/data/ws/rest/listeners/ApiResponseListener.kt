package xebia.test.weather.forecast.data.ws.rest.listeners

import xebia.test.weather.forecast.data.ws.model.response.CityWeatherResponse


interface ApiResponseListener {
    fun onSuccess(operation: String, result: CityWeatherResponse)
    fun onFailure(operation: String, errorMessage: String)
}
