package bibit.framework.tests.steps.web;


import org.junit.Assert;

import bibit.framework.driver.DriverFactory;
import bibit.framework.pages.web.ExplorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class ExploreStep {


    private ExplorePage explorePage;



    public ExploreStep() {


        explorePage =
            new ExplorePage(
                DriverFactory.getDriver()
            );

    }



    @Given("user already logged in and navigate to explore page")
    public void user_already_logged_in_and_navigate_to_explore_page() {
        // Write code here that turns the phrase above into concrete actions
        explorePage.openExplorePage();
    }

    @Then("Go to detail product page")
    public void Go_to_detail_product_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(
            explorePage.isSearchProductDisplayed()
        );
    }

    @When("click product")
    public void click_product() {
        // Write code here that turns the phrase above into concrete actions
        explorePage.clickProduct();

    }

    @When("user search product {string}")
    public void user_search_product(String s) {
        // Write code here that turns the phrase above into concrete actions
        explorePage.searchProduct(s);
    }

    @When("user click search product")
    public void user_click_search_product() {
        // Write code here that turns the phrase above into concrete actions
        explorePage.clickSearchProduct();
    }
}