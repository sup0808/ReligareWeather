package `in`.umbrella.cars.di.builder



import `in`.umbrella.cars.MainActivity


import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {



    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}