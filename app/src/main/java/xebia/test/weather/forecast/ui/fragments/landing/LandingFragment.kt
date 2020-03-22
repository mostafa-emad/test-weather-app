package xebia.test.weather.forecast.ui.fragments.landing

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.landing_fragment.view.*
import xebia.test.weather.forecast.R
import xebia.test.weather.forecast.R.layout.landing_fragment
import xebia.test.weather.forecast.ui.fragments.base.BaseFragment

class LandingFragment : BaseFragment() {

    companion object {
        fun newInstance() = LandingFragment()
    }

    init {
        layout = landing_fragment
    }

    private lateinit var viewModel: LandingViewModel

    override fun initViews() {
        rootView.step1_btn.setOnClickListener {
            getNavController().navigate(R.id.action_open_step1Fragment)
        }

        rootView.step2_btn.setOnClickListener {
            getNavController().navigate(R.id.action_open_step2Fragment)
        }
    }

    override fun doCreate() {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LandingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
