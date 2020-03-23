package xebia.test.weather.forecast.ui.fragments.step2

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.*
import kotlinx.android.synthetic.main.step2_fragment.view.*
import xebia.test.weather.forecast.R
import xebia.test.weather.forecast.R.layout.step2_fragment
import xebia.test.weather.forecast.data.ws.model.response.CityForecstResponse
import xebia.test.weather.forecast.data.ws.model.weather.ForecastDetails
import xebia.test.weather.forecast.ui.adapters.CitiesForecastRecyclerAdapter
import xebia.test.weather.forecast.ui.fragments.base.BaseFragment

class Step2Fragment : BaseFragment() {

    companion object {
        fun newInstance() = Step2Fragment()
    }

    init {
        layout = step2_fragment
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private val cityForecastList : ArrayList<ForecastDetails> = arrayListOf()
    private lateinit var viewModel: Step2ViewModel
    private lateinit var citiesForecastAdapter : CitiesForecastRecyclerAdapter

    override fun initViews() {
        setTitle(resources.getString(R.string.step2_title))
        setBackEnabled(true)
        val layoutManager = LinearLayoutManager(activity,  LinearLayoutManager.VERTICAL,false)
        rootView.forecast_details_recycler.layoutManager = layoutManager
        citiesForecastAdapter = CitiesForecastRecyclerAdapter(cityForecastList, activity)
        rootView.forecast_details_recycler.adapter = citiesForecastAdapter

    }

    override fun doCreate() {
        detectLastLocation()
        rootView.update_btn.setOnClickListener {
            detectLastLocation()
        }
    }

    private fun updateCityForecastList(location : Location){
        location.let {
            cityForecastList.clear()
            citiesForecastAdapter.notifyDataSetChanged()
            viewModel.getCityForecastLiveData(it.latitude,it.latitude).observe(this, Observer<CityForecstResponse> { it ->
                it.let {
                    citiesForecastAdapter.cityName = it.city.name
                    cityForecastList.addAll(it.list)
                    citiesForecastAdapter.notifyDataSetChanged()
                }
                if(cityForecastList.isNotEmpty()){
                    rootView.no_data_available_txt.visibility = View.GONE
                }else{
                    rootView.no_data_available_txt.visibility = View.VISIBLE
                }
            })
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Step2ViewModel::class.java)
        activity?.let {
            viewModel.init(it)
        }
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager: LocationManager = activity?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    @SuppressLint("MissingPermission")
    private fun detectLastLocation() {
        if (isLocationEnabled()) {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity!!)
            fusedLocationClient.lastLocation.addOnCompleteListener(activity!!) { task ->
                val location: Location? = task.result
                if (location == null) {
                    requestNewLocationData()
                } else {
                    updateCityForecastList(location)
                }
            }
        } else {
            Toast.makeText(activity,resources.getString(R.string.gps_disabled_msg),Toast.LENGTH_LONG).show()
        }
    }

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        val mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 10000
        mLocationRequest.fastestInterval = 5000
        mLocationRequest.numUpdates = 1

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity!!)
        fusedLocationClient.requestLocationUpdates(
            mLocationRequest, mLocationCallback,
            Looper.myLooper()
        )
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            updateCityForecastList(locationResult.lastLocation)
        }
    }

}
