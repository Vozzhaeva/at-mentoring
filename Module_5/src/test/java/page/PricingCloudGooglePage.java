package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
