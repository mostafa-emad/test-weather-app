package xebia.test.weather.forecast.data.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import xebia.test.weather.forecast.data.room.Dao.CityDao
import xebia.test.weather.forecast.data.ws.model.response.BaseResponse
import xebia.test.weather.forecast.data.ws.model.response.CityForecstResponse
import xebia.test.weather.forecast.data.ws.model.response.CityWeatherResponse
import xebia.test.weather.forecast.data.ws.rest.ServiceGenerator
import xebia.test.weather.forecast.data.ws.rest.constants.ApiServicesNames
import xebia.test.weather.forecast.data.ws.rest.listeners.ILoadingListener
import xebia.test.weather.forecast.data.ws.rest.listeners.IResponseListener
import java.util.*


class WeatherRepository (context: Context, private val loadingListener: ILoadingListener) : BaseRepository(context),IResponseListener{
//    private var cityWeatherDao : CityWeatherDao? = appDatabase?.cityWeatherDao()
    private var cityDao : CityDao? = appDatabase?.cityDao()
    private val citiesStack = Stack<String>()
    private val citiesWeatherData : MutableLiveData<CityWeatherResponse> = MutableLiveData()


    fun getCitiesWeatherData(citiesList : List<String>) : MutableLiveData<CityWeatherResponse>  {
        for (item in citiesList.reversed()){
            citiesStack.push(item)
        }
        getCityWeatherData(citiesStack.pop(), this)
        return citiesWeatherData
    }

    private fun getCityWeatherData(cityDetails : String, listener: IResponseListener) {
        val call = ServiceGenerator.clientApi.getCityWeather(cityDetails,ApiServicesNames.API_KEY)
        call.enqueue(object : Callback<CityWeatherResponse> {
            override fun onResponse(call: Call<CityWeatherResponse>, response: retrofit2.Response<CityWeatherResponse>) {
                if (response.body() !== null) {
                    listener.onSuccess(ApiServicesNames.GET_CITY_WEATHER,response.body())
                }
            }

            override fun onFailure(call: Call<CityWeatherResponse>, t: Throwable) {
                t.printStackTrace()
                listener.onFailure(ApiServicesNames.GET_CITY_WEATHER)
            }
        })
    }

    private fun getCityWeatherById(cityName : String, listener: IResponseListener) {
        val entity = cityDao?.getCityWeatherByName(cityName)
        var cityId = 0
        entity?.let {
            cityId = it.id
        }
        val call = ServiceGenerator.clientApi.getCityWeatherById(cityId,ApiServicesNames.API_KEY)
        call.enqueue(object : Callback<CityWeatherResponse> {
            override fun onResponse(call: Call<CityWeatherResponse>, response: retrofit2.Response<CityWeatherResponse>) {
                if (response.body() !== null) {
                    listener.onSuccess(ApiServicesNames.GET_CITY_WEATHER,response.body())
                }
            }

            override fun onFailure(call: Call<CityWeatherResponse>, t: Throwable) {
                t.printStackTrace()
                listener.onFailure(ApiServicesNames.GET_CITY_WEATHER)
            }
        })
    }

    fun getCityForecastData(lat : Double, lon : Double,listener: IResponseListener) {
        val call = ServiceGenerator.clientApi.getCityForecastByCoord(lat,lon,ApiServicesNames.API_KEY)
        call.enqueue(object : Callback<CityForecstResponse> {
            override fun onResponse(call: Call<CityForecstResponse>, response: retrofit2.Response<CityForecstResponse>) {
                if (response.body() !== null) {
                    listener.onSuccess(ApiServicesNames.GET_CITY_FORECAST,response.body())
                }
            }

            override fun onFailure(call: Call<CityForecstResponse>, t: Throwable) {
                t.printStackTrace()
                listener.onFailure(ApiServicesNames.GET_CITY_FORECAST)
            }
        })
    }

    override fun onSuccess(serviceName: String, result: BaseResponse?) {
        val cityWeatherResponse = result as CityWeatherResponse?
        citiesWeatherData.value = cityWeatherResponse
//        updateDB(cityWeatherResponse)
        Thread.sleep(500)
        if(!citiesStack.isEmpty()){
            getCityWeatherById(citiesStack.pop(), this)
        }else{
            loadingListener.onComplete()
        }
    }

    override fun onFailure(serviceName: String) {
        if(!citiesStack.isEmpty()){
            getCityWeatherById(citiesStack.pop(), this)
        }else{
            loadingListener.onComplete()
        }
    }

}