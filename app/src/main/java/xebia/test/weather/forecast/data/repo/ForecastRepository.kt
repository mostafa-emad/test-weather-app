package xebia.test.weather.forecast.data.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import xebia.test.weather.forecast.data.ws.model.response.CityForecstResponse
import xebia.test.weather.forecast.data.ws.rest.ServiceGenerator
import xebia.test.weather.forecast.data.ws.rest.constants.ApiServicesNames
import xebia.test.weather.forecast.data.ws.rest.listeners.ILoadingListener

class ForecastRepository (context: Context, private val loadingListener: ILoadingListener) : BaseRepository(context){
    private val cityForecastData: MutableLiveData<CityForecstResponse> = MutableLiveData()

    fun getCityForecastData(lat : Double, lon : Double) : MutableLiveData<CityForecstResponse>  {
        val call = ServiceGenerator.clientApi.getCityForecastByCoord(lat,lon,ApiServicesNames.API_KEY)
        call.enqueue(object : Callback<CityForecstResponse> {
            override fun onResponse(call: Call<CityForecstResponse>, response: retrofit2.Response<CityForecstResponse>) {
                if (response.body() !== null) {
                    cityForecastData.value = response.body()
                    loadingListener.onComplete()
                }
            }

            override fun onFailure(call: Call<CityForecstResponse>, t: Throwable) {
                t.printStackTrace()
                loadingListener.onComplete()
            }
        })
        return cityForecastData
    }
}