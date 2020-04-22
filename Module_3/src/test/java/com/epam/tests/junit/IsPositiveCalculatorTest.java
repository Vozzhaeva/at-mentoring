package com.epam.tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class IsPositiveCalculatorTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForIsPositive")
    void IsPositiveTest(long a, boolean expectedValue) {
        boolean result = calculator.isPositive(a);
        Assertions.assertEquals(expectedValue, result, "Invalid result of isPositive operation!");
    }

    private static Stream<Arguments> valuesForIsPositive() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(1, true),
                Arguments.of(-1, false),
                Arguments.of(123, true),
                Arguments.of(-56, false)
        );
    }
}
