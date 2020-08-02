//package com.stafftracking.project.chatblo.test;
//
//        import android.content.Intent;
//
//        import androidx.test.espresso.Espresso;
//        import androidx.test.rule.ActivityTestRule;
//
//        import com.stafftracking.project.chatblo.R;
//        import com.stafftracking.project.chatblo.RegisterActivity;
//        import com.stafftracking.project.chatblo.SplashActivity;
//
//        import org.junit.Assert;
//        import org.junit.Rule;
//
//        import cucumber.api.java.After;
//        import cucumber.api.java.Before;
//        import cucumber.api.java.en.Given;
//        import cucumber.api.java.en.Then;
//        import cucumber.api.java.en.When;
//
//        import static androidx.test.espresso.Espresso.onView;
//        import static androidx.test.espresso.action.ViewActions.click;
//        import static androidx.test.espresso.matcher.ViewMatchers.withId;
//        import static junit.framework.TestCase.assertNotNull;
//
//public class Splash {
//    @Rule
//    private ActivityTestRule<SplashActivity> activityTestRule = new ActivityTestRule<>(SplashActivity.class);
//    private SplashActivity activity;
//
//    @Given("^I am on application drawer$")
//    public void I_am_on_application_drawer() {
//        assertNotNull(activity);
//    }
//
//    @When("^I click on tracker application$")
//    public void I_click_on_tracker_application() {
//        assertNotNull(activity);
//
//    }
//
//    @Then("^I should see spalsh screen with app logo$")
//    public void I_should_see_dashboard_screen() {
//        onView(withId(R.id.splash));
//
//    }
//}