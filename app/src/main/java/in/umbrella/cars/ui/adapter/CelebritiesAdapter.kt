package `in`.religareweather.com.ui.weatherScreen


import `in`.umbrella.cars.R
import `in`.umbrella.cars.data.model.DataResult
import `in`.umbrella.cars.data.model.celebrities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class CelebritiesAdapter(internal var context: Context, rlist: MutableList<String>?,valueList: MutableList<celebrities>?) :
    RecyclerView.Adapter<CelebritiesAdapter.Rholder>() {
    private val rlist: MutableList<String>?
    private val valueList: MutableList<celebrities>?


    init {
        this.rlist = rlist
        this.valueList =valueList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Rholder {
        val itemview = LayoutInflater.from(context).inflate(R.layout.celebrities_adapter, parent, false)
        return Rholder(itemview)
    }

    override fun onBindViewHolder(holder: Rholder, position: Int) {
        try {
               val data = rlist?.get(position)
               val value = valueList?.get(position)

            holder.nameData.text = data

            Picasso.with(context).load(value?.photo).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).fit()
                .into(holder.img_icon)


        }
        catch (e: Exception){
            e.printStackTrace()
        }

    }

    override fun getItemCount(): Int {
        return rlist!!.size
    }

    inner class Rholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal  var img_icon: ImageView
        internal var nameData: TextView


        init {
            img_icon = itemView.findViewById(R.id.img_icon)
            nameData = itemView.findViewById(R.id.name)

        }
    }
}