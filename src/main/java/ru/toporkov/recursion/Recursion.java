package ru.toporkov.recursion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
        return isPalindromeInternal(lowerCase, 0);
    }

    private static boolean isPalindromeInternal(String string, int charIndex) {
        if (string.isEmpty()) {
            return true;
        }

        if (charIndex >= string.length() - 1 - charIndex) {
            return true;
        }

        if (string.charAt(charIndex) != string.charAt(string.length() - 1 - charIndex)) return false;

        return isPalindromeInternal(string, charIndex + 1);
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

        if (index >= numbers.size()) return;

        System.out.println(numbers.get(index));

        printEvens(numbers, index + 2);
    }


    // нахождение второго максимального числа в списке (с учётом, что максимальных может быть несколько, если они равны)
    public static long findSecondMax(long[] array) {
        if (array.length == 0) {
            throw new ArrayIndexOutOfBoundsException("Передан пустой массив");
        }

        if (array.length == 1) {
            return array[0];
        }

        int firstMaxIndex = array[0] > array[1] ? 0 : 1;
        int secondMaxIndex = array[0] > array[1] ? 1 : 0;

        return array[findSecondMax(array, firstMaxIndex, secondMaxIndex, 2)];
    }

    private static int findSecondMax(long[] array, int firstMaxIndex, int secondMaxIndex, int currentIndex) {
        if (currentIndex >= array.length) {
            return secondMaxIndex;
        }

        if (array[currentIndex] > array[firstMaxIndex]) {
            secondMaxIndex = firstMaxIndex;
            firstMaxIndex = currentIndex;
        } else if (array[currentIndex] > array[secondMaxIndex]) {
            secondMaxIndex = currentIndex;
        }

        return findSecondMax(array, firstMaxIndex, secondMaxIndex, currentIndex + 1);
    }


    // поиск всех файлов в заданном каталоге, включая файлы, расположенные в подкаталогах произвольной вложенности
    public static List<Path> findAllFiles(Path rootDirectory) {
        List<Path> resultFiles = new ArrayList<>();

        try (Stream<Path> walking = Files.walk(rootDirectory, 1)) {
            walking.skip(1).forEach(file -> {
                if (Files.isRegularFile(file)) {
                    resultFiles.add(file.getFileName());
                } else {
                    resultFiles.addAll(findAllFiles(file));
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return resultFiles;
    }
}
