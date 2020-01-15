package `in`.umbrella.cars.data.repository


import `in`.umbrella.cars.data.network.ApiService
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class AppRepoImp(
    val apiService: ApiService

) : AppRepository {

    private val TAG = AppRepoImp::class.java.simpleName






}