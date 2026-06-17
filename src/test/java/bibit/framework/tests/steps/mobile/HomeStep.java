package bibit.framework.tests.steps.mobile;

import org.junit.Assert;

import bibit.framework.driver.MobileDriverFactory;
import bibit.framework.pages.mobile.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStep {
    
    private HomePage homePage;

    public HomeStep(){

            homePage =
            new HomePage(
                MobileDriverFactory.getDriver()
            );


    }

    @When("Click select product {string}")
    public void Click_select_product(String product) {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickProduct(product);
    }

    @When("Click icon filter")
    public void Click_icon_filter() {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickFilter();
    }

    @When("Choose filter {string}")
    public void Choose_filter(String filter) {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickFilterValue(filter);
    }

    @Then("Name filtered to be descending the first name is {string}")
    public void Name_filtered_to_be_descending_the_first_name_is(String name) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(homePage.isDisplayNameFilter(name));
    }

    @Then("Name filtered to be ascending the first price is {string}")
    public void Name_filtered_to_be_ascending_the_first_price_is(String price) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(homePage.isDisplayPriceFilter(price));
    }

    


}
