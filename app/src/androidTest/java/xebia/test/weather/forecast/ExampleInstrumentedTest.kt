package xebia.test.weather.forecast

import androidx.navigation.fragment.NavHostFragment
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import xebia.test.weather.forecast.ui.activities.MainActivity


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

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

//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("xebia.test.weather.forecast", appContext.packageName)
//    }

//    @Test
//    fun checkCitiesInput() {
//        Espresso.onView(ViewMatchers.withId(R.id.cities_txt))
//            .perform(ViewActions.typeText("Dubai,Cairo,London"))
//        Espresso.onView(ViewMatchers.withId(R.id.submit_btn)).perform(ViewActions.click())
//    }

    @Test
    fun test(){
        onView(withId(R.id.step1_btn)).perform(click())
    }
}
