package pages.google;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.AbstractPage;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static utils.SeleniumUtils.findAndJsClick;
import static utils.SeleniumUtils.highlighterMethod;

public class CalculatorCloudGooglePage extends AbstractPage {
    private JavascriptExecutor javascriptExecutor;

    @FindBy(xpath = "//article[@class='devsite-article']/article[@class='devsite-article-inner']/div[2]/article/devsite-iframe/iframe")
    private WebElement firstFrame;

    @FindBy(xpath = "//iframe")
    private WebElement secondFrame;

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngineTab;
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']/md-select-value/span[1]/div")
    private WebElement operatingSystem;

    @FindBy(xpath = "//md-option/div[contains(text(), 'Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS')]")
    private WebElement operatingSystemOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    private WebElement machineClass;

    @FindBy(xpath = "//md-option/div[contains(text(), 'Regular')]")
    private WebElement machineClassOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement machineType;

    @FindBy(xpath = "//*[contains(text(),'n1-standard-8')]")
    private WebElement machineTypeOption;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsCheckBox;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement gpuCount;

    @FindBy(xpath = "//md-option[contains(@ng-repeat, 'item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]')]")
    private WebElement gpuCountOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement gpuType;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement gpuTypeOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement ssd;

    @FindBy(xpath = "//md-option/div[contains(text(), '2x375 GB')]")
    private WebElement ssdOption;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement location;

    @FindBy(xpath = "//md-option/div[contains(text(), 'Frankfurt (europe-west3)')]/parent::md-option")
    private WebElement locationOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement cud;

    @FindBy(xpath = "//md-option[@id='select_option_90']")
    private WebElement cudOption;

    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimate;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item/div")
    private List<WebElement> result;

    @FindBy(xpath = "//*[@id='email_quote']")
    private WebElement emailEstimate;

    @FindBy(xpath = "//*[@id='input_401']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//*[@id='dialogContent_407']/form/md-dialog-actions/button[@aria-label='Send Email']")
    private WebElement sendEmail;

    @FindBy(xpath = "//*[@id='resultBlock']/md-card/md-card-content/div/div/div/h2[@class='md-title']/b[@class='ng-binding']")
    private WebElement priceSelector;

    private boolean workaround = true;

    protected CalculatorCloudGooglePage(WebDriver driver) {
        super(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
        if (workaround) {
            // перестал фрейм открываться корректно на странице калькулятора поэтому фрейм в новом окне открывается
            driver.get(firstFrame.getAttribute("src"));
            driver.get(secondFrame.getAttribute("src"));

        } else {
            driver.switchTo().frame(firstFrame);
            driver.switchTo().frame(secondFrame);
        }

    }

    public CalculatorCloudGooglePage clickComputeEngine() {
        highlighterMethod(computeEngineTab, driver);
        computeEngineTab.click();
        return this;
    }

    public CalculatorCloudGooglePage enterNumberOfInstances(String countOfInstances) {
        highlighterMethod(numberOfInstancesInput, driver);
        numberOfInstancesInput.sendKeys(countOfInstances);
        return this;
    }

    public CalculatorCloudGooglePage enterOperatingSystem() {
        highlighterMethod(operatingSystem, driver);
        findAndJsClick(javascriptExecutor, operatingSystem);
        highlighterMethod(operatingSystemOption, driver);
        findAndJsClick(javascriptExecutor, operatingSystemOption);
        return this;
    }

    public CalculatorCloudGooglePage enterVMClass() {
        highlighterMethod(machineClass, driver);
        findAndJsClick(javascriptExecutor, machineClass);
        highlighterMethod(machineClassOption, driver);
        findAndJsClick(javascriptExecutor, machineClassOption);
        return this;
    }

    public CalculatorCloudGooglePage enterMachineType() {
        highlighterMethod(machineType, driver);
        findAndJsClick(javascriptExecutor, machineType);
        highlighterMethod(machineTypeOption, driver);
        findAndJsClick(javascriptExecutor, machineTypeOption);
        return this;
    }

    public CalculatorCloudGooglePage enterGPUs() {
        highlighterMethod(addGPUsCheckBox, driver);
        findAndJsClick(javascriptExecutor, addGPUsCheckBox);
        highlighterMethod(gpuCount, driver);
        findAndJsClick(javascriptExecutor, gpuCount);
        highlighterMethod(gpuCountOption, driver);
        findAndJsClick(javascriptExecutor, gpuCountOption);
        highlighterMethod(gpuType, driver);
        findAndJsClick(javascriptExecutor, gpuType);
        highlighterMethod(gpuTypeOption, driver);
        findAndJsClick(javascriptExecutor, gpuTypeOption);
        return this;
    }

    public CalculatorCloudGooglePage enterSSD() {
        highlighterMethod(ssd, driver);
        findAndJsClick(javascriptExecutor, ssd);
        highlighterMethod(ssdOption, driver);
        findAndJsClick(javascriptExecutor, ssdOption);
        return this;
    }

    public CalculatorCloudGooglePage enterDatecenterLocation() {
        highlighterMethod(location, driver);
        findAndJsClick(javascriptExecutor, location);
        highlighterMethod(locationOption, driver);
        findAndJsClick(javascriptExecutor, locationOption);
        return this;
    }

    public CalculatorCloudGooglePage enterCommitedUsage() {
        highlighterMethod(cud, driver);
        findAndJsClick(javascriptExecutor, cud);
        highlighterMethod(cudOption, driver);
        findAndJsClick(javascriptExecutor, cudOption);
        return this;
    }

    public CalculatorCloudGooglePage clickAddToEstimate() {
        highlighterMethod(addToEstimate, driver);
        findAndJsClick(javascriptExecutor, addToEstimate);
        return this;
    }

    public Set<String> getResult() {
        return result.stream()
                .map(WebElement::getText)
                .collect(Collectors.toSet());
    }

    public boolean sendEmail() {
        highlighterMethod(priceSelector, driver);
        String price = priceSelector.getText();
        highlighterMethod(emailEstimate, driver);
        findAndJsClick(javascriptExecutor, emailEstimate);
        highlighterMethod(fieldEmail, driver);
        findAndJsClick(javascriptExecutor, fieldEmail);

        GenerateEmailPage generateEmailPage = new GenerateEmailPage(driver);
        enterGenerateEmail(generateEmailPage);
        highlighterMethod(sendEmail, driver);
        findAndJsClick(javascriptExecutor, sendEmail);

        return generateEmailPage.checkEmailShouldContain(price);
    }

    public void enterGenerateEmail(GenerateEmailPage generateEmailPage) {
        String generateEmail = generateEmailPage.generateEmail(javascriptExecutor);
        Assert.assertNotNull(generateEmail);
        highlighterMethod(fieldEmail, driver);
        findAndJsClick(javascriptExecutor, fieldEmail);
        fieldEmail.sendKeys(generateEmail);
    }

}

