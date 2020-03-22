package xebia.test.weather.forecast.data.ws.rest.constants

object ApiServicesNames {
    const val BASE_URL = "https://samples.openweathermap.org/data/2.5/"
    const val API_KEY = "bedf5d76621bfb6aa983fc26f1e8c4bf"

    const val CONNECTION_TIMEOUT = 10
    const val READ_TIMEOUT = 2
    const val WRITE_TIMEOUT = 2

    //services
    const val GET_CITY_WEATHER = "weather"
    const val GET_CITY_FORECAST = "forecast"

    //parameters
    const val QUERY_COORD_LAT = "lat"
    const val QUERY_COORD_LON = "lon"
    const val QUERY_CITY_ID = "id"
    const val QUERY_CITY_NAME = "q"
    const val QUERY_API_KEY = "appid"
}
