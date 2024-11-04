package ru.toporkov.dyn_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankDynArrayTest {

    BankingMethodArray<Integer> array;

    @Test
    void append_empty_test() {
        array = new BankingMethodArray<>(Integer.class);

        assertEquals(0, array.operationsCount);
        assertEquals(0, array.count);
    }

    @Test
    void append_single_op_test() {
        array = new BankingMethodArray<>(Integer.class);
        array.append(1);

        assertEquals(1, array.getItem(0));
        assertEquals(3, array.operationsCount);
    }

    @Test
    void append_six_op_test() {
        array = new BankingMethodArray<>(Integer.class);
        array.append(1);
        array.append(2);
        array.append(3);
        array.append(4);
        array.append(5);

        assertEquals(15, array.operationsCount);

        array.append(6);

        assertEquals(32, array.capacity);
        assertEquals(17, array.operationsCount);

        array.append(7);
        array.append(8);
        array.append(9);
        array.append(10);
        array.append(11);

        assertEquals(64, array.capacity);
        assertEquals(30, array.operationsCount);
    }

}