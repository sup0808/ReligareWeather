package `in`.umbrella.cars.data.network


import `in`.umbrella.cars.data.model.DataResult
import io.reactivex.Observable

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("1gaa29")
    fun GetData(): Observable<DataResult>


}