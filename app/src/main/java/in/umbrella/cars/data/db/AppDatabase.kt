package `in`.umbrella.cars.data.db

import androidx.room.Database

//@Database(entities = [Food::class], version = AppDatabase.VERSION)
abstract class AppDatabase  {/* : RoomDatabase() {
    companion object {
        const val DB_NAME = "food.db"
        const val VERSION = 1
    }
    abstract fun foodDao(): FoodDao*/

    companion object {
        const val DB_NAME = "food.db"
        const val VERSION = 1
    }
}