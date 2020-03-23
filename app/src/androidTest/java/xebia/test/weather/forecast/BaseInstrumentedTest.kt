package xebia.test.weather.forecast

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
open class BaseInstrumentedTest {

    private val lessTimeSeconds = 3
    private val longTimeSeconds = 5

    @After
    fun onComplete(){
        sleepLongTime()
    }

    fun sleepLongTime() {
        sleepTime(longTimeSeconds)
    }

    fun sleepLessTime() {
        sleepTime(lessTimeSeconds)
    }

    fun sleepTime(seconds : Int) {
        try {
            Thread.sleep(seconds * 1000L)
        }catch (e : java.lang.Exception){
            e.printStackTrace()
        }
    }
}
