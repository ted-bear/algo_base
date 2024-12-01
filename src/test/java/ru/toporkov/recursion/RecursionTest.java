package ru.toporkov.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecursionTest {

    @Test
    void givenOne_whenPowerInZero_thenReturnOne() {
        // given
        int n = 1;
        int m = 0;

        // when
        long res = Recursion.power(n, m);

        // then
        assertEquals(1, res);
    }

    @Test
    void givenOne_whenPowerInOne_thenReturnOne() {
        // given
        int n = 1;
        int m = 1;

        // when
        long res = Recursion.power(n, m);

        // then
        assertEquals(1, res);
    }

    @Test
    void givenOne_whenPowerInTwo_thenReturnOne() {
        // given
        int n = 1;
        int m = 2;

        // when
        long res = Recursion.power(n, m);

        // then
        assertEquals(1, res);
    }

    @Test
    void givenTwo_whenPowerInOne_thenReturnOne() {
        // given
        int n = 2;
        int m = 1;

        // when
        long res = Recursion.power(n, m);

        // then
        assertEquals(2, res);
    }

    @Test
    void givenTwo_whenPowerInTwo_thenReturnOne() {
        // given
        int n = 2;
        int m = 2;

        // when
        long res = Recursion.power(n, m);

        // then
        assertEquals(4, res);
    }

    @Test
    void givenTwo_whenPowerInZero_thenReturnOne() {
        // given
        int n = 2;
        int m = 0;

        // when
        long res = Recursion.power(n, m);

        // then
        assertEquals(1, res);
    }

    @Test
    void givenThree_whenPowerInThree_thenReturnNine() {
        // given
        int n = 3;
        int m = 3;

        // when
        long res = Recursion.power(n, m);

        // then
        assertEquals(27, res);
    }

    @Test
    void givenTen_whenPowerInThree_thenReturnAThousand() {
        // given
        int n = 10;
        int m = 3;

        // when
        long res = Recursion.power(n, m);

        // then
        assertEquals(1000, res);
    }
}