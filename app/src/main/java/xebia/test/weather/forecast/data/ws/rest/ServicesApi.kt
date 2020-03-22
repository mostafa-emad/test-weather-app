package xebia.test.weather.forecast.data.ws.rest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import xebia.test.weather.forecast.data.ws.model.response.CityForecstResponse
import xebia.test.weather.forecast.data.ws.model.response.CityWeatherResponse
import xebia.test.weather.forecast.data.ws.rest.constants.ApiServicesNames

interface ServicesApi {

    @GET(ApiServicesNames.GET_CITY_WEATHER)
    fun getCityWeather(@Query(ApiServicesNames.QUERY_CITY_NAME) q : String,
                       @Query(ApiServicesNames.QUERY_API_KEY) key : String): Call<CityWeatherResponse>


    @GET(ApiServicesNames.GET_CITY_WEATHER)
    fun getCityWeatherByCoord(@Query(ApiServicesNames.QUERY_COORD_LAT) lat : Double,
                              @Query(ApiServicesNames.QUERY_COORD_LON) lon : Double,
                              @Query(ApiServicesNames.QUERY_API_KEY) key : String): Call<CityWeatherResponse>

    @GET(ApiServicesNames.GET_CITY_WEATHER)
    fun getCityWeatherById(@Query(ApiServicesNames.QUERY_CITY_ID) id : Int,
                           @Query(ApiServicesNames.QUERY_API_KEY) key : String): Call<CityWeatherResponse>


    @GET(ApiServicesNames.GET_CITY_FORECAST)
    fun getCityForecastByCoord(@Query(ApiServicesNames.QUERY_COORD_LAT) lat : Double,
                               @Query(ApiServicesNames.QUERY_COORD_LON) lon : Double,
                               @Query(ApiServicesNames.QUERY_API_KEY) key : String): Call<CityForecstResponse>

}
