package pages.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

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
        driver.get(PAGE_URL);
        return this;
    }

    public CloudGooglePage typeButtonProducts() {
        productsButton.click();
        return this;
    }

    public ProductsCloudGooglePage typeButtonSeeAllProducts() {
        allProductsButton.click();
        return new ProductsCloudGooglePage(driver);
    }

}


