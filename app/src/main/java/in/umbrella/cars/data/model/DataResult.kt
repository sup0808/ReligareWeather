package `in`.umbrella.cars.data.model

import com.google.gson.annotations.SerializedName

data class DataResult(
    @SerializedName("data")
    var celebrities :HashMap<String,celebrities>,
    var cars :HashMap<String,cars>
)

data class celebrities(
    var height: String ?=null,
    var age: Int,
    var popularity: Int,
    var photo :String?=null

)

data class cars(
    var photo :String?=null

)

