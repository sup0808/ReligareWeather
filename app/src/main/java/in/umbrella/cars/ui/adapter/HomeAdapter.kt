package `in`.religareweather.com.ui.weatherScreen


import `in`.umbrella.cars.R
import `in`.umbrella.cars.data.model.DataResult
import `in`.umbrella.cars.data.model.celebrities
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeAdapter(internal var context: Context, rlist: MutableList<DataResult>?) :
    RecyclerView.Adapter<HomeAdapter.Rholder>() {
    private val rlist: MutableList<DataResult>?

    var horizontalLayoutManagaerCele: LinearLayoutManager? = null
    var horizontalLayoutManagaercars: LinearLayoutManager? = null
    init {
        this.rlist = rlist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Rholder {
        val itemview = LayoutInflater.from(context).inflate(R.layout.home_adpter_layout, parent, false)
        return Rholder(itemview)
    }

    override fun onBindViewHolder(holder: Rholder, position: Int) {
        try {


            var data = rlist?.get(position)
              var celebritesData = data!!.celebrities
              val celbrityNameList = ArrayList(celebritesData.keys)
              val celbrityValueList = ArrayList(celebritesData.values)

              if (celebritesData.size > 0) {
                  horizontalLayoutManagaerCele = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                  holder.celeibrities_rv.setLayoutManager(horizontalLayoutManagaerCele)
                  holder.celeibrities_rv.setAdapter(CelebritiesAdapter( context,  celbrityNameList,celbrityValueList))
              }

            var carsData = data!!.cars
            val carsNameList = ArrayList(carsData.keys)
            val carsValueList = ArrayList(carsData.values)

            if (carsData.size > 0) {
                horizontalLayoutManagaerCele = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                holder.cars_rv.setLayoutManager(horizontalLayoutManagaerCele)
                holder.cars_rv.setAdapter(CarsAdapter( context,  carsNameList,carsValueList))
            }
        }
        catch (e: Exception){
            e.printStackTrace()
        }

    }

 /*   fun MangeCelibrityList(data: HashMap<String,celebrities>):MutableList<celibrity> {
        val list = mutableListOf<celibrity>()
        for (key in data.keys) {
            var celebrityAtt = data[key]
            list.add(
                celibrity(
                    key,
                    celebrityAtt!!.height,
                    celebrityAtt!!.age,
                    celebrityAtt!!.popularity,
                    celebrityAtt!!.photo
                )
            )
        }
        return list
    }*/


    fun add(list: MutableList<DataResult>) {
        rlist!!.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        rlist!!.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return rlist!!.size
    }

    inner class Rholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal  var celeibrities_rv: RecyclerView
        internal var cars_rv: RecyclerView


        init {
            celeibrities_rv = itemView.findViewById(R.id.celeibrities_rv)
            cars_rv = itemView.findViewById(R.id.cars_rv)

        }
    }
}