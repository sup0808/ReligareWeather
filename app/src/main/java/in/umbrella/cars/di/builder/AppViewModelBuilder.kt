package `in`.umbrella.cars.di.builder


import `in`.religareweather.com.di.qualifier.ViewModelKey


import `in`.religareweather.com.ui.loadScreen.LoadViewModel
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap



@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(LoadViewModel::class)
    abstract fun bindLoadViewModel(loadViewModel: LoadViewModel): ViewModel


}