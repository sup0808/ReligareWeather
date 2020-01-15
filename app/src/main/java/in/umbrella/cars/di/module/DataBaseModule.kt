package `in`.umbrella.cars.di.module

import `in`.religareweather.com.data.db.AppDatabase
import android.app.Application
import androidx.room.Room
import androidx.room.Room.databaseBuilder

import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class DataBaseModule {


    /*@Provides
    fun provideUserDao(appDataBase: AppDatabase): FoodDao {
        return appDataBase.foodDao()
    }*/
}