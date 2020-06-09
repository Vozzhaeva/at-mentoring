package test.pastebin;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.pastebin.IPastebinPage;
import pages.pastebin.PastebinPage;
import pages.pastebin.PastebinPageDecorator;
import pages.pastebin.PastebinPageReportDecorator;
import test.BaseTest;
import businessobject.PasteBinTestData;

public class Task1 extends BaseTest {

    /**
     * 1. Открыть https://pastebin.com или аналогичный сервис в любом браузере
     * 2. Создать New Paste со следующими деталями:
     * * Код: "Hello from WebDriver"
     * * Paste Expiration: "10 Minutes"
     * * Paste Name / Title: "helloweb"
     */
    @Test(dataProvider = "dataProvider")
    public void newPasteCreate(PasteBinTestData testData) {
        IPastebinPage pastebinPage =
                new PastebinPageReportDecorator(new PastebinPage(driver));
        boolean isPasteCreatedSuccessfully = pastebinPage
                .openPage()
                .enterCode(testData.getCode())
                .enterPasteExpiration()
                .enterPasteName(testData.getPasteName())
                .clickSubmit()
                .isResolutionSuccess();

        Assert.assertTrue(isPasteCreatedSuccessfully, testData.getErrorMessage());

    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {new PasteBinTestData("Hello from WebDriver", "helloweb", null, "New Paste was not created.")}
        };
    }
}
