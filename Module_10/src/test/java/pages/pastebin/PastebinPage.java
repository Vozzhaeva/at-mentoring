package pages.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import reporting.MyLogger;


public class PastebinPage extends AbstractPage implements IPastebinPage {
    private static final String PAGE_URL = "https://pastebin.com";

    @FindBy(id = "paste_code")
    private WebElement codeField;

    @FindBy(xpath = "//*[@title='Never']")
    private WebElement pasteExpirationField;

    @FindBy(xpath = "//li[contains(text(), '10 Minutes')]")
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
    private WebElement bashSyntax;

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
        MyLogger.debug("Clicked pasteExpirationField at location = " + pasteExpirationField.getLocation());
        new Actions(driver).click(pasteExpirationField).build().perform();
        MyLogger.debug("Clicked pasteExpirationField at location = " + valueInPasteExpirationField.getLocation());
        valueInPasteExpirationField.click();
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
        bashSyntax.click();
        return this;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    @Override
    public WebElement getCodeField() {
        return codeField;
    }

    @Override
    public WebElement getPasteExpirationField() {
        return pasteExpirationField;
    }

    @Override
    public WebElement getValueInPasteExpirationField() {
        return valueInPasteExpirationField;
    }

    @Override
    public WebElement getPasteNameField() {
        return pasteNameField;
    }

    @Override
    public WebElement getSubmitButton() {
        return submitButton;
    }

    @Override
    public WebElement getSuccess() {
        return success;
    }

    @Override
    public WebElement getSyntaxField() {
        return syntaxField;
    }

    @Override
    public WebElement getValueSyntaxField() {
        return valueSyntaxField;
    }
}
