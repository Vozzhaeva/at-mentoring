package utils;

import org.openqa.selenium.WebDriver;

import static utils.WebDriverCreator.WebDriverType.CHROME;

public class WebDriverManager {
    private static WebDriver driver;
    private static WebDriverCreator webDriverCreator = new WebDriverCreator();

    private WebDriverManager() {
    }

    public static WebDriver getWebDriverInstance() {
        if (driver == null) {
            driver = webDriverCreator.create(CHROME);
        }
        return driver;
    }
}
