package xebia.test.weather.forecast.data.room.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import xebia.test.weather.forecast.data.room.entity.CityEntity;

@Dao
public interface CityDao {
    @Query("SELECT * FROM city")
    LiveData<List<CityEntity>> getAllLiveData();

    @Query("SELECT * FROM city")
    List<CityEntity> getAll();

    @Query("SELECT * FROM city WHERE `name`=:name")
    CityEntity getCityWeatherByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inset(List<CityEntity> entities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inset(CityEntity entity);

}
