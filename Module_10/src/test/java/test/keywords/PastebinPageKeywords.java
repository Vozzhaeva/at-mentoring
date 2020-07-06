package test.keywords;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;
import org.testng.Assert;
import pages.pastebin.*;

import java.util.Objects;

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
        pastebinPage = new PastebinPageHighlightDecorator(
                new PastebinPageReportDecorator(
                        new PastebinPage(driver)
                )
        );
        pastebinPage.openPage();
    }

    @Допустим("^страница успешно открылась$")
    public void isPageOpen() {
        Assert.assertNotNull(driver.getTitle());
    }

    @Если("ввести код {string}")
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
        if (!resolutionSuccess) {
            takeScreenshot("Ошибка выполнения теста");
        }
        Assert.assertTrue(resolutionSuccess, "Сниппет не создан");
        browserTearDown();
    }

    @То("название страницы сответствует {string} синтаксис соответствует {string} и код соответствует {string}")
    public void pasteCreatedSuccessfully(String title, String syntax, String code) {
        boolean isTitleEquals = resultPastebinPage.getTitlePage().contains(title);
        boolean isHighlightCorrect = Objects.equals(
                resultPastebinPage.getSyntaxHighlightning().toLowerCase(),
                syntax.toLowerCase()
        );
        boolean isTextCorrect = Objects.equals(
                resultPastebinPage.getCodeText(),
                code
        );
        if (!isTitleEquals||!isHighlightCorrect||!isTextCorrect) {
            takeScreenshot("Неудачное выполнение теста калькулятора google");
        }
        Assert.assertTrue(isTitleEquals);
        Assert.assertTrue(isHighlightCorrect);
        Assert.assertTrue(isTextCorrect);
        final boolean resolutionSuccess = resultPastebinPage.isResolutionSuccess();
        if (!resolutionSuccess) {
            takeScreenshot("Неудачное выполнение теста калькулятора google");
        }
        Assert.assertTrue(resolutionSuccess, "Сниппет не создан");
        browserTearDown();
    }

}
