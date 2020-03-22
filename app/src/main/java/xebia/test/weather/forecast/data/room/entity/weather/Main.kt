package xebia.test.weather.forecast.data.room.entity.weather

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import xebia.test.weather.forecast.data.room.entity.BaseEntity

@Entity(tableName = "weather_main")
data class Main (
    @PrimaryKey
    var id:Int,

    var temp : Double,

    var pressure : Double,

    var humidity : Double,

    @SerializedName("temp_min")
    var tempMin : Double,

    @SerializedName("temp_max")
    var tempMax : Double

) : BaseEntity()