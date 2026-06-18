package bibit.framework.pages.web;

import bibit.framework.config.ConfigReader;
import bibit.framework.objects.web.ExploreObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/** ExplorePage class for web pages. */
public class ExplorePage extends BasePage {

    private ExploreObject objectExplore;

    /** ExplorePage constructor. */
    /**
     * @param driver WebDriver instance
     */
    public ExplorePage(WebDriver driver) {
        super(driver);
        objectExplore = new ExploreObject();
        PageFactory.initElements(driver, objectExplore);
    }

    /** Open Explore page on web page. */
    /**
     * @param driver WebDriver instance
     */
    public void openExplorePage() {
        openUrl(ConfigReader.get("web.url") + "explore");
        wait.until(isTrue -> isDisplayed(objectExplore.aProductInvest));
    }

    /** Check if search product button is displayed on web page. */
    /**
     * @return True if search product button is displayed, false otherwise
     */
    public boolean isSearchProductDisplayed() {
        return isDisplayed(objectExplore.btnBuy);
    }

    /** Click search product button on web page. */
    /**
     * @param driver WebDriver instance
     */
    /**
     * @param s Search product name
     */
    public void clickSearchProduct() {
        click(objectExplore.pSearchProduct);
        wait.until(isTrue -> isDisplayed(objectExplore.inputSearchProduct));
    }

    /** Search product on web page. */
    /**
     * @param driver WebDriver instance
     */
    /**
     * @param s Search product name
     */
    public void searchProduct(String s) {
        type(objectExplore.inputSearchProduct, s);
        wait.until(isTrue -> isDisplayed(objectExplore.lstProduct));
    }

    /** Click product on web page. */
    /**
     * @param driver WebDriver instance
     */
    /**
     * @param s Search product name
     */
    public void clickProduct() {
        click(objectExplore.lstProduct);
        wait.until(isTrue -> isDisplayed(objectExplore.btnBuy));
    }
}
