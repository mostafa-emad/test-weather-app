package xebia.test.weather.forecast.ui.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_city_forecast.view.*
import xebia.test.weather.forecast.R
import xebia.test.weather.forecast.data.ws.model.weather.ForecastDetails
import java.text.SimpleDateFormat
import java.util.*

class CitiesForecastRecyclerAdapter(private val cityForecastList: ArrayList<ForecastDetails>,
                                    activity: Activity?) : BaseRecyclerAdapter() {

    var cityName : String = ""
        // getter
        get() = field

        // setter
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = viewHolder as MyViewHolder
        val model = cityForecastList[position]
        holder.bind(model,cityName)
    }

    override fun getItemCount(): Int {
        return cityForecastList.size
    }

    init {
        this.activity = activity
    }

    @SuppressLint("SimpleDateFormat")
    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_city_forecast, parent, false)) {
        var serverFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        var displayFormat = SimpleDateFormat("HH:mm MMM dd")
        private val degree= "°C"

        @SuppressLint("SetTextI18n")
        fun bind(entity: ForecastDetails, cityName : String) {
            itemView.city_name_txt.text = cityName

            val weather = entity.weather
            weather.let {
                if(it.isNotEmpty()) itemView.weather_desc_txt.text = entity.weather[0].description
            }

            val main = entity.main
            main.let {
                itemView.min_temperature_txt.text = "${main.tempMin.toInt()} $degree"
                itemView.max_temperature_txt.text = "${main.tempMax.toInt()} $degree"
                itemView.temperature_txt.text = "${main.temp.toInt()} $degree"
            }

            val wind = entity.wind
            main.let {
                itemView.wind_speed_txt.text = "${wind.speed} m/s"
            }

            entity.dt.let {
                try {
                    itemView.date_time_txt.text = displayFormat.format(serverFormat.parse(it))
                }
                catch (e: Exception) {
                    itemView.date_time_txt.text = it
                }
            }
        }

    }
}