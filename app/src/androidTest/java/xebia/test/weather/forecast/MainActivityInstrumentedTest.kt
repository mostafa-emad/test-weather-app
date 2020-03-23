package xebia.test.weather.forecast

import androidx.navigation.fragment.NavHostFragment
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import xebia.test.weather.forecast.ui.activities.MainActivity


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
open class MainActivityInstrumentedTest : BaseInstrumentedTest() {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        val host = NavHostFragment.create(R.navigation.nav_graph)

        InstrumentationRegistry.getInstrumentation().targetContext
        activityRule.activity.supportFragmentManager.beginTransaction().replace(R.id.container, host).setPrimaryNavigationFragment(host).commit()

    }
}
