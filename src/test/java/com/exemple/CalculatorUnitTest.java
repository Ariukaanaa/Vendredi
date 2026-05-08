package com.exemple;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorUnitTest {

    Calculator calc ;

    @BeforeEach
    void setUp()
    {
        calc = new Calculator() ; 
    }

    @Test
    void testAdd() {
        // 2 + 3 = 5 байх ёстой
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testDivide() {
        // 10 / 2 = 5 байх ёстой
        assertEquals(5, calc.divide(10, 2));
    }

    @Test
    void testDivideByZero() {
        // 0-д хуваахад exception гарах ёстой
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }
}