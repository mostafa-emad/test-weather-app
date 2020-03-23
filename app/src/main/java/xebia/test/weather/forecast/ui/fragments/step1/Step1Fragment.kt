package xebia.test.weather.forecast.ui.fragments.step1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.step1_fragment.view.*
import xebia.test.weather.forecast.R
import xebia.test.weather.forecast.R.layout.step1_fragment
import xebia.test.weather.forecast.data.ws.model.response.CityWeatherResponse
import xebia.test.weather.forecast.ui.adapters.CitiesWeatherRecyclerAdapter
import xebia.test.weather.forecast.ui.fragments.base.BaseFragment

class Step1Fragment : BaseFragment() {

    companion object {
        fun newInstance() = Step1Fragment()
    }

    init {
        layout = step1_fragment
    }

    private val cityWeatherEntities: ArrayList<CityWeatherResponse> = arrayListOf()
    private lateinit var viewModel: Step1ViewModel
    private lateinit var citiesWeatherRecyclerAdapter : CitiesWeatherRecyclerAdapter

    override fun initViews() {
        setTitle(resources.getString(R.string.step1_title))
        setBackEnabled(true)
        val layoutManager = LinearLayoutManager(activity,  LinearLayoutManager.VERTICAL,false)
        rootView.cities_weather_recycler.layoutManager = layoutManager
        citiesWeatherRecyclerAdapter = CitiesWeatherRecyclerAdapter(cityWeatherEntities, activity)
        rootView.cities_weather_recycler.adapter = citiesWeatherRecyclerAdapter


    }

    override fun doCreate() {
        rootView.submit_btn.setOnClickListener {
            val citiesValue = rootView.cities_txt.text.toString()
            if(citiesValue.isNotEmpty()){
                val citiesList = citiesValue.split(',')
                when {
                    citiesList.size < 3 -> {
                        Toast.makeText(activity,resources.getString(R.string.less_cities_count_msg),Toast.LENGTH_LONG).show()
                    }
                    citiesList.size > 7 -> {
                        Toast.makeText(activity,resources.getString(R.string.more_cities_count_msg),Toast.LENGTH_LONG).show()
                    }
                    else -> {
                        updateCitiesWeather(citiesList)
                    }
                }
            }
        }
    }

    private fun updateCitiesWeather(citiesList : List<String>){
        cityWeatherEntities.clear()
        citiesWeatherRecyclerAdapter.notifyDataSetChanged()
        viewModel.getCityWeatherLiveData(citiesList).observe(this, Observer<CityWeatherResponse> {
            it.let {
                cityWeatherEntities.add(it)
                citiesWeatherRecyclerAdapter.notifyDataSetChanged()
            }
            if(cityWeatherEntities.isNotEmpty()){
                rootView.no_data_available_txt.visibility = View.GONE
            }else{
                rootView.no_data_available_txt.visibility = View.VISIBLE
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Step1ViewModel::class.java)
        activity?.let {
            viewModel.init(it)
        }
    }

}
