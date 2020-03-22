package xebia.test.weather.forecast.ui.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_city_weather.view.*
import xebia.test.weather.forecast.R
import xebia.test.weather.forecast.data.ws.model.response.CityWeatherResponse
import java.util.*

class CitiesWeatherRecyclerAdapter(private val cityWeatherEntities: ArrayList<CityWeatherResponse>,
                                   activity: Activity?) : BaseRecyclerAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = viewHolder as MyViewHolder
        val model = cityWeatherEntities[position]
        holder.bind(model)
    }

    override fun getItemCount(): Int {
        return cityWeatherEntities.size
    }

    init {
        this.activity = activity
    }

    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_city_weather, parent, false)) {
        private val degree= "°C"

        @SuppressLint("SetTextI18n")
        fun bind(entity: CityWeatherResponse) {
            itemView.city_name_txt.text = entity.name

            val weather = entity.weather
            weather.let {
                if(it.isNotEmpty()) itemView.weather_desc_txt.text = entity.weather[0].description
            }

            val main = entity.main
            main.let {
                itemView.min_temperature_txt.text = "${main.tempMin} $degree"
                itemView.max_temperature_txt.text = "${main.tempMax} $degree"
            }

            val wind = entity.wind
            main.let {
                itemView.wind_speed_txt.text = "${wind.speed} m/s"
            }

        }

    }
}