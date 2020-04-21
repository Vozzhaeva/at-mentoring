package com.epam.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplicationCalculatorTest extends BaseTest {

    @Test(dataProvider = "valuesForMultLongTest")
    public void multLongTest(long a, long b, long expectedValue) {
        long result = calculator.mult(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of multiplication!");
    }

    @DataProvider(name = "valuesForMultLongTest")
    public Object[][] valuesForMultLong() {
        return new Object[][]{
                {10, 13, 130},
                {10, -1, -10},
                {-4, 6, -24},
                {0, 0, 0},
                {0, -7, 0},
                {-6, 0, 0}
        };
    }

    @Test(dataProvider = "valuesForMultDoubleTest")
    public void multDoubleTest(double a, double b, double expectedValue) {
        double result = calculator.mult(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of multiplication!");
    }

    @DataProvider(name = "valuesForMultDoubleTest")
    public Object[][] valuesForMultDouble() {
        return new Object[][]{
                {10.1, 13.2, 133.32},
                {10.45, -1.12, -11.704},
                {-4.677, 6.543, -30.601611},
                {0, 0, 0},
                {0, -7.3456, 0},
                {-6.1235425, 0, 0}
        };
    }
}
