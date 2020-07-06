package pages.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface IPastebinPage<T extends IPastebinPage> {
    T openPage();

    T enterCode(String code);

    T enterPasteExpiration();

    T enterPasteName(String name);

    ResultPastebinPage clickSubmit();

    T enterValueSyntaxField(String syntaxName);

    WebDriver getWebDriver();

    WebElement getCodeField();

    WebElement getPasteExpirationField();

    WebElement getValueInPasteExpirationField();

    WebElement getPasteNameField();

    WebElement getSubmitButton();

    WebElement getSuccess();

    WebElement getSyntaxField();

    WebElement getValueSyntaxField();

}
