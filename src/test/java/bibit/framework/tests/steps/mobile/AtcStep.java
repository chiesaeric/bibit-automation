package bibit.framework.tests.steps.mobile;

import bibit.framework.driver.MobileDriverFactory;
import bibit.framework.pages.mobile.AtcPage;
import bibit.framework.pages.mobile.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/** AtcStep class for mobile tests. */
/**
 * @param driver WebDriver instance
 */
public class AtcStep {

  private LoginPage loginPage;
  private AtcPage atcPage;

  public AtcStep() {
    loginPage = new LoginPage(MobileDriverFactory.getDriver());

    atcPage = new AtcPage(MobileDriverFactory.getDriver());
  }

  /** User open mobile application and login with username and password. */
  /**
   * @param username Username
   * @param password Password
   */
  @Given("user open mobile application and login with username {string} and password {string}")
  public void user_open_mobile_application_and_login_with_username_and_password(
      String username, String password) {
    loginPage.waitMenuShow();
    loginPage.clickIconHamburger();
    loginPage.clickLoginMenu();
    loginPage.inputUsername(username);
    loginPage.inputPassword(password);
    loginPage.clickButtonLogin();
  }

  /** User choose color. */
  /**
   * @param color Color
   */
  @When("Choose color {string}")
  public void Choose_color(String color) {
    atcPage.chooseColor(color);
  }

  /** User choose quantity. */
  /**
   * @param qty Quantity
   */
  @When("Choose Qty {string}")
  public void Choose_Qty(String qty) {
    atcPage.chooseQty(qty);
  }

  /** User click button add to cart. */
  @When("Click button add to cart")
  public void Click_button_add_to_cart() {
    atcPage.clickAtc();
  }

  /** User go to cart page. */
  @When("Go to cart page")
  public void Go_to_cart_page() {
    atcPage.GoToCartPage();
  }

  /** User click checkout. */
  @When("Click checkout")
  public void Click_checkout() {
    atcPage.clickCheckout();
  }

  /** User input name. */
  /**
   * @param name Name
   */
  @When("Input name {string}")
  public void Input_name(String name) {
    atcPage.insertName(name);
  }

  /** User input address. */
  /**
   * @param address Address
   */
  @When("Input address {string}")
  public void Input_address(String address) {
    atcPage.insertAddress(address);
  }

  /** User input city. */
  /**
   * @param city City
   */
  @When("Input city {string}")
  public void Input_city(String city) {
    atcPage.insertCity(city);
  }

  /** User input zipcode. */
  /**
   * @param zip Zipcode
   */
  @When("Input zipcode {string}")
  public void Input_zipcode(String zip) {
    atcPage.insertZip(zip);
  }

  /** User input country. */
  /**
   * @param country Country
   */
  @When("Input country {string}")
  public void Input_country(String country) {
    atcPage.insertCountry(country);
  }

  /** User click payment. */
  @When("Click payment")
  public void Click_payment() {
    atcPage.clickPayment();
  }

  /** User input card name. */
  /**
   * @param cardName Card name
   */
  @When("Input card name {string}")
  public void Input_card_name(String cardName) {
    atcPage.insertCardName(cardName);
  }

  /** User input card number. */
  /**
   * @param cardNo Card number
   */
  @When("Input card number {string}")
  public void Input_card_number(String cardNo) {
    atcPage.insertCardNumber(cardNo);
  }

  /** User input card exp date. */
  /**
   * @param expDate Card exp date
   */
  @When("Input card exp date {string}")
  public void Input_card_exp_date(String expDate) {
    atcPage.insertExpDate(expDate);
  }

  /** User input card security code. */
  /**
   * @param securityCode Card security code
   */
  @When("Input card security code {string}")
  public void Input_card_security_code(String securityCode) {
    atcPage.securityCode(securityCode);
  }

  /** User click review order. */
  @When("Click review order")
  public void Click_review_order() {
    atcPage.clickReviewOrder();
  }

  /** User click place order. */
  @When("Click place order")
  public void Click_place_order() {
    atcPage.clickPlaceOrder();
  }

  /** User checkout successfully. */
  @Then("checkout successfully")
  public void checkout_successfully() {
    Assert.assertTrue(atcPage.isDisplaySuccess());
  }
}
