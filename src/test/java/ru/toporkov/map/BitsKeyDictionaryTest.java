package ru.toporkov.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BitsKeyDictionaryTest {

    BitsKeyDictionary<String> dict;

    @Test
    void put_into_empty() {
        dict = new BitsKeyDictionary<>(3, String.class);
        dict.put("010", "Value");

        assertEquals("Value", dict.get("010"));
    }

    @Test
    void put_get_and_rewrite_full() {
        dict = new BitsKeyDictionary<>(3, String.class);
        dict.put("010", "Value1");
        dict.put("001", "Value2");
        dict.put("100", "Value3");

        assertEquals("Value1", dict.get("010"));
        assertEquals("Value2", dict.get("001"));
        assertEquals("Value3", dict.get("100"));

        dict.put("010", "Value4");
        assertEquals("Value4", dict.get("010"));
    }

    @Test
    void put_get_out_of_bounds() {
        dict = new BitsKeyDictionary<>(3, String.class);

        dict.put("1000", "Value4");
        assertNull(dict.get("1000"));
    }

    @Test
    void get_from_empty() {
        dict = new BitsKeyDictionary<>(3, String.class);

        assertNull(dict.get("100"));
        assertNull(dict.get("010"));
        assertNull(dict.get("001"));
    }

    @Test
    void remove_from_empty() {
        dict = new BitsKeyDictionary<>(3, String.class);

        assertFalse(dict.remove("100"));
        assertFalse(dict.remove("010"));
        assertFalse(dict.remove("001"));
    }

    @Test
    void remove_single_el() {
        dict = new BitsKeyDictionary<>(3, String.class);
        dict.put("001", "value");

        assertTrue(dict.remove("001"));
        assertNull(dict.get("001"));
    }

    @Test
    void remove_from_many_els() {
        dict = new BitsKeyDictionary<>(3, String.class);
        dict.put("010", "Value1");
        dict.put("001", "Value2");
        dict.put("100", "Value3");

        assertEquals("Value1", dict.get("010"));
        assertEquals("Value2", dict.get("001"));
        assertEquals("Value3", dict.get("100"));

        assertTrue(dict.remove("010"));
        assertNull(dict.get("010"));
    }
}