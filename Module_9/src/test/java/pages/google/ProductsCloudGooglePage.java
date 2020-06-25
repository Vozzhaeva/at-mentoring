package pages.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class ProductsCloudGooglePage extends AbstractPage {

    @FindBy(partialLinkText = "See pricing")
    private WebElement seePricingButton;

    protected ProductsCloudGooglePage(WebDriver driver) {
        super(driver);
    }

    public PricingCloudGooglePage clickPricing() {
        seePricingButton.click();
        return new PricingCloudGooglePage(driver);
    }

}



