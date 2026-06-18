package bibit.framework.objects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** ExploreObject class for web explore page. */
public class ExploreObject {
    @FindBy(xpath = "(//*[@listtype='card'])[1]")
    public WebElement aProductInvest;

    @FindBy(xpath = "//*[text()='Cari produk investasi']")
    public WebElement pSearchProduct;

    @FindBy(xpath = "//*[@placeholder='Cari produk']")
    public WebElement inputSearchProduct;

    @FindBy(xpath = "(//*[@class='content-box']/div)[1]")
    public WebElement lstProduct;

    @FindBy(xpath = "//button[@data-testid='stock-explore-action-buy']")
    public WebElement btnBuy;
}
