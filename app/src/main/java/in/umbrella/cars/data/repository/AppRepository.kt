package `in`.umbrella.cars.data.repository


import `in`.umbrella.cars.data.model.DataResult
import `in`.umbrella.cars.data.model.carsEntity
import `in`.umbrella.cars.data.model.celebritiesEntity
import `in`.umbrella.cars.data.network.ApiError
import io.reactivex.disposables.Disposable


interface AppRepository {

    fun GetDataRep(

        success:(DataResult)->Unit,
        failure: (ApiError)->Unit ={},
        treminate :() ->Unit ={}

    ) :Disposable

    fun insertCelebrity(celebritiesEntity: celebritiesEntity): Disposable

    fun insertCars(carsEntity: carsEntity): Disposable

}