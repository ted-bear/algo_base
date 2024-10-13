package ru.toporkov.set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BagTest {

    Bag<String> bag;

    @Test
    void put_single_el_into_empty_bag() {
        bag = new Bag<>();
        bag.put("string");

        assertEquals(1, bag.storage.size());
        assertEquals(1, bag.getElementFrequency("string"));
    }

    @Test
    void put_two_eq_els() {
        bag = new Bag<>();
        bag.put("string");
        bag.put("string");

        assertEquals(2, bag.storage.size());
        assertEquals(2, bag.getElementFrequency("string"));
    }

    @Test
    void put_two_diff_els() {
        bag = new Bag<>();
        bag.put("string");
        bag.put("number");

        assertEquals(2, bag.storage.size());
        assertEquals(1, bag.getElementFrequency("string"));
        assertEquals(1, bag.getElementFrequency("number"));
    }

    @Test
    void remove_from_empty() {
        bag = new Bag<>();
        assertFalse(bag.remove("string"));
    }

    @Test
    void remove_one_el() {
        bag = new Bag<>();
        bag.put("string");

        assertEquals(1, bag.getElementFrequency("string"));

        assertTrue(bag.remove("string"));
        assertEquals(0, bag.getElementFrequency("string"));
    }
}