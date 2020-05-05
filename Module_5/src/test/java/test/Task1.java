package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.PastebinPage;

public class Task1 extends BaseTest {

    /**
     * 1. Открыть https://pastebin.com или аналогичный сервис в любом браузере
     * 2. Создать New Paste со следующими деталями:
     * * Код: "Hello from WebDriver"
     * * Paste Expiration: "10 Minutes"
     * * Paste Name / Title: "helloweb"
     */
    @Test
    public void NewPasteCreate() {

        boolean isPasteCreatedSuccessfully = new PastebinPage(super.driver)
                .openPage()
                .enterCode("Hello from WebDriver")
                .enterPasteExpiration()
                .enterPasteName("helloweb")
                .clickSubmit()
                .isResolutionSuccess();

        Assert.assertTrue(isPasteCreatedSuccessfully, "New Paste not created.");

    }
}
