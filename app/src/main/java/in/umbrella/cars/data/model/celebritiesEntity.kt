package `in`.umbrella.cars.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class carsEntity(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String ?=null,
    @SerializedName("photo")  var photo :String?=null
)