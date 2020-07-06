package pages.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import static utils.SeleniumUtils.highlighterMethod;

public class CloudGooglePage extends AbstractPage {

    private static final String PAGE_URL = "https://cloud.google.com";

    @FindBy(linkText = "Products")
    private WebElement productsButton;

    @FindBy(xpath = "//a/div[contains(text(),'See all products')]")
    private WebElement allProductsButton;

    public CloudGooglePage(WebDriver driver) {
        super(driver);
    }

    public CloudGooglePage openPage() {
        driver.get(getPageUrl());
        return this;
    }

    public static String getPageUrl() {
        return PAGE_URL;
    }

    public CloudGooglePage typeButtonProducts() {
        highlighterMethod(productsButton, driver);
        productsButton.click();
        return this;
    }

    public ProductsCloudGooglePage typeButtonSeeAllProducts() {
        highlighterMethod(allProductsButton, driver);
        allProductsButton.click();
        return new ProductsCloudGooglePage(driver);
    }

}


