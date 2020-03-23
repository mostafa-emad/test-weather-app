package xebia.test.weather.forecast

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
class Step2InstrumentedTest : MainActivityInstrumentedTest() {

    @Test
    fun openStep2(){
        onView(withId(R.id.step2_btn)).perform(click())
    }
}
