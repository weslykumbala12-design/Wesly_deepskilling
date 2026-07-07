package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorParameterizedTest {

    private final CalculatorService service =
            new CalculatorService();

    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "10, 20, 30",
        "-5, 5, 0",
        "0, 0, 0"
    })
    void testAdd(
            int a,
            int b,
            int expected
    ) {
        assertEquals(
                expected,
                service.add(a, b)
        );
    }
}