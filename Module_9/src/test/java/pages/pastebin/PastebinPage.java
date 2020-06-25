package pages.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;


public class PastebinPage extends AbstractPage implements IPastebinPage {
    private static final String PAGE_URL = "https://pastebin.com";

    @FindBy(id = "paste_code")
    private WebElement codeField;

    @FindBy(xpath = "//*[@title='Never']")
    private WebElement pasteExpirationField;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement valueInPasteExpirationField;

    @FindBy(xpath = "//input[@name='paste_name']")
    private WebElement pasteNameField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "success")
    private WebElement success;

    @FindBy(xpath = "//*[@title='None']")
    private WebElement syntaxField;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement valueSyntaxField;

    public PastebinPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PastebinPage openPage() {
        driver.get(getPageUrl());
        return this;
    }

    protected String getPageUrl() {
        return PAGE_URL;
    }

    @Override
    public PastebinPage enterCode(String code) {
        new Actions(driver).sendKeys(code).build().perform();
        return this;
    }

    @Override
    public PastebinPage enterPasteExpiration() {
        new Actions(driver).click(pasteExpirationField).build().perform();
        new Actions(driver).click(valueInPasteExpirationField).build().perform();
        return this;
    }

    @Override
    public PastebinPage enterPasteName(String name) {
        new Actions(driver).click(pasteNameField).sendKeys(name).build().perform();
        return this;
    }

    @Override
    public ResultPastebinPage clickSubmit() {
        new Actions(driver).click(submitButton).build().perform();
        return new ResultPastebinPage(driver);
    }

    @Override
    public PastebinPage enterValueSyntaxField(String syntaxName) {
        syntaxField.click();
        new Actions(driver).sendKeys(syntaxName + "\n").build().perform();
        return this;
    }
}
