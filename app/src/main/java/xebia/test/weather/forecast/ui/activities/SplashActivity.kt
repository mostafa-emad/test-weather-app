package xebia.test.weather.forecast.ui.activities

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import xebia.test.weather.forecast.R
import xebia.test.weather.forecast.data.utils.AndroidPermissions

class SplashActivity : AppCompatActivity() {
    private val ACCESS_COARSE_LOCATION = 100
    private lateinit var mPermissions : AndroidPermissions


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        mPermissions = AndroidPermissions(this,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

        if (mPermissions.checkPermissions()) {
            complete()
        } else {
            mPermissions.requestPermissions(ACCESS_COARSE_LOCATION)
        }


    }

    private fun complete() {
        startActivity( Intent(this@SplashActivity, MainActivity::class.java))
        finish()

//        AppDatabase.getAppDatabase(this).initCitiesData(this)
//            .observe(this, Observer {
//                startActivity( Intent(this@SplashActivity, MainActivity::class.java))
//                finish()
//            })
    }
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        if (mPermissions.areAllRequiredPermissionsGranted(permissions, grantResults)) {
            complete()
        } else {
            Toast.makeText(this,resources.getString(R.string.permissions_error_msg),Toast.LENGTH_LONG).show()
        }
    }

}
