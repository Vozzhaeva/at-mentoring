package com.epam.tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class CtgCalculatorTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForCtg")
    void CtgTest(double a, double expectedValue) {
        double result = calculator.ctg(a);
        System.out.println(Math.cos(a)/Math.sin(a));
        Assertions.assertEquals(expectedValue, result, "Invalid result of ctg operation!");
    }

    private static Stream<Arguments> valuesForCtg() {
        return Stream.of(
                Arguments.of(1, 0.6420926159343308),
                Arguments.of(-1, -0.6420926159343308),
                Arguments.of(123, 1.9307722699830172),
                Arguments.of(-56, 1.6359284217814665),
                Arguments.of(5.6, -1.2285868315871835),
                Arguments.of(-2.3, 0.89348446329744475)
        );
    }
}
