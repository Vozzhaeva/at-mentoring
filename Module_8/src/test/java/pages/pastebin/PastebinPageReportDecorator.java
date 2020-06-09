package pages.pastebin;

import org.testng.Reporter;

public class PastebinPageReportDecorator extends PastebinPageDecorator {

    public PastebinPageReportDecorator(IPastebinPage pastebinPage) {
        super(pastebinPage);
    }

    @Override
    public PastebinPageDecorator openPage() {
        Reporter.log("open page", true);
        super.openPage();
        return this;
    }

    @Override
    public PastebinPageDecorator enterCode(String code) {
        Reporter.log("enter code", true);
        super.enterCode(code);
        return this;
    }

    @Override
    public PastebinPageDecorator enterPasteExpiration() {
        Reporter.log("entered paste expiration", true);
        super.enterPasteExpiration();
        return this;
    }

    @Override
    public PastebinPageDecorator enterPasteName(String name) {
        Reporter.log("entered paste name", true);
        super.enterPasteName(name);
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
        super.enterValueSyntaxField(syntaxName);
        return this;
    }
}
