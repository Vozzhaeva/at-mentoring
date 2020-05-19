package test.pastebin;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.pastebin.PastebinPage;
import test.BaseTest;
import test.business.object.PasteBinTestData;

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
        boolean isPasteCreatedSuccessfully = new PastebinPage(super.driver)
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
