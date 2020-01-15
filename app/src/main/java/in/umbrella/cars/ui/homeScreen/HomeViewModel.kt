package `in`.umbrella.cars.ui.homeScreen

import `in`.umbrella.cars.data.model.DataResult
import `in`.umbrella.cars.data.network.ApiError
import `in`.umbrella.cars.data.repository.AppRepository
import `in`.umbrella.cars.ui.base.BaseViewModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class HomeViewModel @Inject constructor(appRepositoryobj: AppRepository) : BaseViewModel() {
    private val TAG = HomeViewModel::class.java.simpleName
    private val country ="India";

    public val currentWeather: MutableLiveData<DataResult> by lazy { MutableLiveData<DataResult>()   }


    val error : MutableLiveData<ApiError> by lazy {  MutableLiveData<ApiError>() }
    var appRepository: AppRepository?=null

    init{
        this.appRepository =  appRepositoryobj
    }

    fun GetData() : LiveData<DataResult>?{
        GetDataFromServer()

        return currentWeather;
    }

    private fun GetDataFromServer(){ //load Async task
        appRepository!!.GetDataRep({
            Log.e(TAG, "GetDataFromServer.success() called with: ${currentWeather.value}")
            currentWeather.postValue(it)
        },{
            Log.e(TAG, "GetDataFromServer.error() called with: $it")
            error.value = it
        },{

        }

        ).also { compositeDisposable!!.add(it) }
    }

}