package ru.toporkov.blooms_filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BloomFilterWithRemoveTest {

    @Test
    void remove_one_element_from_single_el() {
        BloomFilterWithRemove filter = new BloomFilterWithRemove(19);
        filter.add("str");

        filter.remove("str");

        assertEquals(0, filter.getBits());
    }

    @Test
    void remove_one_element_from_pair() {
        BloomFilterWithRemove filter = new BloomFilterWithRemove(137);
        filter.add("str");
        filter.add("int");

        filter.remove("str");

        assertNotEquals(0, filter.getBits());
    }

    @Test
    void remove_one_element_single_char_el() {
        BloomFilterWithRemove filter = new BloomFilterWithRemove(111);
        filter.add("a");
        filter.remove("@");

        assertNotEquals(0, filter.getBits());
        assertFalse(filter.isValue("a"));
    }
}