package ru.toporkov.recursion;

public class Recursion {

    // возведение числа N в степень M
    public static long power(int n, int m) {
        if (m == 0) return 1;
        if (m == 1) return n;

        return n * power(n, m - 1);
    }

    // вычисление суммы цифр числа
    public static long calculateSumOfNumbers(long number) {
        number = Math.abs(number);
        long countOfNumbers = (long) Math.log10(number * 1.);

        if (countOfNumbers == 0) return number;

        return number % 10 + calculateSumOfNumbers(number / 10);
    }
}
