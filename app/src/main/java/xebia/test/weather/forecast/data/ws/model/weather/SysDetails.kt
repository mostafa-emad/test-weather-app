package xebia.test.weather.forecast.data.ws.model.weather

import xebia.test.weather.forecast.data.ws.model.BaseModel

class SysDetails (
    var type : Int,

    var id : Int,

    var message : String,

    var country : String,

    var sunrise : Long,

    var sunset : Long

) : BaseModel()