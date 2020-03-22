package xebia.test.weather.forecast.ui.fragments.step2

import android.content.Context
import androidx.lifecycle.MutableLiveData
import xebia.test.weather.forecast.data.repo.ForecastRepository
import xebia.test.weather.forecast.data.ws.model.response.CityForecstResponse
import xebia.test.weather.forecast.ui.fragments.base.BaseViewModel


class Step2ViewModel : BaseViewModel() {

    private var forecastRepository: ForecastRepository? = null

    override fun init(context: Context) {
        super.init(context)
        forecastRepository = ForecastRepository(context,this)
    }

    fun getCityForecastLiveData(lat : Double, lon : Double): MutableLiveData<CityForecstResponse> {
        if(!showLoading()){
            return MutableLiveData()
        }
        return forecastRepository!!.getCityForecastData(lat,lon)
    }
}
