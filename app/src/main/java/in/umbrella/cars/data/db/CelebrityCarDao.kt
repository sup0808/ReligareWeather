package `in`.umbrella.cars.data.db

import `in`.umbrella.cars.data.model.carsEntity
import `in`.umbrella.cars.data.model.celebritiesEntity
import androidx.room.*

@Dao
interface CelebrityCarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCelebrity(celebrity: celebritiesEntity): Long

    @Delete
    fun deleteCelebrity(celebrity: celebritiesEntity): Int

    @Query("SELECT * from celebritiesEntity")
    fun selectAllFoods(): MutableList<celebritiesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCars(cars: carsEntity): Long

}