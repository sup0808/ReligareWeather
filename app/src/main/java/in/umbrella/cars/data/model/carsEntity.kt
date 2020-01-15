package `in`.umbrella.cars.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class celebritiesEntity(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String ?=null,
    @SerializedName("height") var height: String ?=null,
    @SerializedName("age") var age: Int,
    @SerializedName("popularity") var popularity: Int,
    @SerializedName("photo")  var photo :String?=null
)