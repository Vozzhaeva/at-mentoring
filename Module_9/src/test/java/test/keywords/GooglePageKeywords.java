package test.keywords;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;
import org.testng.Assert;
import pages.google.CalculatorCloudGooglePage;
import pages.google.CloudGooglePage;
import pages.google.PricingCloudGooglePage;
import pages.google.ProductsCloudGooglePage;

import java.util.HashSet;
import java.util.Set;

public class GooglePageKeywords extends BaseKeywords {
    ProductsCloudGooglePage productsCloudGooglePage;
    PricingCloudGooglePage pricingCloudGooglePage;
    CalculatorCloudGooglePage calculatorCloudGooglePage;
    CloudGooglePage cloudGooglePage;

    @Допустим("пользователь открывает страницу браузера и открывает сайт clouds.google")
    public void init() {
        super.browserSetup();
        cloudGooglePage = new CloudGooglePage(super.driver)
                .openPage();
    }

    @Допустим("страница clouds.google успешно открылась")
    public void isPageOpen() {
        Assert.assertNotNull(driver.getTitle());
    }

    @Если("открыть страницу калькулятора")
    public void openCalculatorPage() {
        productsCloudGooglePage = cloudGooglePage
                .typeButtonProducts()
                .typeButtonSeeAllProducts();
        pricingCloudGooglePage = productsCloudGooglePage
                .clickPricing();
        calculatorCloudGooglePage = pricingCloudGooglePage
                .clickCalculators();
    }

    @Если("заполнить значения в калькуляторе")
    public void fillCalculatorValues() {
       calculatorCloudGooglePage =  calculatorCloudGooglePage
                .clickComputeEngine()
                .enterNumberOfInstances("4")
                .enterOperatingSystem()
                .enterVMClass()
                .enterMachineType()
                .enterGPUs()
                .enterSSD()
                .enterDatecenterLocation()
                .enterCommitedUsage();
    }

    @Если("нажать кнопку Add to estimate")
    public void clickButton() {
        calculatorCloudGooglePage.clickAddToEstimate();
    }

    @То("ожидаемые значения соответствуют заданным")
    public void assertResult() {
        Set<String> actualResult = calculatorCloudGooglePage
                .getResult();

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
        browserTearDown();
    }
}
