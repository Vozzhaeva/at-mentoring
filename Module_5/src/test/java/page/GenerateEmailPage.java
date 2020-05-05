package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class GenerateEmailPage extends AbstractPage {
    protected GenerateEmailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='mail_messages_content']/div/div[1]/div[3]/span")
    private WebElement locator;

    @FindBy(xpath = "//table/tbody/tr[2]/td[2]/h3")
    private WebElement priceFromEmail;

    protected String generateEmail(JavascriptExecutor javascriptExecutor) {
        javascriptExecutor.executeScript("window.open('https://10minutemail.com/','email');");

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String email = driver.findElement(By.id("mail_address")).getAttribute("value");
        while (email.isEmpty()) {
            email = driver.findElement(By.id("mail_address")).getAttribute("value");
        }
        Assert.assertNotNull(email);
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        return email;
    }

    protected Boolean checkEmailShouldContain(String price) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        locator.click();
        priceFromEmail.getText();
        return price.contains(priceFromEmail.getText());

    }
}
