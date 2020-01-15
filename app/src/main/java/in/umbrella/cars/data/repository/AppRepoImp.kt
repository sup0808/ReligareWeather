package `in`.umbrella.cars.data.repository


import `in`.umbrella.cars.data.model.DataResult
import `in`.umbrella.cars.data.network.ApiDisposable
import `in`.umbrella.cars.data.network.ApiError
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
    override fun GetDataRep(
        success: (DataResult) -> Unit,
        failure: (ApiError) -> Unit,
        treminate: () -> Unit
    ): Disposable {
        return apiService.GetData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate(treminate)
            .subscribeWith(
                ApiDisposable(
                success = {
                    success(it)
                },
                failure = failure
            )

            )
    }


}