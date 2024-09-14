package ru.toporkov.dyn_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiDimensionalArrayTest {

    MultiDimensionalArray<Integer> array;

    @Test
    void getItem_one_dim_array() {
        array = new MultiDimensionalArray<>(Integer.class);
        array.append(0, 2);

        assertEquals(1, array.dimensionCount);
        assertEquals(2, array.getItem(0, 0));
        assertEquals(16, array.getDimension(0).capacity);
    }

    @Test
    void getDimension() {
        array = new MultiDimensionalArray<>(Integer.class);
        array.append(0, 2);
        array.addDimension();
        array.append(1, 3);

        assertEquals(2, array.dimensionCount);
        assertEquals(2, array.getItem(0, 0));
        assertEquals(3, array.getItem(1, 0));
        assertEquals(16, array.getDimension(0).capacity);
        assertEquals(16, array.getDimension(1).capacity);
    }

    @Test
    void insert() {
        array = new MultiDimensionalArray<>(Integer.class);
        array.append(0, 2);
        array.append(0, 3);
        array.append(0, 4);
        array.append(0, 5);
        array.addDimension();
        array.append(1, 3);
        array.append(1, 3);
        array.append(1, 3);
        array.append(1, 3);

        array.insert(0, 0, 1);
        array.insert(0, 1, 1);

        assertEquals(2, array.dimensionCount);
        assertEquals(0, array.getItem(0, 1));
        assertEquals(0, array.getItem(1, 1));
        assertEquals(16, array.getDimension(0).capacity);
        assertEquals(16, array.getDimension(1).capacity);
        assertEquals(5, array.getDimension(0).count);
        assertEquals(5, array.getDimension(1).count);
    }

    @Test
    void remove() {
        array = new MultiDimensionalArray<>(Integer.class);
        array.append(0, 2);
        array.append(0, 3);
        array.append(0, 4);
        array.append(0, 5);
        array.addDimension();
        array.append(1, 1);
        array.append(1, 2);
        array.append(1, 3);
        array.append(1, 4);

        array.remove(0, 0);
        array.remove(1, 1);

        assertEquals(2, array.dimensionCount);
        assertEquals(3, array.getItem(0, 0));
        assertEquals(3, array.getItem(1, 1));
        assertEquals(16, array.getDimension(0).capacity);
        assertEquals(16, array.getDimension(1).capacity);
        assertEquals(3, array.getDimension(0).count);
        assertEquals(3, array.getDimension(1).count);
    }
}