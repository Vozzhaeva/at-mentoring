package com.epam.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivCalculatorTest extends BaseTest {

    @Test(dataProvider = "valuesForDivLongTest")
    public void divLongTest(long a, long b, double expectedValue) {
        long result = calculator.div(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of div operation!");
    }

    @DataProvider(name = "valuesForDivLongTest")
    public Object[][] valuesForDivLong() {
        return new Object[][]{
                {20, 10, 2},
                {452, 8, 56.5},
                {-489, 8, -61.125},
                {258, -8, -32.25},
                {-147, -5, -29.4},
                {0, 9, 0},
                {0, -7, 0}
        };
    }

    @Test(dataProvider = "valuesForDivDoubleTest")
    public void divDoubleTest(double a, double b, double expectedValue) {
        double result = calculator.div(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of div operation!");
    }

    @DataProvider(name = "valuesForDivDoubleTest")
    public Object[][] valuesForDivDouble() {
        return new Object[][]{
                {20.6, 10.56, 1.9507575757575757},
                {-489.45, 8.9, -54.9943820224719},
                {258.34, -8.91, -28.99438832772166},
                {-147.1, -5.8, 25.362068965517242},
                {0, 9.678, 0},
                {0, -7.432, 0}
        };
    }

    @Test(expectedExceptions = NumberFormatException.class, groups = "Exceptions")
    public void divByZeroDoubleTest() {
        calculator.div(0.0, 0.0);

    }

    @Test(expectedExceptions = NumberFormatException.class, groups = "Exceptions")
    public void divByZeroLongTest() {
        calculator.div(0, 0);

    }
}
