package `in`.umbrella.cars.data.db

import `in`.umbrella.cars.data.model.carsEntity
import `in`.umbrella.cars.data.model.celebritiesEntity
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [celebritiesEntity::class, carsEntity::class], version = AppDatabase.VERSION)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "UmbrellaData.db"
        const val VERSION = 2
    }
    abstract fun celebrityCarDao(): CelebrityCarDao
}