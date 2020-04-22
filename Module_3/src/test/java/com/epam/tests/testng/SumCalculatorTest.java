package com.epam.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumCalculatorTest extends BaseTest {

    @Test(dataProvider = "valuesForSumLongTest")
    public void sumLongTest(long a, long b, long expectedValue) {
        long result = calculator.sum(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of sum operation!");
    }

    @DataProvider(name = "valuesForSumLongTest")
    public Object[][] valuesForSumLong() {
        return new Object[][]{
                {10, 13, 23},
                {10, -1, 9},
                {-4, 6, 2},
                {0, 0, 0},
                {-6, -7, -13}
        };
    }

    @Test(dataProvider = "valuesForSumDoubleTest")
    public void sumDoubleTest(double a, double b, double expectedValue) {
        double result = calculator.sum(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of sum operation!");
    }

    @DataProvider(name = "valuesForSumDoubleTest")
    public Object[][] valuesForSumDouble() {
        return new Object[][]{
                {10.78456, 13.34906, 24.13362},
                {10.65, -1.12, 9.53},
                {-4.345, 6.907, 2.562},
                {0, 0, 0},
                {-65.8765, -7.4565, -73.333}
        };
    }
}
