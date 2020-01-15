package `in`.umbrella.cars

import `in`.religareweather.com.ui.weatherScreen.HomeAdapter
import `in`.umbrella.cars.data.model.DataResult
import `in`.umbrella.cars.databinding.ActivityMainBinding
import `in`.umbrella.cars.ui.base.BaseActivity
import `in`.umbrella.cars.ui.homeScreen.HomeViewModel
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding,HomeViewModel>() {

    private val TAG = MainActivity::class.java.simpleName

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit  var homeViewModel: HomeViewModel
    lateinit var activityMainBinding: ActivityMainBinding

    var context: Context?=null

    val adapter : HomeAdapter by lazy { HomeAdapter(this,arrayListOf()) }



    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): HomeViewModel {
        homeViewModel = ViewModelProviders.of(this,viewModelFactory)[HomeViewModel::class.java]
        return homeViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context= this;

        homeViewModel.GetData()

        with(homeViewModel) {
            dataResult.observe(this@MainActivity, Observer {

                initView(it)
            })
            error.observe(this@MainActivity, Observer {

                Toast.makeText(context, context?.getString(R.string.empty_list), android.widget.Toast.LENGTH_LONG).show()

            })
        }

    }

    private fun initView(data: DataResult) {
        recyler_main.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyler_main.adapter = adapter

        if (data!=null) {
            val list = mutableListOf<DataResult>()
            list.add(data)
            adapter.clear()
            adapter.add(list)

        }else{
            Toast.makeText(context, context?.getString(R.string.empty_list), android.widget.Toast.LENGTH_LONG).show()
        }
    }

}
