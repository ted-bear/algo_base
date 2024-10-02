package ru.toporkov.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NativeDictionaryTest {

    NativeDictionary<Integer> dictionary;

    @Test
    void isKey_empty_dict() {
        dictionary = new NativeDictionary<>(19, Integer.class);

        assertFalse(dictionary.isKey("string"));
    }

    @Test
    void isKey_oneEl_dict_positive() {
        dictionary = createDictionary(1, 1);

        assertTrue(dictionary.isKey("key0"));
    }

    @Test
    void isKey_oneEl_dict_negative() {
        dictionary = createDictionary(1, 1);

        assertFalse(dictionary.isKey("key1"));
    }

    @Test
    void isKey_single_eq_dict() {
        dictionary = new NativeDictionary<>(19, Integer.class);
        dictionary.put("string", 12);

        assertTrue(dictionary.isKey("string"));
    }

    @Test
    void isKey_single_notEq_dict() {
        dictionary = new NativeDictionary<>(19, Integer.class);
        dictionary.put("string", 12);

        assertFalse(dictionary.isKey("s"));
    }

    @Test
    void put_into_empty_dict() {
        dictionary = createDictionary(19, 1);

        assertTrue(dictionary.isKey("key0"));
    }

    @Test
    void put_into_empty_oneLen_dict() {
        dictionary = createDictionary(1, 1);

        assertTrue(dictionary.isKey("key0"));
    }

    @Test
    void put() {
        dictionary = createDictionary(31, 19);

        assertTrue(dictionary.isKey("key18"));
    }

    @Test
    void get_from_empty() {
        dictionary = createDictionary(31, 0);
        assertNull(dictionary.get("key1"));
    }

    @Test
    void get_from_one_len() {
        dictionary = createDictionary(31, 1);
        assertEquals(0, dictionary.get("key0"));
    }

    @Test
    void get_from_one_len_not_eq_el() {
        dictionary = createDictionary(31, 1);
        assertNull(dictionary.get("key1"));
    }

    @Test
    void get_from_manyEl_notNull() {
        dictionary = createDictionary(31, 19);
        assertEquals(18, dictionary.get("key18"));
    }

    NativeDictionary<Integer> createDictionary(int size, int countElements) {
        NativeDictionary<Integer> dict = new NativeDictionary<>(size, Integer.class);

        for (int i = 0; i < countElements; i++) {
            dict.put("key" + i, i);
        }

        return dict;
    }
}