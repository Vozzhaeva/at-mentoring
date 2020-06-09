package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverCreator implements WebDriverCreator {
    public WebDriver createWebDriver() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        return new FirefoxDriver();
    }
}
