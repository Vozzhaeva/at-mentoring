package pages.pastebin;

import org.testng.Reporter;

public class PastebinPageDecorator implements IPastebinPage {

    private PastebinPage pastebinPage;

    public PastebinPageDecorator(PastebinPage pastebinPage) {
        this.pastebinPage = pastebinPage;
    }

    @Override
    public PastebinPageDecorator openPage() {
        Reporter.log("open page", true);
        pastebinPage.openPage();
        return this;
    }

    @Override
    public PastebinPageDecorator enterCode(String code) {
        Reporter.log("enter code", true);
        pastebinPage.enterCode(code);
        return this;
    }

    @Override
    public PastebinPageDecorator enterPasteExpiration() {
        Reporter.log("entered paste expiration", true);
        pastebinPage.enterPasteExpiration();
        return this;
    }

    @Override
    public PastebinPageDecorator enterPasteName(String name) {
        Reporter.log("entered paste name", true);
        pastebinPage.enterPasteName(name);
        return this;
    }

    @Override
    public ResultPastebinPage clickSubmit() {
        Reporter.log("Clicked submit", true);
        return pastebinPage.clickSubmit();
    }

    @Override
    public PastebinPageDecorator enterValueSyntaxField(String syntaxName) {
        Reporter.log("syntax field value entered", true);
        pastebinPage.enterValueSyntaxField(syntaxName);
        return this;
    }
}
