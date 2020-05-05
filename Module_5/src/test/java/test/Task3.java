package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorCloudGooglePage;
import page.CloudGooglePage;
import page.PricingCloudGooglePage;
import page.ProductsCloudGooglePage;

import java.util.HashSet;
import java.util.Set;

public class Task3 extends BaseTest {

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
    public void CalculatorTest() {

        ProductsCloudGooglePage productsCloudGooglePage = new CloudGooglePage(super.driver)
                .openPage()
                .typeButtonProducts()
                .typeButtonSeeAllProducts();

        PricingCloudGooglePage pricingCloudGooglePage = productsCloudGooglePage
                .clickPricing();

        CalculatorCloudGooglePage calculatorCloudGooglePage = pricingCloudGooglePage
                .clickCalculators();

        Set<String> actualResult = calculatorCloudGooglePage
                .clickComputeEngine()
                .enterNumberOfInstances("4")
                .enterOperatingSystem()
                .enterVMClass()
                .enterMachineType()
                .enterGPUs()
                .enterSSD()
                .enterDatecenterLocation()
                .enterCommitedUsage()
                .clickAddToEstimate()
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
    }
}
