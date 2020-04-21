package com.epam.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtCalculatorTest extends BaseTest {

    @Test(dataProvider = "valuesForSqrtTest")
    public void sqrtTest(double a, double expectedValue) {
        double result = calculator.sqrt(a);
        Assert.assertEquals(result, expectedValue, "Invalid result of sqrt operation!");
    }

    @DataProvider(name = "valuesForSqrtTest")
    public Object[][] valuesForSqrt() {
        return new Object[][]{
                {1, 1},
                {0, 0},
                {4.5, 2.1213203435596424},
                {16, 4},
                {3674, 60.61352984276695},
        };
    }

    @Test(expectedExceptions = NumberFormatException.class, groups = "Exceptions")
    public void sqrtExceptionTest() {
        calculator.sqrt(-4);

    }

}
