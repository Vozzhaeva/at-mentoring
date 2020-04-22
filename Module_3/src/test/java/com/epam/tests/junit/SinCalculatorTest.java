package com.epam.tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class SinCalculatorTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForSin")
    void SinTest(double a, double expectedValue) {
        double result = calculator.sin(a);
        Assertions.assertEquals(expectedValue, result, "Invalid result of sin operation!");
    }

    private static Stream<Arguments> valuesForSin() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 0.8414709848078965),
                Arguments.of(-1, -0.8414709848078965),
                Arguments.of(123, -0.45990349068959124),
                Arguments.of(-56, 0.5215510020869119),
                Arguments.of(5.6, -0.6312666378723216),
                Arguments.of(-2.3, -0.7457052121767203)
        );
    }
}
