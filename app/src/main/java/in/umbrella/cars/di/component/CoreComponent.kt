package `in`.umbrella.cars.di.component


import `in`.umbrella.cars.core.App
import `in`.umbrella.cars.di.builder.ActivityBuilder
import `in`.umbrella.cars.di.module.ContextModule
import `in`.umbrella.cars.di.module.DataBaseModule
import `in`.umbrella.cars.di.module.NetworkModule
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