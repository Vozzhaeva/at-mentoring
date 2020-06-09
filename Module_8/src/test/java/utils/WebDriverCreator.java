package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverCreator {

    public WebDriver create(WebDriverType webDriverType) {
        if (webDriverType==null){
            throw new IllegalStateException("driver type is empty");
        }
        switch (webDriverType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
                return new FirefoxDriver();
            default:
                throw new IllegalStateException("driver was not found");
        }
    }

    enum WebDriverType {
        CHROME, FIREFOX
    }
}
