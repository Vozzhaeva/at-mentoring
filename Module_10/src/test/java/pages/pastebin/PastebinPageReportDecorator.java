package pages.pastebin;

import reporting.MyLogger;

public class PastebinPageReportDecorator extends PastebinPageDecorator {

    public PastebinPageReportDecorator(IPastebinPage pastebinPage) {
        super(pastebinPage);
    }

    @Override
    public PastebinPageDecorator openPage() {
        MyLogger.info("Open page");
        super.openPage();
        return this;
    }

    @Override
    public PastebinPageDecorator enterCode(String code) {
        MyLogger.info("Enter code");
        super.enterCode(code);
        return this;
    }

    @Override
    public PastebinPageDecorator enterPasteExpiration() {
        MyLogger.info("Entered paste expiration");
        super.enterPasteExpiration();
        return this;
    }

    @Override
    public PastebinPageDecorator enterPasteName(String name) {
        MyLogger.info("Entered paste name");
        super.enterPasteName(name);
        return this;
    }

    @Override
    public ResultPastebinPage clickSubmit() {
        MyLogger.info("Clicked submit");
        return pastebinPage.clickSubmit();
    }

    @Override
    public PastebinPageDecorator enterValueSyntaxField(String syntaxName) {
        MyLogger.info("Syntax field value entered");
        super.enterValueSyntaxField(syntaxName);
        return this;
    }
}
