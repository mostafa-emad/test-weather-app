package xebia.test.weather.forecast

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import xebia.test.weather.forecast.ui.activities.MainActivity


@RunWith(AndroidJUnit4::class)
class Step1FragmentTest {

    @Suppress("MemberVisibilityCanPrivate")
    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun checkCitiesInput() {
        onView(withId(R.id.step1_btn))
            .perform(typeText(""))
//
//        onView(withId(R.id.cities_txt))
//            .perform(typeText("Dubai,d,d"), closeSoftKeyboard())

//        Espresso.onView(ViewMatchers.withId(R.id.cities_txt)).
//        onView(withId(R.id.submit_btn)).perform(click())
    }
}