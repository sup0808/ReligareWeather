package `in`.umbrella.cars.ui.base




import `in`.umbrella.cars.util.NetworkUtils
import android.Manifest.permission
import android.app.ProgressDialog
import android.content.Context


import android.os.Bundle

import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<T : ViewDataBinding, V: BaseViewModel> : DaggerAppCompatActivity(){

  //  abstract class BaseActivity<T : ViewDataBinding, V: BaseViewModel>() :AppCompatActivity(){

    var progressDialog: ProgressDialog?=null

    lateinit var mViewDataBinding : T
    var baseViewModel : V ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        performDependancyInjection()
       // setContentView(getLayoutId())
       performDataBinding()
    }

    fun performDependancyInjection(){
        //AndroidInjection.inject(this)
    }

    fun performDataBinding(){
        mViewDataBinding = DataBindingUtil.setContentView(this,getLayoutId())
        this.baseViewModel = getViewModel()
        mViewDataBinding!!.setVariable(getBindingVariable(),baseViewModel)
        mViewDataBinding!!.executePendingBindings()
    }

     abstract fun getBindingVariable():Int

    @LayoutRes
     abstract fun getLayoutId(): Int

     abstract fun getViewModel() : V

      fun getViewDataBinding() : T {
          return mViewDataBinding
      }

    fun requestPerMission(){
        ActivityCompat.requestPermissions(this,arrayOf(permission.ACCESS_FINE_LOCATION,permission.READ_CONTACTS),1)
    }

    fun HideKeyBoard(){
        val view  = this.currentFocus
        if(view!=null){
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            if(inputMethodManager!= null){
                inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
            }

        }
    }

    fun isNetworkConnected() : Boolean{
        return NetworkUtils.isNetworkConnected(this)
    }

    fun hideLoading(){
        if(progressDialog!=null && progressDialog!!.isShowing){
            progressDialog!!.cancel()
        }
    }




}