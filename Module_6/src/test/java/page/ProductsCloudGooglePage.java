package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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



