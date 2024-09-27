package ru.toporkov.hash_table;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashTableTest {

    HashTable hashTable;

    @Test
    void put_in_empty() {
        hashTable = new HashTable(19, 3);
        String value = "a";

        assertEquals(2, hashTable.put(value));
    }

    @Test
    void put_pair_element_empty() {
        hashTable = new HashTable(19, 3);
        String value = "a";

        assertEquals(2, hashTable.put(value));
        assertEquals(3, hashTable.put("b"));
        assertEquals(4, hashTable.put("c"));
        assertEquals(5, hashTable.put("t"));
    }

    @Test
    void put_two_el_in_one_length_array() {
        hashTable = new HashTable(1, 1);
        String value = "a";

        assertEquals(0, hashTable.put(value));
        assertEquals(-1, hashTable.put(value));
    }

    @Test
    void put_two_el_in_two_length_array() {
        hashTable = new HashTable(2, 1);

        assertEquals(0, hashTable.put("b"));
        assertEquals(1, hashTable.put("a"));
        assertEquals(-1, hashTable.put("b"));
        assertEquals(-1, hashTable.put("a"));
    }

    @Test
    void put_four_el_in_three_length_array() {
        hashTable = new HashTable(3, 1);

        assertEquals(2, hashTable.put("b"));
        assertEquals(1, hashTable.put("a"));
        assertEquals(0, hashTable.put("c"));
        assertEquals(-1, hashTable.put("b"));
        assertEquals(-1, hashTable.put("a"));
    }

    @Test
    void find() {
        hashTable = new HashTable(19, 3);
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
    }
}