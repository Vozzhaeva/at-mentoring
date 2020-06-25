package pages.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class PricingCloudGooglePage extends AbstractPage {

    @FindBy(partialLinkText = "Calculators")
    private WebElement calculatorsButton;

    protected PricingCloudGooglePage(WebDriver driver) {
        super(driver);
    }

    public CalculatorCloudGooglePage clickCalculators() {
        calculatorsButton.click();
        return new CalculatorCloudGooglePage(driver);
    }

}
