package pages.pastebin;

public interface IPastebinPage<T extends IPastebinPage> {
    T openPage();

    T enterCode(String code);

    T enterPasteExpiration();

    T enterPasteName(String name);

    ResultPastebinPage clickSubmit();

    T enterValueSyntaxField(String syntaxName);
}
