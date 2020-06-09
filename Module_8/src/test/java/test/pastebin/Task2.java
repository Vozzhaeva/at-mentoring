package test.pastebin;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.pastebin.PastebinPage;
import pages.pastebin.PastebinPageDecorator;
import pages.pastebin.PastebinPageReportDecorator;
import pages.pastebin.ResultPastebinPage;
import test.BaseTest;
import businessobject.PasteBinTestData;

public class Task2 extends BaseTest {

    /**
     * 1. Открыть https://pastebin.com  или аналогичный сервис в любом браузере
     * 2. Создать New Paste со следующими деталями:
     * * Код:
     * git config --global user.name  "New Sheriff in Town"
     * git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
     * git push origin master --force
     * * Syntax Highlighting: "Bash"
     * * Paste Expiration: "10 Minutes"
     * * Paste Name / Title: "how to gain dominance among developers"
     * 3. Сохранить paste и проверить следующее:
     * * Заголовок страницы браузера соответствует Paste Name / Title
     * * Синтаксис подвечен для bash
     * * Проверить что код соответствует введенному в пункте 2
     */
    @Test(dataProvider = "dataProvider")
    public void newPasteCreate(PasteBinTestData testData) {

        ResultPastebinPage resultPastebinPage = new PastebinPageReportDecorator(new PastebinPage(driver))
                .openPage()
                .enterCode(testData.getCode())
                .enterValueSyntaxField(testData.getSyntaxName())
                .enterPasteExpiration()
                .enterPasteName(testData.getPasteName())
                .clickSubmit();

        Assert.assertTrue(resultPastebinPage.getTitlePage().contains(testData.getPasteName()));
        Assert.assertEquals(resultPastebinPage.getSyntaxHighlightning(), "bash");
        Assert.assertEquals(resultPastebinPage.getCodeEquals(), testData.getCode());
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {new PasteBinTestData("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force", "how to gain dominance among developers", "Bash")}
        };
    }
}
