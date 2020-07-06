package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumUtils {
    public static WebElement findAndJsClick(JavascriptExecutor javascriptExecutor, WebElement element) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true); ", element);
        javascriptExecutor.executeScript("arguments[0].click();", element);

        return element;
    }

    public static void switchToTab(WebDriver driver, int tabIndex) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[tabIndex].toString());
    }

    public static void openNewTab(JavascriptExecutor javascriptExecutor, String url) {
        javascriptExecutor.executeScript("window.open('" + url + "','email');");

    }

    public static void highlighterMethod(WebElement element, WebDriver webDriver){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
}
