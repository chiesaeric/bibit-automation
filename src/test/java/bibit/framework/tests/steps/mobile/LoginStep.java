package bibit.framework.tests.steps.mobile;

import org.junit.Assert;

import bibit.framework.driver.MobileDriverFactory;
import bibit.framework.pages.mobile.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

    private LoginPage loginPage;

    public LoginStep(){
        loginPage =
            new LoginPage(
                MobileDriverFactory.getDriver()
            );

    }

    @Given("user open mobile application")
    public void user_open_mobile_application(){
        // Write code here that turns the phrase above into concrete actions
          loginPage.waitMenuShow();
    }

    @When("Click login menu")
    public void Click_login_menu() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickLoginMenu();
    }

    @When("Click burger icon")
    public void Click_burger_icon() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickIconHamburger();
    }

    @Then("Login successfully")
    public void Login_successfully() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickIconHamburger();
        Assert.assertTrue(loginPage.isLogin());
    }

    @When("password {string}")
    public void password_quot(String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.inputPassword(password);
    }

    @When("Input username {string}")
    public void Input_username(String username) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.inputUsername(username);
    }

    @When("click button login")
    public void click_button_login() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickButtonLogin();
    }



}
