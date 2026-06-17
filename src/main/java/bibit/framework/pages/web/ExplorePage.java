package bibit.framework.pages.web;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import bibit.framework.config.ConfigReader;
import bibit.framework.objects.web.ExploreObject;



public class ExplorePage extends BasePage {
   

    private ExploreObject objectExplore;



    public ExplorePage(
            WebDriver driver
    ){

        super(driver);
        objectExplore = new ExploreObject();
        PageFactory.initElements(
            driver,
            objectExplore
        );

    }




    public void openExplorePage() {
        openUrl(
            ConfigReader.get("web.url")+"explore"
        );
        wait.until(isTrue -> isDisplayed(objectExplore.aProductInvest));
    }



    public boolean isSearchProductDisplayed(){
        return isDisplayed(
            objectExplore.btnBuy
        );
    }




    public void clickSearchProduct() {
        click(objectExplore.pSearchProduct);
        wait.until(isTrue -> isDisplayed(objectExplore.inputSearchProduct));
    }




    public void searchProduct(String s) {
        type(objectExplore.inputSearchProduct, s);
        wait.until(isTrue -> isDisplayed(objectExplore.lstProduct));
    }




    public void clickProduct() {
        click(objectExplore.lstProduct);
        wait.until(isTrue -> isDisplayed(objectExplore.btnBuy));
    }


}