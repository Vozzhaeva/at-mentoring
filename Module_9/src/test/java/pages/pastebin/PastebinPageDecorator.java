package pages.pastebin;

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
}
