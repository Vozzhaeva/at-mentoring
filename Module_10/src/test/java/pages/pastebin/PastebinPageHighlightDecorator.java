package pages.pastebin;

import static utils.SeleniumUtils.highlighterMethod;

public class PastebinPageHighlightDecorator extends PastebinPageDecorator {

    public PastebinPageHighlightDecorator(IPastebinPage pastebinPage) {
        super(pastebinPage);
    }

    @Override
    public PastebinPageDecorator openPage() {
        super.openPage();
        return this;
    }

    @Override
    public PastebinPageDecorator enterCode(String code) {
        highlighterMethod(getCodeField(),getWebDriver());
        super.enterCode(code);
        return this;
    }

    @Override
    public PastebinPageDecorator enterPasteExpiration() {
        highlighterMethod(getPasteExpirationField(),getWebDriver());
        super.enterPasteExpiration();
        return this;
    }

    @Override
    public PastebinPageDecorator enterPasteName(String name) {
        highlighterMethod(getPasteNameField(),getWebDriver());
        super.enterPasteName(name);
        return this;
    }

    @Override
    public ResultPastebinPage clickSubmit() {
        highlighterMethod(getSubmitButton(),getWebDriver());
        return pastebinPage.clickSubmit();
    }

    @Override
    public PastebinPageDecorator enterValueSyntaxField(String syntaxName) {
        highlighterMethod(getSyntaxField(), getWebDriver());
        super.enterValueSyntaxField(syntaxName);
        return this;
    }
}
