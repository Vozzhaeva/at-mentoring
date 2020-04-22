package com.epam.tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class IsNegativeCalculatorTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForIsNegative")
    void IsNegativeTest(long a, boolean expectedValue) {
        boolean result = calculator.isNegative(a);
        Assertions.assertEquals(expectedValue, result, "Invalid result of isNegative operation!");
    }

    private static Stream<Arguments> valuesForIsNegative() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(-1, true),
                Arguments.of(123, false),
                Arguments.of(-56, true)
        );
    }
}
