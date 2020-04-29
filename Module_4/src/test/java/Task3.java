import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task3 {

    private WebDriver driver;
    private JavascriptExecutor javascriptExecutor;

    private By productsButton = By.linkText("Products");
    private By allProductsButton = By.xpath("//a/div[contains(text(),'See all products')]");
    private By seePricingButton = By.partialLinkText("See pricing");
    private By calculatorsButton = By.partialLinkText("Calculators");

    //фреймов два один в другой вложен
    private By firstFrame = By.xpath("//article[@class='devsite-article']/article[@class='devsite-article-inner']/div[2]/article/devsite-iframe/iframe");
    private By secondFrame = By.xpath("//iframe");

    //второй фрейм в калькуляторе
    private By computeEngineTab = By.xpath("//md-tab-item/div[@title='Compute Engine']");
    private By numberOfInstancesInput = By.xpath("//input[@id='input_58']");
    private String countOfInstances = "4";

    private By operatingSystem = By.xpath("//md-select[@id='select_70']/md-select-value/span[1]/div");
    private By operatingSystemOption = By.xpath("//md-option[@id='select_option_60']");


    private By machineClass = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.class']");
    private By machineClassOption = By.xpath("//*[@id='select_option_72']");

    private By machineType = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.instance']");
    private By machineTypeOption = By.xpath("//*[contains(text(),'n1-standard-8')]");


    private By addGPUsCheckBox = By.xpath("//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']");
    private By gpuCount = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuCount']");
    private By gpuCountOption = By.xpath("//md-option[@id='select_option_339']");
    private By gpuType = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuType']");
    private By gpuTypeOption = By.xpath("//md-option[@value='NVIDIA_TESLA_V100']");

    private By ssd = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.ssd']");
    private By ssdOption = By.xpath("//md-option[@id='select_option_233']");

    private By location = By.xpath("//md-select[@id=\"select_85\"]");
    private By locationOption = By.xpath("//md-option[@id=\"select_option_181\"]");

    private By cud = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.cud']");
    private By cudOption = By.xpath("//md-option[@id='select_option_90']");

    private By addToEstimate = By.xpath("//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']");

    private boolean workaround = true;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    /**
     * 1. Открыть https://cloud.google.com/
     * 2. Нажать на кнопку EXPLORE ALL PRODUCTS
     * 3. Нажать на кнопку SEE PRICING
     * 4. В панели слева выбрать Calculators
     * 5. Активировать раздел COMPUTE ENGINE вверху страницы
     * 6. Заполнить форму следующими данными:
     * * Number of instances: 4
     * * What are these instances for?: оставить пустым
     * * Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
     * * VM Class: Regular
     * * Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
     * * Выбрать Add GPUs
     * * Number of GPUs: 1
     * * GPU type: NVIDIA Tesla V100
     * * Local SSD: 2x375 Gb
     * * Datacenter location: Frankfurt (europe-west3)
     * * Commited usage: 1 Year
     * 7. Нажать Add to Estimate
     * 8. Проверить соответствие данных следующих полей: VM Class, Instance type, Region, local SSD, commitment term
     * 9. Проверить что сумма аренды в месяц совпадает с суммой получаемой при ручном прохождении теста.
     */
    @Test
    public void NewPasteCreate() {
        driver.get("https://cloud.google.com");
        driver.manage().window().maximize();

        findAndClick(productsButton);

        findAndClick(allProductsButton);

        findAndClick(seePricingButton);
        findAndClick(calculatorsButton);

        if (workaround) {
            // перестал фрейм открываться корректно на странице калькулятора поэтому фрейм в новом окне открывается
            WebElement firstFrameWebElem = waitForElementLocatedBy(driver, firstFrame);
            String src = firstFrameWebElem.getAttribute("src");
            driver.get(src);
            WebElement secondFrameWebElem = waitForElementLocatedBy(driver, secondFrame);
            String srcOfSecondFrame = secondFrameWebElem.getAttribute("src");
            driver.get(srcOfSecondFrame);

        } else {
            switchToFrameBySelector(firstFrame);
            switchToFrameBySelector(secondFrame);
        }


        findAndClick(computeEngineTab);
        findAndClick(numberOfInstancesInput).sendKeys(countOfInstances);

        findAndJsClick(operatingSystem, true);
        findAndJsClick(operatingSystemOption);

        findAndJsClick(machineClass, true);
        findAndJsClick(machineClassOption);

        findAndJsClick(machineType, true);
        findAndJsClick(machineTypeOption);

        findAndJsClick(addGPUsCheckBox, true);
        findAndJsClick(gpuCount, true);
        findAndJsClick(gpuCountOption);

        findAndJsClick(gpuType, true);
        findAndJsClick(gpuTypeOption);

        findAndJsClick(ssd, true);
        findAndJsClick(ssdOption);

        findAndJsClick(location, true);
        findAndJsClick(locationOption);

        findAndJsClick(cud, true);
        findAndJsClick(cudOption);

        findAndJsClick(addToEstimate);

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item/div"));
        Set<String> actualResult = elements.stream().map(e -> e.getText()).collect(Collectors.toSet());
        Set<String> expectedResult = new HashSet<String>() {{
            add("2,920 total hours per month");
            add("VM class: regular");
            add("Instance type: n1-standard-8");
            add("Region: Frankfurt");
            add("Total available local SSD space 2x375 GiB");
            add("Commitment term: 1 Year");
            add("Estimated Component Cost: USD 1,082.77 per 1 month");
        }};
        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    private void switchToFrameBySelector(By selector) {
        driver.switchTo().frame(waitForElementLocatedBy(driver, selector));
    }

    private WebElement findAndClick(By selector) {
        WebElement element = waitForElementLocatedBy(driver, selector);
        element.click();
        return element;
    }

    private WebElement findAndJsClick(By selector) {
        return findAndJsClick(selector, false);
    }

    private WebElement findAndJsClick(By selector, boolean navigateToElement) {
        WebElement element = waitForElementLocatedBy(driver, selector);
        if (navigateToElement) {
            new Actions(driver).moveToElement(element).perform();
        }
        javascriptExecutor.executeScript("arguments[0].click();", element);
        return element;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));

    }
}
