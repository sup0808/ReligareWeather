package `in`.umbrella.cars.di.module


import `in`.umbrella.cars.di.builder.ViewModelBuilder
import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module(includes = [ViewModelBuilder::class])
class ContextModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}