package com.stafftracking.project.chatblo;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
//import
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class SendMessageTest {
    @Rule
    public ActivityTestRule<RegisterActivity> activity_registerActivityTestRule = new ActivityTestRule<>(RegisterActivity.class);
    @Test
    public void RegisterValidationTest() {
        onView(withId(R.id.chat_message_view)).perform(typeText( "hello" ));
        closeSoftKeyboard();

        onView(withId(R.id.chat_send_btn)).perform(click());
    }
}
