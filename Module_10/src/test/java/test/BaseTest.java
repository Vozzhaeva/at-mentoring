package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WebDriverCreator;

import static utils.WebDriverCreator.WebDriverType.CHROME;

public class BaseTest {

    protected WebDriver driver;
    private final WebDriverCreator webDriverCreator = new WebDriverCreator();

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = webDriverCreator.create(CHROME);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
