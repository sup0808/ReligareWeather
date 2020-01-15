package `in`.umbrella.cars.di.component

import `in`.religareweather.com.core.App
import `in`.religareweather.com.di.builder.ActivityBuilder
import `in`.religareweather.com.di.module.ContextModule
import `in`.religareweather.com.di.module.DataBaseModule
import `in`.religareweather.com.di.module.NetworkModule
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class,  ActivityBuilder::class,
     DataBaseModule::class, ContextModule::class])

interface CoreComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }




}