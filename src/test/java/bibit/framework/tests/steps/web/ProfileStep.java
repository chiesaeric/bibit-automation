package bibit.framework.tests.steps.web;


import org.junit.Assert;

import bibit.framework.driver.DriverFactory;
import bibit.framework.pages.web.ProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class ProfileStep {


    private ProfilePage page;



    public ProfileStep() {


        page =
            new ProfilePage(
                DriverFactory.getDriver()
            );

    }


    @Then("Success logout")
    public void Success_logout() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(page.isLogOut());
    }

    @When("user click logout")
    public void user_click_logout() {
        page.clickLogout();
    }

    @Given("user already logged in and navigate to profile page")
    public void user_already_logged_in_and_navigate_to_profile_page() {
        // Write code here that turns the phrase above into concrete actions
        page.openProfilePage();
    }


}