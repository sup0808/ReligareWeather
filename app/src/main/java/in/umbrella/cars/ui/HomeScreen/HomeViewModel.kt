package `in`.umbrella.cars.ui.HomeScreen

import `in`.umbrella.cars.data.repository.AppRepository
import `in`.umbrella.cars.ui.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(appRepositoryobj: AppRepository) : BaseViewModel() {
    private val TAG = HomeViewModel::class.java.simpleName
}