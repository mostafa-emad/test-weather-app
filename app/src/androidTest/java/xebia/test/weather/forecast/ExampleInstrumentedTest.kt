package xebia.test.weather.forecast

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("xebia.test.weather.forecast", appContext.packageName)
    }

    @Test
    fun checkCitiesInput() {
        Espresso.onView(ViewMatchers.withId(R.id.cities_txt))
            .perform(ViewActions.typeText("Dubai,Cairo,London"))
        Espresso.onView(ViewMatchers.withId(R.id.submit_btn)).perform(ViewActions.click())
    }
}
