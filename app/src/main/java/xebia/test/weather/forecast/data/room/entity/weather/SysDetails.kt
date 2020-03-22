package xebia.test.weather.forecast.data.room.entity.weather

import androidx.room.Entity
import androidx.room.PrimaryKey
import xebia.test.weather.forecast.data.room.entity.BaseEntity

@Entity(tableName = "weather_sys")
data class SysDetails (
    var type : Int,

    @PrimaryKey
    var id : Int,

    var message : String,

    var country : String,

    var sunrise : Long,

    var sunset : Long

) : BaseEntity()