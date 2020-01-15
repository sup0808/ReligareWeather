package `in`.umbrella.cars.ui.homeScreen

import `in`.umbrella.cars.data.model.*
import `in`.umbrella.cars.data.network.ApiError
import `in`.umbrella.cars.data.repository.AppRepository
import `in`.umbrella.cars.ui.base.BaseViewModel
import android.util.Log
import androidx.core.graphics.alpha
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.lang.Exception
import javax.inject.Inject

class HomeViewModel @Inject constructor(appRepositoryobj: AppRepository) : BaseViewModel() {
    private val TAG = HomeViewModel::class.java.simpleName
    private val country ="India";

    public val dataResult: MutableLiveData<DataResult> by lazy { MutableLiveData<DataResult>()   }


    val error : MutableLiveData<ApiError> by lazy {  MutableLiveData<ApiError>() }
    var appRepository: AppRepository?=null

    init{
        this.appRepository =  appRepositoryobj
    }

    fun GetData() : LiveData<DataResult>?{
        GetDataFromServer()

        return dataResult;
    }

    private fun GetDataFromServer(){ //load Async task
        appRepository!!.GetDataRep({
            Log.e(TAG, "GetDataFromServer.success() called with: ${dataResult.value}")
            dataResult.postValue(it)

            InsertCelebrity(it.celebrities)
            InsertCars(it.cars)

        },{
            Log.e(TAG, "GetDataFromServer.error() called with: $it")
            error.value = it
        },{

        }

        ).also { compositeDisposable!!.add(it) }
    }

     fun InsertCelebrity(data: HashMap<String, celebrities>){
         try {
             val celbrityNameList = ArrayList(data.keys)
             val celbrityValueList = ArrayList(data.values)

             if (celbrityNameList.size > 0) {
                 for (i in 0..celbrityNameList.size-1) {
                     appRepository!!.insertCelebrity(
                         celebritiesEntity(
                             0,
                             celbrityNameList.get(i),
                             celbrityValueList.get(i).height,
                             celbrityValueList.get(i).age,
                             celbrityValueList.get(i).popularity,
                             celbrityValueList.get(i).photo
                         )
                     ).also { compositeDisposable.add(it) }
                 }
             }
         }
         catch(e:Exception){
             e.printStackTrace()
         }
    }

    fun InsertCars(data: HashMap<String, cars>){
        try {
            val carsNameList = ArrayList(data.keys)
            val carsValueList = ArrayList(data.values)

            if (carsNameList.size > 0) {
                for (i in 0..carsNameList.size-1) {
                    appRepository!!.insertCars(
                        carsEntity(
                            0,
                            carsNameList.get(i),
                            carsValueList.get(i).photo
                        )
                    ).also { compositeDisposable.add(it) }
                }
            }
        }
        catch(e:Exception){
            e.printStackTrace()
        }
    }

}