package bibit.framework.tests.steps.mobile;

import bibit.framework.driver.MobileDriverFactory;
import bibit.framework.pages.mobile.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/** LoginStep class for mobile tests. */
public class LoginStep {

  private LoginPage loginPage;

  public LoginStep() {
    loginPage = new LoginPage(MobileDriverFactory.getDriver());
  }

  /** User open mobile application. */
  @Given("user open mobile application")
  public void user_open_mobile_application() {
    loginPage.waitMenuShow();
  }

  /** User click login menu. */
  @When("Click login menu")
  public void Click_login_menu() {
    loginPage.clickLoginMenu();
  }

  /** User click burger icon. */
  @When("Click burger icon")
  public void Click_burger_icon() {
    loginPage.clickIconHamburger();
  }

  /** User verify login successfully. */
  @Then("Login successfully")
  public void Login_successfully() {
    loginPage.clickIconHamburger();
    Assert.assertTrue(loginPage.isLogin());
  }

  /** User input password. */
  @When("password {string}")
  public void password_quot(String password) {
    loginPage.inputPassword(password);
  }

  /** User input username. */
  @When("Input username {string}")
  public void Input_username(String username) {
    loginPage.inputUsername(username);
  }

  /** User click button login. */
  @When("click button login")
  public void click_button_login() {
    loginPage.clickButtonLogin();
  }
}
