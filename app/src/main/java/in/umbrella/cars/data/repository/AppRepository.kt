package `in`.umbrella.cars.data.repository


import `in`.umbrella.cars.data.model.DataResult
import `in`.umbrella.cars.data.network.ApiError
import io.reactivex.disposables.Disposable


interface AppRepository {

    fun GetDataRep(
        country:String,
        success:(DataResult)->Unit,
        failure: (ApiError)->Unit ={},
        treminate :() ->Unit ={}

    ) :Disposable

}