package xebia.test.weather.forecast.data.repo

import android.content.Context
import xebia.test.weather.forecast.data.room.database.AppDatabase


open class BaseRepository (private val context: Context){
    protected var appDatabase : AppDatabase? = AppDatabase.getAppDatabase(context)

    companion object {
        private var instance: BaseRepository? = null
        fun getInstance(context: Context): BaseRepository {
            if (instance == null) {
                instance = BaseRepository(context = context)
            }
            return instance as BaseRepository
        }
    }
}