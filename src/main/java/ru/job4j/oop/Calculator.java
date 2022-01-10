package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int value) {
        return value - x;
    }

    public int divide(int value) {
        return value / x;
    }

    public int sumAllOperation(int value) {
        return sum(value) + multiply(value) + minus(value) + divide(value);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int minusRsl = minus(6);
        int divideRsl = calculator.divide(15);
        int allRsl = calculator.sumAllOperation(20);
    }
}
