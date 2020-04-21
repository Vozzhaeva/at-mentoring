package com.epam.tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class CosCalculatorTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForCos")
    void CosTest(double a, double expectedValue) {
        double result = calculator.cos(a);
        Assertions.assertEquals(expectedValue, result, "Invalid result of cos operation!");
    }

    private static Stream<Arguments> valuesForCos() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0.5403023058681398),
                Arguments.of(-1, 0.5403023058681398),
                Arguments.of(123, -0.8879689066918555),
                Arguments.of(-56, 0.853220107722584),
                Arguments.of(5.6, 0.7755658785102496),
                Arguments.of(-2.3, -0.666276021279824)
        );
    }
}
