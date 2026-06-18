package bibit.framework.tests.steps.mobile;

import bibit.framework.driver.MobileDriverFactory;
import bibit.framework.pages.mobile.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/** HomeStep class for mobile tests. */
public class HomeStep {

  private HomePage homePage;

  public HomeStep() {

    homePage = new HomePage(MobileDriverFactory.getDriver());
  }

  /** User click select product. */
  @When("Click select product {string}")
  public void Click_select_product(String product) {
    homePage.clickProduct(product);
  }

  /** User click icon filter. */
  @When("Click icon filter")
  public void Click_icon_filter() {
    homePage.clickFilter();
  }

  /** User choose filter. */
  @When("Choose filter {string}")
  public void Choose_filter(String filter) {
    homePage.clickFilterValue(filter);
  }

  /** User verify name filtered to be descending the first name is. */
  @Then("Name filtered to be descending the first name is {string}")
  public void Name_filtered_to_be_descending_the_first_name_is(String name) {
    Assert.assertTrue(homePage.isDisplayNameFilter(name));
  }

  /** User verify name filtered to be ascending the first price is. */
  @Then("Name filtered to be ascending the first price is {string}")
  public void Name_filtered_to_be_ascending_the_first_price_is(String price) {
    Assert.assertTrue(homePage.isDisplayPriceFilter(price));
  }
}
