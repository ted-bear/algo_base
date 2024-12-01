package ru.toporkov.recursion;

public class Recursion {

    // возведение числа N в степень M
    public static long power(int n, int m) {
        if (m == 0) return 1;
        if (m == 1) return n;

        return n * power(n, m - 1);
    }
}
