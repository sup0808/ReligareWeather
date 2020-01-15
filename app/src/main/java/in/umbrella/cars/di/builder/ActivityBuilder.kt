package `in`.umbrella.cars.di.builder


import `in`.religareweather.com.ui.LoadScreen


import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {



    @ContributesAndroidInjector(modules = [LoadScreenFragmentProviders::class])
    abstract fun bindLoadScreen(): LoadScreen
}