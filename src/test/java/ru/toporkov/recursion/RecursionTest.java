package ru.toporkov.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.toporkov.recursion.Recursion.calculateListLength;
import static ru.toporkov.recursion.Recursion.calculateSumOfNumbers;
import static ru.toporkov.recursion.Recursion.findSecondMax;
import static ru.toporkov.recursion.Recursion.isPalindrome;
import static ru.toporkov.recursion.Recursion.power;
import static ru.toporkov.recursion.Recursion.printEvenElements;
import static ru.toporkov.recursion.Recursion.printEvens;

class RecursionTest {

    @Test
    void givenOne_whenPowerInZero_thenReturnOne() {
        // given
        int n = 1;
        int m = 0;

        // when
        long res = power(n, m);

        // then
        assertEquals(1, res);
    }

    @Test
    void givenOne_whenPowerInOne_thenReturnOne() {
        // given
        int n = 1;
        int m = 1;

        // when
        long res = power(n, m);

        // then
        assertEquals(1, res);
    }

    @Test
    void givenOne_whenPowerInTwo_thenReturnOne() {
        // given
        int n = 1;
        int m = 2;

        // when
        long res = power(n, m);

        // then
        assertEquals(1, res);
    }

    @Test
    void givenTwo_whenPowerInOne_thenReturnOne() {
        // given
        int n = 2;
        int m = 1;

        // when
        long res = power(n, m);

        // then
        assertEquals(2, res);
    }

    @Test
    void givenTwo_whenPowerInTwo_thenReturnOne() {
        // given
        int n = 2;
        int m = 2;

        // when
        long res = power(n, m);

        // then
        assertEquals(4, res);
    }

    @Test
    void givenTwo_whenPowerInZero_thenReturnOne() {
        // given
        int n = 2;
        int m = 0;

        // when
        long res = power(n, m);

        // then
        assertEquals(1, res);
    }

    @Test
    void givenThree_whenPowerInThree_thenReturnNine() {
        // given
        int n = 3;
        int m = 3;

        // when
        long res = power(n, m);

        // then
        assertEquals(27, res);
    }

    @Test
    void givenTen_whenPowerInThree_thenReturnAThousand() {
        // given
        int n = 10;
        int m = 3;

        // when
        long res = power(n, m);

        // then
        assertEquals(1000, res);
    }

    ////////////////////////////////////////////////////////////////

    @Test
    void givenOne_whenSumItsNumbers_thenReturnOne() {
        // given
        int n = 1;

        // when
        long res = calculateSumOfNumbers(n);

        // then
        assertEquals(1, res);
    }

    @Test
    void givenTwo_whenSumItsNumbers_thenReturnTwo() {
        // given
        int n = 2;

        // when
        long res = calculateSumOfNumbers(n);

        // then
        assertEquals(2, res);
    }

    @Test
    void givenTen_whenSumItsNumbers_thenReturnOne() {
        // given
        int n = 10;

        // when
        long res = calculateSumOfNumbers(n);

        // then
        assertEquals(1, res);
    }

    @Test
    void givenEleven_whenSumItsNumbers_thenReturnTwo() {
        // given
        int n = 11;

        // when
        long res = calculateSumOfNumbers(n);

        // then
        assertEquals(2, res);
    }

    @Test
    void givenTwentyOne_whenSumItsNumbers_thenReturnThree() {
        // given
        int n = 21;

        // when
        long res = calculateSumOfNumbers(n);

        // then
        assertEquals(3, res);
    }

    @Test
    void given111_whenSumItsNumbers_thenReturn3() {
        // given
        int n = 111;

        // when
        long res = calculateSumOfNumbers(n);

        // then
        assertEquals(3, res);
    }

    @Test
    void givenIntMax_whenSumItsNumbers_thenReturn46() {
        // given
        int n = Integer.MAX_VALUE;

        // when
        long res = calculateSumOfNumbers(n);

        // then
        assertEquals(46, res);
    }

    @Test
    void givenNegativeOne_whenSumItsNumbers_thenReturnOne() {
        // given
        int n = -1;

        // when
        long res = calculateSumOfNumbers(n);

        // then
        assertEquals(1, res);
    }

    @Test
    void givenIntMin_whenSumItsNumbers_thenReturnOne() {
        // given
        int n = Integer.MIN_VALUE;

        // when
        long res = calculateSumOfNumbers(n);

        // then
        assertEquals(47, res);
    }


    /////////////////////////////////////////////////////////////////

    @Test
    void givenZeroLengthList_whenCalculateLength_thenReturnZero() {
        // given
        List<Integer> list = List.of();

        // when
        long length = calculateListLength(list);

        // then
        assertEquals(0, length);
    }

    @Test
    void givenOneLengthList_whenCalculateLength_thenReturnOne() {
        // given
        List<Integer> list = new ArrayList<>(List.of(1));

        // when
        long length = calculateListLength(list);

        // then
        assertEquals(1, length);
    }


    @Test
    void givenTwoLengthList_whenCalculateLength_thenReturnTwo() {
        // given
        List<Integer> list = new ArrayList<>(List.of(1, 2));

        // when
        long length = calculateListLength(list);

        // then
        assertEquals(2, length);
    }

    @Test
    void givenAThousandLengthList_whenCalculateLength_thenReturnAThousand() {
        // given
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        // when
        long length = calculateListLength(list);

        // then
        assertEquals(1000, length);
    }


    /////////////////////////////////////////////////////////////////

    @Test
    void giveEmptyString_whenIsPalindrome_thenTrue() {
        // given
        String str = "";

        // when
        boolean isPalindrome = isPalindrome(str);

        // then
        assertTrue(isPalindrome);
    }

    @Test
    void giveOneLengthString_whenIsPalindrome_thenTrue() {
        // given
        String str = "a";

        // when
        boolean isPalindrome = isPalindrome(str);

        // then
        assertTrue(isPalindrome);
    }

    @Test
    void giveTwoLengthPalindrome_whenIsPalindrome_thenTrue() {
        // given
        String str = "aa";

        // when
        boolean isPalindrome = isPalindrome(str);

        // then
        assertTrue(isPalindrome);
    }

    @Test
    void giveTwoLengthNotPalindrome_whenIsPalindrome_thenFalse() {
        // given
        String str = "ab";

        // when
        boolean isPalindrome = isPalindrome(str);

        // then
        assertFalse(isPalindrome);
    }

    @Test
    void giveThreeLengthPalindrome_whenIsPalindrome_thenTrue() {
        // given
        String str = "aba";

        // when
        boolean isPalindrome = isPalindrome(str);

        // then
        assertTrue(isPalindrome);
    }

    @Test
    void giveThreeLengthNotPalindrome_whenIsPalindrome_thenFalse() {
        // given
        String str = "aab";

        // when
        boolean isPalindrome = isPalindrome(str);

        // then
        assertFalse(isPalindrome);
    }

    @Test
    void giveFourLengthPalindrome_whenIsPalindrome_thenTrue() {
        // given
        String str = "abba";

        // when
        boolean isPalindrome = isPalindrome(str);

        // then
        assertTrue(isPalindrome);
    }

    @Test
    void giveFourLengthNotPalindrome_whenIsPalindrome_thenFalse() {
        // given
        String str = "abca";

        // when
        boolean isPalindrome = isPalindrome(str);

        // then
        assertFalse(isPalindrome);
    }

    @Test
    void givePalindromeSentence_whenIsPalindrome_thenFalse() {
        // given
        String str = "Was it a car or a cat I saw";

        // when
        boolean isPalindrome = isPalindrome(str);

        // then
        assertTrue(isPalindrome);
    }

    @Test
    void givenList_whenPrintEvenElements_givenNothing() {
        List<Integer> numbers = List.of(1, 1, 2, 1, 1);
        printEvenElements(numbers);
    }

    @Test
    void givenList_whenPrintEvens_givenNothing() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        printEvens(numbers);
    }

    /////////////////////////////////////////////////////////////////

    @Test
    void givenEmptyArray_whenFindSecondMax_thenThrowsException() {
        // given
        long[] array = new long[0];

        //when -- then
        assertThrows(IndexOutOfBoundsException.class, () -> findSecondMax(array));
    }

    @Test
    void givenSingleElementArray_whenFindSecondMax_thenReturnFirstElement() {
        // given
        long[] array = new long[]{6};

        // when
        long secondMax = findSecondMax(array);

        // then
        assertEquals(6, secondMax);
    }

    @Test
    void givenTwoElementsArray_whenFindSecondMax_thenReturnSecondMax() {
        // given
        long[] array = new long[]{6, 7};

        // when
        long secondMax = findSecondMax(array);

        // then
        assertEquals(6, secondMax);
    }

    @Test
    void givenTwoEqualsElementsArray_whenFindSecondMax_thenReturnSecondMax() {
        // given
        long[] array = new long[]{6, 6};

        // when
        long secondMax = findSecondMax(array);

        // then
        assertEquals(6, secondMax);
    }

    @Test
    void givenThreeElementsArray_whenFindSecondMax_thenReturnSecondMax() {
        // given
        long[] array = new long[]{7, 5, 9};

        // when
        long secondMax = findSecondMax(array);

        // then
        assertEquals(7, secondMax);
    }

    @Test
    void givenFiveElementsArray_whenFindSecondMax_thenReturnFive() {
        // given
        long[] array = new long[]{2, 5, 4, 3, 5};

        // when
        long secondMax = findSecondMax(array);

        // then
        assertEquals(5, secondMax);
    }

    @Test
    void givenFiveElementsArray_whenFindSecondMax_thenReturnFour() {
        // given
        long[] array = new long[]{2, 5, 4, 3, 4};

        // when
        long secondMax = findSecondMax(array);

        // then
        assertEquals(4, secondMax);
    }
}