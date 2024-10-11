package ru.toporkov.blooms_filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BloomFilterTest {

    BloomFilter filter;

    @Test
    void add_into_empty_filter() {
        filter = new BloomFilter(32);
        String testinValue = "hash1";

        filter.add(testinValue);

        assertTrue(filter.isValue(testinValue));
    }

    @Test
    void isValue() {

    }
}