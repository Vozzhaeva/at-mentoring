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

public class Task2 {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    /**
     * 1. Открыть https://pastebin.com  или аналогичный сервис в любом браузере
     * 2. Создать New Paste со следующими деталями:
     * * Код:
     *
     * git config --global user.name  "New Sheriff in Town"
     * git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
     * git push origin master --force
     * * Syntax Highlighting: "Bash"
     *
     * * Paste Expiration: "10 Minutes"
     * * Paste Name / Title: "how to gain dominance among developers"
     * 3. Сохранить paste и проверить следующее:
     * * Заголовок страницы браузера соответствует Paste Name / Title
     * * Синтаксис подвечен для bash
     * * Проверить что код соответствует введенному в пункте 2
     */
    @Test
    public void NewPasteCreate() {
        driver.get("https://pastebin.com");
        WebElement inputField = waitForElementLocatedBy(driver, By.id("paste_code"));
        String testString = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        inputField.sendKeys(
                testString);

        WebElement syntaxField = waitForElementLocatedBy(driver, By.xpath("//*[@title='None']"));
        syntaxField.click();

        WebElement valueSyntaxField = waitForElementLocatedBy(driver, By.xpath("//li[text()='Bash']"));
        valueSyntaxField.click();

        WebElement pasteExpirationField = waitForElementLocatedBy(driver, By.xpath("//*[@title='Never']"));
        pasteExpirationField.click();

        WebElement valueInPasteExpirationField = waitForElementLocatedBy(driver, By.xpath("//li[text()='10 Minutes']"));
        valueInPasteExpirationField.click();

        WebElement pasteNameField = waitForElementLocatedBy(driver, By.name("paste_name"));
        pasteNameField.sendKeys("how to gain dominance among developers");

        WebElement submitButton = waitForElementLocatedBy(driver, By.id("submit"));
        submitButton.click();

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("how to gain dominance among developers"));

        String typeOfSyntaxHighlightning = waitForElementLocatedBy(driver, By.xpath("//div[@id='code_frame']/div[@id='selectable']/ol")).getAttribute("class");
        Assert.assertEquals(typeOfSyntaxHighlightning, "bash");

        String resultString = waitForElementLocatedBy(driver, By.xpath("//textarea[@id='paste_code']")).getText();
        Assert.assertEquals(resultString, testString);

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
