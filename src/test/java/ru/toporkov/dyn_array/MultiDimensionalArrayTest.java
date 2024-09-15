package ru.toporkov.dyn_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiDimensionalArrayTest {

    MultiDimensionalArray<Integer> array;

    @Test
    void create_update_two_dimension_array() {
        array = new MultiDimensionalArray<>(Integer.class, 2, 5);
        array.append(1, 0, 4);
        Integer item = array.getItem(0, 0, 4);

        assertEquals(1, item);
    }

    @Test
    void create_update_three_dimension_array() {
        array = new MultiDimensionalArray<>(Integer.class, 2, 2, 5);
        array.append(1, 0, 0, 4);
        Integer item = array.getItem(0, 0, 0, 4);

        assertEquals(1, item);
    }

    @Test
    void insert() {
        array = new MultiDimensionalArray<>(Integer.class, 2, 2, 5);
        array.append(1, 0, 0, 4);
        array.append(2, 0, 0, 4);
        array.append(3, 0, 0, 4);

        array.insert(10, 2, 0, 0, 4);

        Integer item1 = array.getItem(0, 0, 0, 4);
        assertEquals(1, item1);

        Integer item2 = array.getItem(1, 0, 0, 4);
        assertEquals(2, item2);

        Integer item3 = array.getItem(2, 0, 0, 4);
        assertEquals(10, item3);

        Integer item4 = array.getItem(3, 0, 0, 4);
        assertEquals(3, item4);
    }

    @Test
    void remove() {
        array = new MultiDimensionalArray<>(Integer.class, 2, 2, 5);
        array.append(1, 0, 0, 4);
        array.append(2, 0, 0, 4);
        array.append(3, 0, 0, 4);

        array.insert(10, 2, 0, 0, 4);

        Integer item1 = array.getItem(0, 0, 0, 4);
        assertEquals(1, item1);

        Integer item2 = array.getItem(1, 0, 0, 4);
        assertEquals(2, item2);

        Integer item3 = array.getItem(2, 0, 0, 4);
        assertEquals(10, item3);

        Integer item4 = array.getItem(3, 0, 0, 4);
        assertEquals(3, item4);

        array.remove(2, 0, 0, 4);
        assertEquals(3, array.getItem(2, 0, 0, 4));

        assertEquals(3, array.getArrayByIndex(new int[]{0, 0, 4}).count);
    }
}