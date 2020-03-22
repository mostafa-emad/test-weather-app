package xebia.test.weather.forecast.data.room.database;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import xebia.test.weather.forecast.data.room.Dao.CityDao;
import xebia.test.weather.forecast.data.room.Dao.CityWeatherDao;
import xebia.test.weather.forecast.data.room.entity.CityEntity;
import xebia.test.weather.forecast.data.room.entity.weather.Coordinates;
import xebia.test.weather.forecast.data.utils.Utils;
import xebia.test.weather.forecast.data.ws.model.CityModel;

//@Database(entities = {CityWeatherEntity.class , Clouds.class, Coordinates.class,
//        Main.class, SysDetails.class, WeatherDetails.class, Wind.class}, version = 1,exportSchema = false)

@Database(entities = {CityEntity.class, Coordinates.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "weather_forecast";
    private static AppDatabase appDatabase;

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, DB_NAME).allowMainThreadQueries().build();
        }
        return appDatabase;
    }

    public abstract CityWeatherDao cityWeatherDao();
    public abstract CityDao cityDao();

    public MutableLiveData<Boolean> initCitiesData(Context context){
        MutableLiveData<Boolean> initCitiesDataOperation = new MutableLiveData<>();

        if(!cityDao().getAll().isEmpty()) {
            initCitiesDataOperation.setValue(false);
            return initCitiesDataOperation;
        }

        String citiesJson = Utils.Companion.getJsonFromAssets(context,"city.list.json");
        if(citiesJson == null || citiesJson.isEmpty()){
            initCitiesDataOperation.setValue(false);
            return initCitiesDataOperation;
        }

        List<CityModel> citiesList = new Gson().fromJson(citiesJson, new TypeToken<List<CityModel>>(){}.getType());
        if(citiesList == null || citiesList.isEmpty()){
            initCitiesDataOperation.setValue(false);
            return initCitiesDataOperation;
        }

        List<CityEntity> entities = new ArrayList<>();
        for(CityModel city : citiesList){
            CityEntity entity = new CityEntity(city.getId(),city.getName(),city.getState(),
                    city.getCountry(),city.getCoord().getLon(),city.getCoord().getLat());

            entities.add(entity);
        }

        cityDao().inset(entities);
        initCitiesDataOperation.setValue(true);

        return initCitiesDataOperation;


    }

//    fun initCitiesData(context: Context) {
//        if(cityDao().all == null){
//            val citiesList : CitiesList = Gson().fromJson(
//                    Utils.getJsonFromAssets(context,"city.list.json"), CitiesList::class.java)
//
//            citiesList.let {
//                val entities :ArrayList<CityEntity> = arrayListOf()
//                for (city in citiesList.cities){
//                    val cityEntity = CityEntity(city.id,city.name,city.state,
//                            city.country,city.coord.lon,city.coord.lat)
//                    entities.add(cityEntity)
//                }
//                cityDao().inset(entities)
//            }
//        }
//    }

}
