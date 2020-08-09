package com.stafftracking.project.chatblo;
import androidx.test.rule.ActivityTestRule;

//import com.stafftracking.project.chatblo.RegisterActivity;

import org.junit.Rule;
import org.junit.Test;
//import

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class RegisterValidationTest {
    @Rule
    public ActivityTestRule<RegisterActivity> activity_registerActivityTestRule = new ActivityTestRule<>(RegisterActivity.class);
    @Test
    public void RegisterValidationTest() {
        onView(withId(R.id.register_display_name)).perform(typeText( "Ujjwal" ));
        closeSoftKeyboard();
        onView(withId(R.id.register_email)).perform(typeText( "ujjwal.bhusal@gmail.com" ));
        closeSoftKeyboard();
        onView(withId(R.id.reg_phone)).perform(typeText( "009779880446213" ));
        closeSoftKeyboard();
        onView(withId(R.id.reg_password)).perform(typeText( "1234abcd" ));
        closeSoftKeyboard();
        onView(withId(R.id.reg_create_btn)).perform(click());
    }
}
