package com.epam.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubCalculatorTest extends BaseTest {

    @Test(dataProvider = "valuesForSubLongTest")
    public void subLongTest(long a, long b, long expectedValue) {
        long result = calculator.sub(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of sub operation!");
    }

    @DataProvider(name = "valuesForSubLongTest")
    public Object[][] valuesForSubLong() {
        return new Object[][]{
                {10, 13, -3},
                {10, -1, 11},
                {-4, 6, -10},
                {0, 0, 0},
                {-6, -7, 1}
        };
    }

    @Test(dataProvider = "valuesForSubDoubleTest")
    public void subDoubleTest(double a, double b, double expectedValue) {
        double result = calculator.sub(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of sub operation!");
    }

    @DataProvider(name = "valuesForSubDoubleTest")
    public Object[][] valuesForSubDouble() {
        return new Object[][]{
                {10.78456, 13.34906, -2.5645},
                {10.65, -1.12, 11.77},
                {-4.345, 6.907, -11.252},
                {0, 0, 0},
                {-65.8765, -7.4565, -58.42}
        };
    }
}
