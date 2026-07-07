package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    @Test
    void testAdd() {
        CalculatorService service =
                new CalculatorService();

        int result = service.add(2, 3);

        assertEquals(5, result);
    }
}