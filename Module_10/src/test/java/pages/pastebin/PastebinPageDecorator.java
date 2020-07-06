package pages.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PastebinPageDecorator implements IPastebinPage {

    protected IPastebinPage pastebinPage;

    public PastebinPageDecorator(IPastebinPage pastebinPage) {
        this.pastebinPage = pastebinPage;
    }

    @Override
    public PastebinPageDecorator openPage() {
        pastebinPage.openPage();
        return this;
    }

    @Override
    public PastebinPageDecorator enterCode(String code) {
        pastebinPage.enterCode(code);
        return this;
    }

    @Override
    public PastebinPageDecorator enterPasteExpiration() {
        pastebinPage.enterPasteExpiration();
        return this;
    }

    @Override
    public PastebinPageDecorator enterPasteName(String name) {
        pastebinPage.enterPasteName(name);
        return this;
    }

    @Override
    public ResultPastebinPage clickSubmit() {
        return pastebinPage.clickSubmit();
    }

    @Override
    public PastebinPageDecorator enterValueSyntaxField(String syntaxName) {
        pastebinPage.enterValueSyntaxField(syntaxName);
        return this;
    }

    @Override
    public WebDriver getWebDriver() {
        return pastebinPage.getWebDriver();
    }

    @Override
    public WebElement getCodeField() {
        return pastebinPage.getCodeField();
    }

    @Override
    public WebElement getPasteExpirationField() {
        return pastebinPage.getPasteExpirationField();
    }

    @Override
    public WebElement getValueInPasteExpirationField() {
        return pastebinPage.getValueInPasteExpirationField();
    }

    @Override
    public WebElement getPasteNameField() {
        return pastebinPage.getPasteNameField();
    }

    @Override
    public WebElement getSubmitButton() {
        return pastebinPage.getSubmitButton();
    }

    @Override
    public WebElement getSuccess() {
        return pastebinPage.getSuccess();
    }

    @Override
    public WebElement getSyntaxField() {
        return pastebinPage.getSyntaxField();
    }

    @Override
    public WebElement getValueSyntaxField() {
        return pastebinPage.getValueSyntaxField();
    }
}
