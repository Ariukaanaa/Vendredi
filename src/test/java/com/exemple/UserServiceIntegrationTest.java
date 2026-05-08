package com.exemple;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceIntegrationTest {

    // Calculator + UserService хоёрыг хамт тестлэнэ
    Calculator  calc ; 
    UserService userService ;

    @BeforeEach
    void setUp()
    {
        calc = new Calculator();
        userService = new UserService();
    }

    @Test
    void testSaveAndFind() {
        // Хадгална
        userService.save(1, "Батболд");

        // Олдох ёстой
        assertEquals("Батболд", userService.findById(1));
    }

    @Test
    void testSaveAndExists() {
        userService.save(2, "Дорж");

        // Байх ёстой
        assertTrue(userService.exists(2));

        // Байхгүй ёстой
        assertFalse(userService.exists(99));
    }

    @Test
    void testCalculatorWithUserService() {
        // ID тооцоолоод хэрэглэгч хадгална
        int id = calc.add(1, 1); // 2
        userService.save(id, "Болд");

        // ID 2-р олдох ёстой
        assertEquals("Болд", userService.findById(2));
    }
}