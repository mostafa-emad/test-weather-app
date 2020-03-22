package xebia.test.weather.forecast.ui.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import xebia.test.weather.forecast.R
import xebia.test.weather.forecast.ui.activities.MainActivity

abstract class BaseFragment : Fragment() {

    protected var layout : Int = 0
    protected lateinit var rootView : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater.inflate(layout, container, false)

        initViews()
        doCreate()

        return rootView
    }

    abstract fun initViews()

    abstract fun doCreate()

    protected fun getNavController() : NavController{
        var controller : NavController? = null
        activity?.let {
            controller = Navigation.findNavController(it, R.id.container)
        }
       return controller!!
    }

    fun setBackEnabled(enabled : Boolean){
        activity.let {
            val value = it as MainActivity
            value.supportActionBar?.setDisplayHomeAsUpEnabled(enabled)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        setBackEnabled(false)
    }

}
