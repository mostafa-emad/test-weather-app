package xebia.test.weather.forecast.ui.fragments.step1

import android.content.Context
import androidx.lifecycle.MutableLiveData
import xebia.test.weather.forecast.data.repo.WeatherRepository
import xebia.test.weather.forecast.data.ws.model.response.CityWeatherResponse
import xebia.test.weather.forecast.ui.fragments.base.BaseViewModel


class Step1ViewModel : BaseViewModel() {

    private var weatherRepository: WeatherRepository? = null

    override fun init(context: Context) {
        super.init(context)
        weatherRepository = WeatherRepository(context,this)
    }

    fun getCityWeatherLiveData(citiesList : List<String>): MutableLiveData<CityWeatherResponse> {
        if(!showLoading()){
            return MutableLiveData()
        }
        return weatherRepository!!.getCitiesWeatherData(citiesList)
    }
}
