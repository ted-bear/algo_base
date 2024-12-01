package ru.toporkov.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.toporkov.recursion.Recursion.calculateSumOfNumbers;
import static ru.toporkov.recursion.Recursion.power;

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
}