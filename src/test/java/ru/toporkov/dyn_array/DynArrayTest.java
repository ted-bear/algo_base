package ru.toporkov.dyn_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DynArrayTest {

    Integer defaultCapacity = 16;
    DynArray<Integer> array;

    @Test
    void append_buffer_not_full() {
        array = new DynArray<>(Integer.class);
        array.append(3);

        assertEquals(defaultCapacity, array.capacity);
        assertEquals(1, array.count);
        assertEquals(3, array.getItem(0));
    }

    @Test
    void append_buffer_is_full() {
        array = new DynArray<>(Integer.class);

        for (int i = 0; i < 16; i++) {
            array.append(i + 1);
        }

        array.append(100);

        assertEquals(defaultCapacity * 2, array.capacity);
        assertEquals(100, array.getItem(array.count - 1));
    }

    @Test
    void insert_throw_exception() {
        array = new DynArray<>(Integer.class);

        assertThrows(RuntimeException.class, () -> array.insert(100, 18));
    }

    @Test
    void remove_without_change_buffer() {
        array = new DynArray<>(Integer.class);

        for (int i = 0; i < 16; i++) {
            array.append(i + 1);
        }

        array.remove(15);

        for (int i = 0; i < array.count; i++) {
            assertEquals(i + 1, array.getItem(i));
        }
        assertEquals(defaultCapacity, array.capacity);
    }

    @Test
    void remove_with_change_buffer() {
        array = new DynArray<>(Integer.class);

        for (int i = 0; i < 48; i++) {
            array.append(i + 1);
        }

        for (int i = 0; i < 17; i++) {
            array.remove(array.count - 1);
        }

        for (int i = 0; i < array.count; i++) {
            assertEquals(i + 1, array.getItem(i));
        }

        assertEquals(42, array.capacity);
    }
}