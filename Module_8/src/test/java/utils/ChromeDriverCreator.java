package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverCreator implements WebDriverCreator {

	public WebDriver createWebDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		return new ChromeDriver();
	}
}
