package bibit.framework.tests.steps.web;

import bibit.framework.driver.DriverFactory;
import bibit.framework.pages.web.ProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/** ProfileStep class for web tests. */
public class ProfileStep {

  private ProfilePage page;

  public ProfileStep() {

    page = new ProfilePage(DriverFactory.getDriver());
  }

  /** User verify success logout. */
  @Then("Success logout")
  public void Success_logout() {
    Assert.assertTrue(page.isLogOut());
  }

  /** User click logout. */
  @When("user click logout")
  public void user_click_logout() {
    page.clickLogout();
  }

  /** User already logged in and navigate to profile page. */
  @Given("user already logged in and navigate to profile page")
  public void user_already_logged_in_and_navigate_to_profile_page() {
    page.openProfilePage();
  }
}
