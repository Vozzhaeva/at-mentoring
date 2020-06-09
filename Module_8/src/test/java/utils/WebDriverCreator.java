package utils;

import org.openqa.selenium.WebDriver;

public class WebDriverCreator {

    public WebDriver create(WebDriverType webDriverType) {
        if (webDriverType == null) {
            throw new IllegalStateException("driver type is empty");
        }
        switch (webDriverType) {
            case CHROME:
                return ChromeDriverHolder.getDriver();
            case FIREFOX:
                return FirefoxDriverHolder.getDriver();
            default:
                throw new IllegalStateException("driver was not found");
        }
    }

    public enum WebDriverType {
        CHROME, FIREFOX
    }
}
