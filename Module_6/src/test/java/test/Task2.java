package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.PastebinPage;
import page.ResultPastebinPage;

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
    @Test
    public void NewPasteCreate() {

        String pasteName = "how to gain dominance among developers";
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";

        ResultPastebinPage resultPastebinPage = new PastebinPage(super.driver)
                .openPage()
                .enterCode(code)
                .enterPasteExpiration()
                .enterPasteName(pasteName)
                .enterValueSyntaxField()
                .clickSubmit();

        Assert.assertTrue(resultPastebinPage.getTitlePage().contains(pasteName));
        Assert.assertEquals(resultPastebinPage.getSyntaxHighlightning(), "bash");
        Assert.assertEquals(resultPastebinPage.getCodeEquals(), code);
    }
}
