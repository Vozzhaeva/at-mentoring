package utils;

import org.openqa.selenium.WebDriver;

import static reporting.MyLogger.warn;

public class WebDriverCreator {

    public WebDriver create(WebDriverType webDriverType) {
        if (webDriverType == null) {
            warn("driver type is not set");
            throw new IllegalStateException("driver type is empty");
        }
        switch (webDriverType) {
            case CHROME:
                return ChromeDriverHolder.getDriver();
            case FIREFOX:
                return FirefoxDriverHolder.getDriver();
            default:
                warn("driver type is not supported");
                throw new IllegalStateException("driver was not found");
        }
    }

    public enum WebDriverType {
        CHROME, FIREFOX, SAFARI
    }
}
