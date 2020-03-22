package xebia.test.weather.forecast.data.ws.model

import xebia.test.weather.forecast.data.ws.model.weather.Coordinate

class CityModel (
    var id:Int,

    var name : String,

    var state : String,

    var country : String,

    var coord : Coordinate = Coordinate(0.0,0.0)

) : BaseModel()