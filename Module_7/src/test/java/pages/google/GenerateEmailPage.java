package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import static utils.SeleniumUtils.openNewTab;
import static utils.SeleniumUtils.switchToTab;

public class GenerateEmailPage extends AbstractPage {
    protected GenerateEmailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='mail_messages_content']/div/div[1]/div[3]/span")
    private WebElement locator;

    @FindBy(xpath = "//table/tbody/tr[2]/td[2]/h3")
    private WebElement priceFromEmail;

    protected String generateEmail(JavascriptExecutor javascriptExecutor) {
        openNewTab(javascriptExecutor, "https://10minutemail.com/");
        switchToTab(driver, 1);
        String email = getEmailString();
        while (email.isEmpty()) {
            email = getEmailString();
        }
        switchToTab(driver, 0);
        return email;
    }

    private String getEmailString() {
        return driver.findElement(By.id("mail_address")).getAttribute("value");
    }

    protected Boolean checkEmailShouldContain(String price) {
        switchToTab(driver, 1);
        locator.click();
        priceFromEmail.getText();
        return price.contains(priceFromEmail.getText());

    }
}
