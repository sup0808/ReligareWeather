package `in`.umbrella.cars.data.model

import com.google.gson.annotations.SerializedName

data class DataResult(

    var cars :HashMap<String,cars>,
    var celebrities :HashMap<String,celebrities>

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

