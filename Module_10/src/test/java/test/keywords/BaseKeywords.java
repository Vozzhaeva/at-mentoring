package test.keywords;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import reporting.MyLogger;
import utils.WebDriverCreator;

import java.io.File;
import java.io.IOException;

import static utils.WebDriverCreator.WebDriverType.CHROME;

public class BaseKeywords {

    private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";

    protected WebDriver driver;

    private WebDriverCreator webDriverCreator = new WebDriverCreator();

    public void browserSetup() {
        driver = webDriverCreator.create(CHROME);
    }

    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    protected void takeScreenshot(String comment) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            String scrPath = screenshotName + ".jpg";
            File copy = new File(scrPath);
            FileUtils.copyFile(screenshot, copy);
            MyLogger.attach(scrPath, comment + "Screenshot");
        } catch (IOException e) {
            MyLogger.warn("Failed to make screenshot");
        }
    }
}
