package utils;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    private static WebDriver driver;
//    private static WebDriverCreator webDriverCreator = new FirefoxDriverCreator();
    private static WebDriverCreator webDriverCreator = new ChromeDriverCreator();

    private WebDriverManager() {
    }

    public static WebDriver getWebDriverInstance() {
        if (driver == null) {
            driver = webDriverCreator.createWebDriver();
        }
        return driver;
    }
}
