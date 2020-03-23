package xebia.test.weather.forecast

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class Step1InstrumentedTest : MainActivityInstrumentedTest() {

    @Before
    fun openStep1(){
        setUp()
        onView(withId(R.id.step1_btn)).perform(click())
    }

    @Test
    private fun testSuccessCitiesCount() {
        onView(withId(R.id.cities_txt)).perform(typeText("Dubai,Cairo,London"))
        onView(withId(R.id.submit_btn)).perform(click())
    }

    @Test
    private fun testMoreCitiesCount() {
        onView(withId(R.id.cities_txt)).perform(typeText("Dubai,Cairo,London" +
                ",Paris,Sharjah,Germany,China,Tokyo"))
        onView(withId(R.id.submit_btn)).perform(click())
        onView(withId(R.id.cities_txt)).perform(clearText())
    }

    @Test
    private fun testLessCitiesCount() {
        onView(withId(R.id.cities_txt)).perform(typeText("Dubai,Cairo"))
        onView(withId(R.id.submit_btn)).perform(click())
        onView(withId(R.id.cities_txt)).perform(clearText())
    }

//    @Test
//    fun validateCities(){
//
//        testLessCitiesCount()
//
//        sleepLessTime()
//
//        testMoreCitiesCount()
//
//        sleepLessTime()
//
//        testSuccessCitiesCount()
//    }
}
