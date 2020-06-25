package test.keywords;

import org.openqa.selenium.WebDriver;
import utils.WebDriverCreator;

import static utils.WebDriverCreator.WebDriverType.CHROME;

public class BaseKeywords {

    protected WebDriver driver;
    private WebDriverCreator webDriverCreator = new WebDriverCreator();

    public void browserSetup() {
        driver = webDriverCreator.create(CHROME);
    }

    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
