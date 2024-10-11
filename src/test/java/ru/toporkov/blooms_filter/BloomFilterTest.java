package ru.toporkov.blooms_filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BloomFilterTest {

    BloomFilter filter;

    @Test
    void add_into_empty_filter() {
        filter = new BloomFilter(32);
        String testingValue = "hash1";

        filter.add(testingValue);

        assertTrue(filter.isValue(testingValue));
    }

    @Test
    void add_into_empty_ten_rows() {
        filter = new BloomFilter(32);
        String[] testingVals = {
                "0123456789",
                "9012345678",
                "8901234567",
                "7890123456",
                "6789012345",
                "5678901234",
                "4567890123",
                "3456789012",
                "2345678901",
                "1234567890",
        };

        for (var value : testingVals) {
            filter.add(value);
        }

        for (var value : testingVals) {
            assertTrue(filter.isValue(value));
        }
    }

    @Test
    void isValue_empty() {
        filter = new BloomFilter(32);

        assertFalse(filter.isValue("4567890123"));
    }
}