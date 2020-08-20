package com.stafftracking.project.chatblo.test;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.test.rule.ActivityTestRule;

import com.stafftracking.project.chatblo.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.internal.matchers.TypeSafeMatcher;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;

//import androidx.test.espresso.matcher.ViewMatchers;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class LoginActivitySteps {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);

    private Activity activity;

    @Before("@login-feature")
    public void setup() {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
    }

    @After("@login-feature")
    public void tearDown() {
        activityTestRule.finishActivity();
    }

    @Given("^I am on login screen")
    public void I_am_on_login_screen() {
        assertNotNull(activity);
    }

    @When("^I input email (\\S+)$")
    public void I_input_email(final String email) {
        onView(withId(R.id.login_email)).perform(typeText(email));
    }

    @When("^I input password \"(.*?)\"$")
    public void I_input_password(final String password) {
        onView(withId(R.id.login_password)).perform(typeText(password), closeSoftKeyboard());
    }

    @When("^I press submit button$")
    public void I_press_submit_button() {
        onView(withId(R.id.login_btn)).perform(click());

    }

    @Then("^I should see dashboard screen$")
    public void I_should_see_dashboard_screen() {
        onView(withId(R.id.dashboard));
//        onView(withId(R.id.dashboard)).check(matches(withText(R.string.login)));
    }

    @When("^I tap register button$")
    public void I_tap_register_button() {
        onView(withId(R.id.reg_create_btn)).perform(click());
    }

    @Then("^I should see error on the (\\S+)$")
    public void I_should_see_error_on_the_editTextView(final String viewName) {
        int viewId = (viewName.equals("email")) ? R.id.register_email : R.id.reg_password;
        int messageId = (viewName.equals("email")) ? R.string.msg_email_error : R.string.msg_password_error;
        onView(withId(viewId)).check(matches(hasErrorText(activity.getString(messageId))));
    }

    @Then("^I should (true|false) auth error$")
    public void I_should_see_auth_error(boolean shouldSeeError) {
        if (shouldSeeError) {
            onView(withId(R.id.register_email)).check(matches(isDisplayed()));
        } else {
            onView(withId(R.id.register_email)).check(matches(not(isDisplayed())));
        }
    }

    @Then("^I should see register screen$")
    public void I_should_see_register_screen() {
//        onView(withId(R.id.register)).check(matches(ViewMatchers.withText(R.string.signup)));
        onView(withId(R.id.register));
    }

    private static Matcher<? super View> hasErrorText(String expectedError) {
        return new ErrorTextMatcher(expectedError);
    }

    /**
     * Custom matcher to assert equal EditText.setError();
     */
    private static class ErrorTextMatcher extends TypeSafeMatcher<View> {

        private final String mExpectedError;

        private ErrorTextMatcher(String expectedError) {
            mExpectedError = expectedError;
        }

        @Override
        public boolean matchesSafely(View view) {
            if (!(view instanceof EditText)) {
                return false;
            }

            EditText editText = (EditText) view;

            return mExpectedError.equals(editText.getError().toString());
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("with error: " + mExpectedError);
        }
    }
}