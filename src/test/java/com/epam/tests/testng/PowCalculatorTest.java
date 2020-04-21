package com.epam.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowCalculatorTest extends BaseTest {

    @Test(dataProvider = "valuesForPowTest")
    public void powTest(double a, double b, double expectedValue) {
        double result = calculator.pow(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of pow operation!");
    }

    @DataProvider(name = "valuesForPowTest")
    public Object[][] valuesForPow() {
        return new Object[][]{
                {1, 6, 1},
                {5, 4, 625},
                {7.4, 6, 164206.49017600005},
                {4.9, 3.7, 357.87016711437315},
                {3, 9.1, 21968.65243450933},
                {0, 0, 1},
                {3, -1.1, 0.2986528199469207},
        };
    }

    @Test(expectedExceptions = NumberFormatException.class, groups = "Exceptions")
    public void powExceptionTest() {
        calculator.pow(-3.3, 2.8);
    }
}
