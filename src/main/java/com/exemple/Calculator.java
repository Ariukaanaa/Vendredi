package com.exemple;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("0-д хуваах боломжгүй!");
        return a / b;
    }
}