import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Task1 {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    /**
     * 1. Открыть https://pastebin.com или аналогичный сервис в любом браузере
     * 2. Создать New Paste со следующими деталями:
     * * Код: "Hello from WebDriver"
     * * Paste Expiration: "10 Minutes"
     * * Paste Name / Title: "helloweb"
     */
    @Test
    public void NewPasteCreate() {
        driver.get("https://pastebin.com");
        WebElement inputField = waitForElementLocatedBy(driver, By.id("paste_code"));
        inputField.sendKeys("Hello from WebDriver");

        WebElement pasteExpirationField = waitForElementLocatedBy(driver, By.xpath("//*[@title='Never']"));
        pasteExpirationField.click();

        WebElement valueInPasteExpirationField = waitForElementLocatedBy(driver, By.xpath("//li[text()='10 Minutes']"));
        valueInPasteExpirationField.click();

        WebElement pasteNameField = waitForElementLocatedBy(driver, By.name("paste_name"));
        pasteNameField.sendKeys("helloweb");

        WebElement submitButton = waitForElementLocatedBy(driver, By.id("submit"));
        submitButton.click();

        List<WebElement> success = driver.findElements(By.id("success"));
        Assert.assertTrue(success.size() > 0, "New Paste not created.");

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));

    }
}
