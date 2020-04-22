package com.epam.tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DivCalculatorTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForDiv")
    void DivTest(double a, double b, double expectedValue) {
        double result = calculator.div(a, b);
        Assertions.assertEquals(expectedValue, result, "Invalid result of div operation!");
    }

    private static Stream<Arguments> valuesForDiv() {
        return Stream.of(
                Arguments.of(20.6, 10.56, 1.9507575757575757),
                Arguments.of(-489.45, 8.9, -54.9943820224719),
                Arguments.of(258.34, -8.91, -28.99438832772166),
                Arguments.of(-147.1, -5.8, 25.3620689655172425),
                Arguments.of(0, 9.678, 0)
        );
    }

    @Test
    void divByZeroDoubleTest() {
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> calculator.div(0.0, 0.0));
        String expectedMessage = "Attempt to divide by zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void divByZeroLongTest() {
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> calculator.div(0, 0));
        String expectedMessage = "Attempt to divide by zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}

