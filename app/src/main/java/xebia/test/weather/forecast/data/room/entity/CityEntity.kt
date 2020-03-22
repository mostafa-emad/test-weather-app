package xebia.test.weather.forecast.data.room.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city")
data class CityEntity (
    @PrimaryKey
    @NonNull
    var id:Int,

    var name : String,

    var state : String,

    var country : String,

    var lon : Double,

    var lat : Double

) : BaseEntity()