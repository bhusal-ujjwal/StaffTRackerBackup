//package com.stafftracking.project.chatblo;
//
//
//import androidx.test.rule.ActivityTestRule;
//
//import org.junit.Rule;
//import org.junit.Test;
//
//import static androidx.test.espresso.Espresso.onView;
//import static androidx.test.espresso.action.ViewActions.click;
//import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
//import static androidx.test.espresso.action.ViewActions.typeText;
//import static androidx.test.espresso.matcher.ViewMatchers.withId;
//
//public class LoginValidationTest {
//    @Rule
//    public ActivityTestRule<LoginActivity> activity_loginActivityTestRule = new ActivityTestRule<>(LoginActivity.class);
//
//    @Test
//    public void LoginValidationTest() {
//        onView(withId(R.id.login_email)).perform(typeText( "ujjwal.bhusal@gmail.com" ));
//        closeSoftKeyboard();
//        onView(withId(R.id.login_password)).perform(typeText( "1234abcd" ));
//        closeSoftKeyboard();
//        onView(withId(R.id.login_btn)).perform(click());
//    }
//}
