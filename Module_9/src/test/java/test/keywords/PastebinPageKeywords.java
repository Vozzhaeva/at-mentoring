package test.keywords;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;
import org.testng.Assert;
import pages.pastebin.IPastebinPage;
import pages.pastebin.PastebinPage;
import pages.pastebin.PastebinPageReportDecorator;
import pages.pastebin.ResultPastebinPage;

public class PastebinPageKeywords extends BaseKeywords {
    IPastebinPage pastebinPage;
    ResultPastebinPage resultPastebinPage;

    /**
     * 1. Открыть https://pastebin.com или аналогичный сервис в любом браузере
     * 2. Создать New Paste со следующими деталями:
     * * Код: "Hello from WebDriver"
     * * Paste Expiration: "10 Minutes"
     * * Paste Name / Title: "helloweb"
     */
    @Допустим("^пользователь открывает страницу браузера и открывает сайт Pastebin$")
    public void init() {
        browserSetup();
        pastebinPage = new PastebinPageReportDecorator(new PastebinPage(driver));
        pastebinPage.openPage();
    }

    @Допустим("^страница успешно открылась$")
    public void isPageOpen() {
        Assert.assertNotNull(driver.getTitle());
    }

    @Если("^ввести код (.+)$")
    public void inputCode(String code) {
        pastebinPage.enterCode(code);
    }

    @Если("ввести время существования сниппета кода")
    public void enterPasteExpiration() {
        pastebinPage.enterPasteExpiration();
    }

    @Если("^ввести название сниппета кода (.+)$")
    public void inputPasteName(String pasteName) {
        pastebinPage.enterPasteName(pasteName);
    }

    @Если("^выбрать синтаксис (.+)$")
    public void enterValueSyntaxField(String syntaxName) {
        pastebinPage.enterValueSyntaxField(syntaxName);
    }

    @Если("^нажать кнопку создать$")
    public void clickSubmit() {
        resultPastebinPage = pastebinPage.clickSubmit();
    }

    @То("^сниппет успешно создался$")
    public void pasteCreatedSuccessfully() {
        final boolean resolutionSuccess = resultPastebinPage.isResolutionSuccess();
        Assert.assertTrue(resolutionSuccess, "Сниппет не создан");
        browserTearDown();
    }

    @То("^название страницы сответствует (.+) синтаксис соответствует (.+) и код соответствует (.+)$")
    public void pasteCreatedSuccessfully(String title, String syntax, String code) {
        Assert.assertTrue(resultPastebinPage.getTitlePage().contains(title));
        Assert.assertEquals(resultPastebinPage.getSyntaxHighlightning().toLowerCase(), syntax.toLowerCase());
        Assert.assertEquals(resultPastebinPage.getCodeText(), code);
        final boolean resolutionSuccess = resultPastebinPage.isResolutionSuccess();
        Assert.assertTrue(resolutionSuccess, "Сниппет не создан");
        browserTearDown();
    }
}
