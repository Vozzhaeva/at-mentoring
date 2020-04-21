package com.epam.tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class TgCalculatorTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("valuesForTg")
    void TgTest(double a, double expectedValue) {
        double result = calculator.tg(a);
        Assertions.assertEquals(expectedValue, result, "Invalid result of tg operation!");
    }

    private static Stream<Arguments> valuesForTg() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1.5574077246549023),
                Arguments.of(-1, -1.5574077246549023),
                Arguments.of(123, 0.5179274715856552),
                Arguments.of(-56, 0.6112736881917098),
                Arguments.of(5.6, -0.8139432836897027),
                Arguments.of(-2.3, 1.1192136417341325)
        );
    }
}
