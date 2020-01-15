package `in`.umbrella.cars.util

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtils {

    companion object{

        fun isNetworkConnected(context: Context) : Boolean{
            val connectivityManage = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if(connectivityManage!=null){
                val networkInfo = connectivityManage!!.getActiveNetworkInfo()
                return networkInfo!=null && networkInfo.isConnectedOrConnecting
            }
            return false;

        }
    }
}