package xebia.test.weather.forecast.data.utils

import android.content.Context
import java.io.IOException

class Utils {

    companion object {
        fun getJsonFromAssets(context: Context, fileName: String): String? {
            val jsonString: String
            jsonString = try {
                val `is` = context.assets.open(fileName)
                val size = `is`.available()
                val buffer = ByteArray(size)
                `is`.read(buffer)
                `is`.close()
                String(buffer, Charsets.UTF_8)
            } catch (e: IOException) {
                e.printStackTrace()
                return null
            }
            return jsonString
        }
    }

}