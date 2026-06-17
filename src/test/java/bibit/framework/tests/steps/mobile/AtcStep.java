package bibit.framework.tests.steps.mobile;

import org.junit.Assert;

import bibit.framework.driver.MobileDriverFactory;
import bibit.framework.pages.mobile.AtcPage;
import bibit.framework.pages.mobile.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AtcStep {

    private LoginPage loginPage;
    private AtcPage atcPage;

    public AtcStep(){
        loginPage =
            new LoginPage(
                MobileDriverFactory.getDriver()
            );

            atcPage =
            new AtcPage(
                MobileDriverFactory.getDriver()
            );


    }

    @Given("user open mobile application and login with username {string} and password {string}")
    public void user_open_mobile_application_and_login_with_username_and_password(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.waitMenuShow();
        loginPage.clickIconHamburger();
        loginPage.clickLoginMenu();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickButtonLogin();

    }

    @When("Choose color {string}")
    public void Choose_color(String color) {
        // Write code here that turns the phrase above into concrete actions
        atcPage.chooseColor(color);
    }

    @When("Choose Qty {string}")
    public void Choose_Qty(String qty) {
        // Write code here that turns the phrase above into concrete actions
        atcPage.chooseQty(qty);
    }

    @When("Click button add to cart")
    public void Click_button_add_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        atcPage.clickAtc();
    }

    @When("Go to cart page")
    public void Go_to_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        atcPage.GoToCartPage();
    }

    @When("Click checkout")
    public void Click_checkout() {
        // Write code here that turns the phrase above into concrete actions
        atcPage.clickCheckout();
    }

    @When("Input name {string}")
    public void Input_name(String name) {
        // Write code here that turns the phrase above into concrete actions
        atcPage.insertName(name);
    }

    @When("Input address {string}")
    public void Input_address(String address) {
        // Write code here that turns the phrase above into concrete actions
        atcPage.insertAddress(address);
    }

    @When("Input city {string}")
    public void Input_city(String city) {
        // Write code here that turns the phrase above into concrete actions
        atcPage.insertCity(city);
    }

    @When("Input zipcode {string}")
    public void Input_zipcode(String zip) {
        // Write code here that turns the phrase above into concrete actions
        atcPage.insertZip(zip);
    }

    @When("Input country {string}")
    public void Input_country(String country) {
        // Write code here that turns the phrase above into concrete actions
        atcPage.insertCountry(country);
    }

    @When("Click payment")
    public void Click_payment() {
        // Write code here that turns the phrase above into concrete actions
        atcPage.clickPayment();
    }

    @When("Input card name {string}")
    public void Input_card_name(String cardName) {
        // Write code here that turns the phrase above into concrete actions
        atcPage.insertCardName(cardName);
    }

    @When("Input card number {string}")
    public void Input_card_number(String cardNo) {
        // Write code here that turns the phrase above into concrete actions
        atcPage.insertCardNumber(cardNo);
    }

    @When("Input card exp date {string}")
    public void Input_card_exp_date(String expDate) {
        // Write code here that turns the phrase above into concrete actions
        atcPage.insertExpDate(expDate);
    }

    @When("Input card security code {string}")
    public void Input_card_security_code(String securityCode) {
        // Write code here that turns the phrase above into concrete actions
        atcPage.securityCode(securityCode);
    }

    @When("Click review order")
    public void Click_review_order() {
        // Write code here that turns the phrase above into concrete actions
        atcPage.clickReviewOrder();
    }

    @When("Click place order")
    public void Click_place_order() {
        // Write code here that turns the phrase above into concrete actions
        atcPage.clickPlaceOrder();
    }

    @Then("checkout successfully")
    public void checkout_successfully() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(atcPage.isDisplaySuccess());
    }


}
