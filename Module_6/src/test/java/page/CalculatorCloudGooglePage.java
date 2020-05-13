package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CalculatorCloudGooglePage extends AbstractPage {
    private JavascriptExecutor javascriptExecutor;

    @FindBy(xpath = "//article[@class='devsite-article']/article[@class='devsite-article-inner']/div[2]/article/devsite-iframe/iframe")
    private WebElement firstFrame;

    @FindBy(xpath = "//iframe")
    private WebElement secondFrame;

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngineTab;

    @FindBy(xpath = "//input[@id='input_58']")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//md-select[@id='select_70']/md-select-value/span[1]/div")
    private WebElement operatingSystem;

    @FindBy(xpath = "//md-option[@id='select_option_60']")
    private WebElement operatingSystemOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    private WebElement machineClass;

    @FindBy(xpath = "//md-option[@id='select_option_72']")
    private WebElement machineClassOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement machineType;

    @FindBy(xpath = "//*[contains(text(),'n1-standard-8')]")
    private WebElement machineTypeOption;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsCheckBox;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement gpuCount;

    @FindBy(xpath = "//md-option[@id='select_option_339']")
    private WebElement gpuCountOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement gpuType;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement gpuTypeOption;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement ssd;

    @FindBy(xpath = "//md-option[@id='select_option_233']")
    private WebElement ssdOption;

    @FindBy(xpath = "//md-select[@id='select_85']")
    private WebElement location;

    @FindBy(xpath = "//md-option[@id='select_option_181']")
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
        computeEngineTab.click();
        return this;
    }

    public CalculatorCloudGooglePage enterNumberOfInstances(String countOfInstances) {
        numberOfInstancesInput.sendKeys(countOfInstances);
        return this;
    }

    public CalculatorCloudGooglePage enterOperatingSystem() {
        findAndJsClick(operatingSystem);
        findAndJsClick(operatingSystemOption);
        return this;
    }

    public CalculatorCloudGooglePage enterVMClass() {
        findAndJsClick(machineClass);
        findAndJsClick(machineClassOption);
        return this;
    }

    public CalculatorCloudGooglePage enterMachineType() {
        findAndJsClick(machineType);
        findAndJsClick(machineTypeOption);
        return this;
    }

    public CalculatorCloudGooglePage enterGPUs() {
        findAndJsClick(addGPUsCheckBox);
        findAndJsClick(gpuCount);
        findAndJsClick(gpuCountOption);
        findAndJsClick(gpuType);
        findAndJsClick(gpuTypeOption);
        return this;
    }

    public CalculatorCloudGooglePage enterSSD() {
        findAndJsClick(ssd);
        findAndJsClick(ssdOption);
        return this;
    }

    public CalculatorCloudGooglePage enterDatecenterLocation() {
        findAndJsClick(location);
        findAndJsClick(locationOption);
        return this;
    }

    public CalculatorCloudGooglePage enterCommitedUsage() {
        findAndJsClick(cud);
        findAndJsClick(cudOption);
        return this;
    }

    public CalculatorCloudGooglePage clickAddToEstimate() {
        findAndJsClick(addToEstimate);
        return this;
    }

    public Set<String> getResult() {
        Set<String> actualResult = result.stream().map(e -> e.getText()).collect(Collectors.toSet());
        return actualResult;
    }

    private WebElement findAndJsClick(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true); ", element);
        javascriptExecutor.executeScript("arguments[0].click();", element);

        return element;
    }

    public boolean sendEmail() {
        String price = priceSelector.getText();

        findAndJsClick(emailEstimate);
        findAndJsClick(fieldEmail);

        GenerateEmailPage generateEmailPage = new GenerateEmailPage(driver);
        enterGenerateEmail(generateEmailPage);

        findAndJsClick(sendEmail);

        return generateEmailPage.checkEmailShouldContain(price);
    }

    public void enterGenerateEmail(GenerateEmailPage generateEmailPage) {
        String generateEmail = generateEmailPage.generateEmail(javascriptExecutor);
        findAndJsClick(fieldEmail);
        fieldEmail.sendKeys(generateEmail);
    }

}

