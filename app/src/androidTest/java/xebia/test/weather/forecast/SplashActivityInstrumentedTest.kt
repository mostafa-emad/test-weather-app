package xebia.test.weather.forecast

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import xebia.test.weather.forecast.ui.activities.SplashActivity


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
class SplashActivityInstrumentedTest : BaseInstrumentedTest() {

    private var device : UiDevice? = null

    @get:Rule
    var activityRule: ActivityTestRule<SplashActivity>
            = ActivityTestRule(SplashActivity::class.java)


    @Before
    fun setup() {
        this.device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

    @Test
    fun testFeedbackLocationPermissionDenied() {
        val denyButton = this.device?.findObject(UiSelector().text("DENY"))
        val permissionDeniedMessage = this.device?.findObject(UiSelector().text("Permission denied"))

        denyButton!!.click()

        assert(permissionDeniedMessage!!.exists())
    }

    @Test
    fun testFeedbackLocationPermissionAllowed() {
        val allowButton = this.device?.findObject(UiSelector().text("ALLOW"))
        val permissionAllowedMessage = this.device?.findObject(UiSelector().text("Permission allowed"))
        allowButton!!.click()
        assert(permissionAllowedMessage!!.exists())
    }
}
