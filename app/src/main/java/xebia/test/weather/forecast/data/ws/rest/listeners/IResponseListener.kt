package xebia.test.weather.forecast.data.ws.rest.listeners

import xebia.test.weather.forecast.data.ws.model.response.BaseResponse

interface IResponseListener {
    fun onSuccess(
        serviceName:String,
        result: BaseResponse?
    )
    fun onFailure(serviceName:String)
}
