package bibit.framework.tests.steps.web;

import bibit.framework.driver.DriverFactory;
import bibit.framework.pages.web.ExplorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/** ExploreStep class for web tests. */
public class ExploreStep {

  private ExplorePage explorePage;

  public ExploreStep() {

    explorePage = new ExplorePage(DriverFactory.getDriver());
  }

  /** User already logged in and navigate to explore page. */
  @Given("user already logged in and navigate to explore page")
  public void user_already_logged_in_and_navigate_to_explore_page() {
    explorePage.openExplorePage();
  }

  /** User verify go to detail product page. */
  @Then("Go to detail product page")
  public void Go_to_detail_product_page() {
    Assert.assertTrue(explorePage.isSearchProductDisplayed());
  }

  /** User click product. */
  @When("click product")
  public void click_product() {
    explorePage.clickProduct();
  }

  /** User search product. */
  @When("user search product {string}")
  public void user_search_product(String s) {
    explorePage.searchProduct(s);
  }

  /** User click search product. */
  @When("user click search product")
  public void user_click_search_product() {
    explorePage.clickSearchProduct();
  }
}
