package pages.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import static utils.SeleniumUtils.highlighterMethod;

public class PricingCloudGooglePage extends AbstractPage {

    @FindBy(partialLinkText = "Calculators")
    private WebElement calculatorsButton;

    protected PricingCloudGooglePage(WebDriver driver) {
        super(driver);
    }

    public CalculatorCloudGooglePage clickCalculators() {
        highlighterMethod(calculatorsButton, driver);
        calculatorsButton.click();
        return new CalculatorCloudGooglePage(driver);
    }

}
