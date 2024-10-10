package ru.toporkov.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortedKeyDictionaryTest {

    SortedKeyDictionary<String> dict;

    @Test
    void put_single_element() {
        dict = new SortedKeyDictionary<>(19, String.class);
        dict.put("Value", "String");

        assertEquals("String", dict.get("Value"));
    }

    @Test
    void put_pair_of_elements() {
        dict = new SortedKeyDictionary<>(19, String.class);
        dict.put("Value", "String");
        dict.put("Assertion", "Integer");

        assertEquals("String", dict.get("Value"));
        assertEquals("Integer", dict.get("Assertion"));
    }

    @Test
    void put_many_elements() {
        dict = new SortedKeyDictionary<>(19, String.class);
        for (int i = 0; i < 19; i++) {
            dict.put("key" + i, "value" + i);
        }

        for (int i = 0; i < 19; i++) {
            assertEquals("value" + i, dict.get("key" + i));
        }

        dict.put("String", "value");
        assertNull(dict.get("String"));
    }

    @Test
    void put_element_in_head() {
        dict = new SortedKeyDictionary<>(19, String.class);
        for (int i = 1; i < 19; i++) {
            dict.put("key" + i, "value" + i);
        }

        for (int i = 1; i < 19; i++) {
            assertEquals("value" + i, dict.get("key" + i));
        }

        dict.put("key0", "value0");
        assertEquals("value0", dict.get("key0"));
    }

    @Test
    void put_element_in_middle() {
        dict = new SortedKeyDictionary<>(19, String.class);
        for (int i = 0; i < 19; i++) {
            if (i != 8) dict.put("key" + i, "value" + i);
        }

        dict.put("key8", "value8");

        for (int i = 0; i < 19; i++) {
            assertEquals("value" + i, dict.get("key" + i));
        }
    }

    @Test
    void get_from_empty() {
        dict = new SortedKeyDictionary<>(19, String.class);

        assertNull(dict.get("Af"));
    }

    @Test
    void get_not_exists_element() {
        dict = new SortedKeyDictionary<>(19, String.class);
        for (int i = 0; i < 19; i++) {
            dict.put("key" + i, "value" + i);
        }

        for (int i = 0; i < 19; i++) {
            assertEquals("value" + i, dict.get("key" + i));
        }

        assertNull(dict.get("key"));
    }

    @Test
    void remove_from_empty() {
        dict = new SortedKeyDictionary<>(1, String.class);

        assertFalse(dict.remove("key"));
    }

    @Test
    void remove_single_el() {
        dict = new SortedKeyDictionary<>(1, String.class);
        dict.put("key", "value");

        assertTrue(dict.remove("key"));
        assertNull(dict.get("key"));
    }

    @Test
    void remove_single_el_from_twoLength() {
        dict = new SortedKeyDictionary<>(2, String.class);
        dict.put("key", "value");
        dict.put("key1", "value1");

        assertTrue(dict.remove("key"));
        assertNull(dict.get("key"));
        assertEquals("value1", dict.get("key1"));
    }

    @Test
    void remove_first_element() {
        dict = new SortedKeyDictionary<>(19, String.class);

        for (int i = 0; i < 19; i++) {
            dict.put("key" + i, "value" + i);
        }

        assertTrue(dict.remove("key0"));
        assertNull(dict.get("key0"));
        assertEquals("value1", dict.get("key1"));
    }

    @Test
    void remove_last_element() {
        dict = new SortedKeyDictionary<>(19, String.class);

        for (int i = 0; i < 19; i++) {
            dict.put("key" + i, "value" + i);
        }

        assertTrue(dict.remove("key9"));
        assertNull(dict.get("key9"));
    }
}