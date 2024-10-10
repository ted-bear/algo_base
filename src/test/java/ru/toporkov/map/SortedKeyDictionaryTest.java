package ru.toporkov.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    void get_from_empty() {
        dict = new SortedKeyDictionary<>(19, String.class);

        assertNull(dict.get("Af"));
    }
}