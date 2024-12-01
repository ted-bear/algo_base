package ru.toporkov.recursion;

import java.util.List;

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

    // расчёт длины списка, для которого разрешена только операция удаления первого элемента pop(0) (и получение длины конечно)
    public static long calculateListLength(List<?> list) {
        if (list.isEmpty()) {
            return 0;
        }

        list.removeFirst();

        return 1 + calculateListLength(list);
    }

    // проверка, является ли строка палиндромом
    public static boolean isPalindrome(String string) {
        String trimmed = string.replaceAll(" ", "");
        String lowerCase = trimmed.toLowerCase();
        return isPalindromeInternal(lowerCase);
    }

    private static boolean isPalindromeInternal(String string) {
        if (string.isEmpty()) {
            return true;
        }

        if (string.length() == 1) {
            return true;
        }

        return string.charAt(0) == string.charAt(string.length() - 1) &&
                isPalindromeInternal(string.substring(1, string.length() - 1));
    }

    // печать только чётных значений из списка
    public static void printEvenElements(List<Integer> numbers) {
        printEvenElements(numbers, 0);
    }

    private static void printEvenElements(List<Integer> numbers, int index) {

        if (index == numbers.size()) return;

        Integer currentNumber = numbers.get(index);
        if (currentNumber % 2 == 0) {
            System.out.println(currentNumber);
        }

        printEvenElements(numbers, index + 1);
    }

    // печать элементов списка с чётными индексами
    public static void printEvens(List<Integer> numbers) {
        printEvens(numbers, 0);
    }

    private static void printEvens(List<Integer> numbers, int index) {

        if (index == numbers.size()) return;

        if (index % 2 == 0) {
            System.out.println(numbers.get(index));
        }

        printEvens(numbers, index + 1);
    }
}
