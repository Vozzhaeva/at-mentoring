package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import reporting.MyLogger;

public class FirefoxDriverHolder {
    private static WebDriver driver;

    private FirefoxDriverHolder() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
            driver = new FirefoxDriver();
        }
        MyLogger.debug("Driver loaded = " + driver);
        return driver;
    }
}
