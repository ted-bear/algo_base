package ru.toporkov.hash_table;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DynamicHashTableTest {

    DynamicHashTable hashTable;

    @Test
    void put_empty_table() {
        hashTable = new DynamicHashTable(19, 2);

        for (int i = 0; i < 15; i++) {
            assertNotEquals(-1, hashTable.put("key" + i));
        }

        assertNotEquals(-1, hashTable.put("key16"));
        assertEquals(38, hashTable.size);
    }

    @Test
    void put_in_empty() {
        hashTable = new DynamicHashTable(19, 3);
        String value = "a";

        assertEquals(2, hashTable.put(value));
    }

    @Test
    void put_pair_element_empty() {
        hashTable = new DynamicHashTable(19, 3);
        String value = "a";

        assertEquals(2, hashTable.put(value));
        assertEquals(3, hashTable.put("b"));
        assertEquals(4, hashTable.put("c"));
        assertEquals(5, hashTable.put("t"));
    }

    @Test
    void put_two_el_in_one_length_array() {
        hashTable = new DynamicHashTable(1, 1);
        String value = "a";

        assertEquals(0, hashTable.put(value));
    }

    @Test
    void put_two_el_in_two_length_array() {
        hashTable = new DynamicHashTable(2, 1);

        assertEquals(0, hashTable.put("b"));
        assertEquals(1, hashTable.put("a"));
    }

    @Test
    void put_four_el_in_three_length_array() {
        hashTable = new DynamicHashTable(3, 1);

        assertEquals(2, hashTable.put("b"));
        assertEquals(1, hashTable.put("a"));
        assertEquals(0, hashTable.put("c"));
    }

    @Test
    void find_one_length_two_el() {
        hashTable = new DynamicHashTable(1, 1);
        assertEquals(0, hashTable.put("a"));
        assertEquals(0, hashTable.find("a"));
        assertEquals(-1, hashTable.find("b"));
    }

    @Test
    void find_two_els_with_step_one() {
        hashTable = new DynamicHashTable(2, 1);

        assertEquals(1, hashTable.put("a"));
        assertEquals(0, hashTable.put("b"));

        assertEquals(0, hashTable.find("b"));
        assertEquals(1, hashTable.find("a"));

        assertEquals(-1, hashTable.find("t"));
    }

    @Test
    void find_two_els_with_step_two() {
        hashTable = new DynamicHashTable(2, 2);

        assertEquals(1, hashTable.put("a"));
        assertEquals(0, hashTable.put("b"));

        assertEquals(0, hashTable.find("b"));
        assertEquals(1, hashTable.find("a"));

        assertEquals(-1, hashTable.find("t"));
    }

    @Test
    void find_two_els_with_step_three() {
        hashTable = new DynamicHashTable(2, 2);

        assertEquals(1, hashTable.put("a"));
        assertEquals(0, hashTable.put("b"));

        assertEquals(0, hashTable.find("b"));
        assertEquals(1, hashTable.find("a"));

        assertEquals(-1, hashTable.find("t"));
    }

    @Test
    void find_el_in_full_hashTable() {
        hashTable = new DynamicHashTable(19, 1);

        for (int i = 0; i < 19; i++) {
            assertNotEquals(-1, hashTable.put(String.valueOf('a' + i)));
        }
    }

    @Test
    void find() {
        hashTable = new DynamicHashTable(19, 3);
        String value = "a";

        assertEquals(2, hashTable.put(value));
        assertEquals(3, hashTable.put("b"));
        assertEquals(4, hashTable.put("c"));
        assertEquals(5, hashTable.put("t"));
        assertEquals(8, hashTable.put("t"));
        assertEquals(11, hashTable.put("t"));
        assertEquals(14, hashTable.put("t"));
        assertEquals(17, hashTable.put("t"));
        assertEquals(1, hashTable.put("t"));
        assertEquals(-1, hashTable.put("t"));
        assertEquals(-1, hashTable.find("string"));
        assertEquals(-1, hashTable.find("5"));
    }
}