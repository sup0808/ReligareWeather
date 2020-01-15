package `in`.umbrella.cars.di.builder


import `in`.umbrella.cars.di.qualifier.ViewModelKey
import `in`.umbrella.cars.ui.HomeScreen.HomeViewModel
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap



@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindLoadViewModel(loadViewModel: HomeViewModel): ViewModel


}