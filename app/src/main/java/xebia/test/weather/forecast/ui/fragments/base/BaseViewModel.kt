package xebia.test.weather.forecast.ui.fragments.base

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModel
import xebia.test.weather.forecast.R
import xebia.test.weather.forecast.data.ws.rest.listeners.ILoadingListener

@Suppress("DEPRECATION")
open class BaseViewModel : ViewModel() , ILoadingListener {

    lateinit var context : Context
    private var loadingDialog : Dialog? = null

    open fun init(context: Context) {
        this.context = context
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivity =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        @SuppressLint("MissingPermission") val info =
            connectivity.allNetworkInfo
        if (info != null) {
            for (i in info.indices) {
                if (info[i].state == NetworkInfo.State.CONNECTED) {
                    return true
                }
            }
        }
        val activeNetworkInfo = connectivity.activeNetworkInfo
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) return true
        return false
    }

    fun showLoading() : Boolean {
        if (!isNetworkAvailable()) {
            Toast.makeText(context,context.resources.getString(R.string.no_internet_msg),
                Toast.LENGTH_LONG).show()
            return false
        }
        if(loadingDialog == null){
            loadingDialog = Dialog(context)
            val inflate = LayoutInflater.from(context).inflate(R.layout.layout_loading, null)
            loadingDialog?.setContentView(inflate)
            loadingDialog?.setCancelable(false)
            loadingDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        loadingDialog?.show()

        return true
    }

    override fun onComplete() {
        loadingDialog.let {
            loadingDialog?.dismiss()
        }
    }
}
