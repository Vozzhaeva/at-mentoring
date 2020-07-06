package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import reporting.MyLogger;

public class ChromeDriverHolder {
    private static WebDriver driver;

    private ChromeDriverHolder() {
    }

    public static WebDriver getDriver() {
        if (driver == null || ((ChromeDriver) driver).getSessionId() == null) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            driver = new ChromeDriver();
        }
        MyLogger.debug("Driver loaded = " + driver);
        return driver;
    }
}
