package `in`.umbrella.cars.di.module


import `in`.umbrella.cars.data.db.AppDatabase
import `in`.umbrella.cars.data.db.CelebrityCarDao
import android.app.Application
import androidx.room.Room


import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUserDao(appDataBase: AppDatabase): CelebrityCarDao {
        return appDataBase.celebrityCarDao()
    }
}