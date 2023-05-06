package com.example.career.activities

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.career.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class formTest{

    @Rule
    /*@JvmField
    val activityRule = ActivityTestRule(form::class.java)*/

    @Test
    fun testSaveFormData() {
        // Fill out the form
        onView(withId(R.id.edtLname)).perform(typeText("John Doe"))
        onView(withId(R.id.edtEmail)).perform(typeText("johndoe@example.com"))
        onView(withId(R.id.edtAge)).perform(typeText("30"))
        onView(withId(R.id.edtPhone)).perform(typeText("1234567890"))
        onView(withId(R.id.edtExperience)).perform(typeText("5"))
        onView(withId(R.id.tvSalary)).perform(typeText("50000"))
        onView(withId(R.id.edtQual)).perform(typeText("Bachelor's degree"))

        // Close the keyboard
        onView(isRoot()).perform(closeSoftKeyboard())

        // Click the save button
        onView(withId(R.id.btnSaveData)).perform(click())

        // Assert that the data was saved correctly
        onView(withId(R.id.edtLname)).check(matches(withText("John Doe")))
        onView(withId(R.id.edtEmail)).check(matches(withText("johndoe@example.com")))
        onView(withId(R.id.edtAge)).check(matches(withText("30")))
        onView(withId(R.id.edtPhone)).check(matches(withText("1234567890")))
        onView(withId(R.id.edtExperience)).check(matches(withText("5")))
        onView(withId(R.id.tvSalary)).check(matches(withText("50000")))
        onView(withId(R.id.edtQual)).check(matches(withText("Bachelor's degree")))
    }

}