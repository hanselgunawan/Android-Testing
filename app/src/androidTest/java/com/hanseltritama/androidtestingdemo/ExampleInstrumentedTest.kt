package com.hanseltritama.androidtestingdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.hanseltritama.androidtestingdemo", appContext.packageName)
    }

    @Test
    fun userCanEnterFirstName() {
        onView(withId(R.id.firstName)).perform(typeText("Tony"), closeSoftKeyboard())
    }

    @Test
    fun userCanEnterLastName() {
        onView(withId(R.id.lastName)).perform(typeText("Stark"), closeSoftKeyboard())
    }

    @Test
    fun checkTextResult() {
        onView(withId(R.id.firstName)).perform(typeText("Brian"), closeSoftKeyboard())
        onView(withId(R.id.lastName)).perform(typeText("McKnight"), closeSoftKeyboard())
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.textResult)).check(matches(withText("Welcome, Brian McKnight!")))
    }

    @Test
    fun checkConfirmationScreenName() {
        onView(withId(R.id.firstName)).perform(typeText("Paul"), closeSoftKeyboard())
        onView(withId(R.id.lastName)).perform(typeText("Klein"), closeSoftKeyboard())
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.textResult)).check(matches(withText("Welcome, Paul Klein!")))
        onView(withId(R.id.buttonChangeActivity)).perform(click())
        onView(withId(R.id.textConfirmation)).check(matches(withText("Your name is Paul Klein")))
    }
}