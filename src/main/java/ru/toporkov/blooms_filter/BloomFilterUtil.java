package ru.toporkov.blooms_filter;

public class BloomFilterUtil {

    public BloomFilter mergeFilters(BloomFilter[] filters) {

        if (filters.length == 0) return new BloomFilter(0);

        int len = filters[0].getFilterLen();
        int bits = 0;

        for (BloomFilter filter : filters) {
            bits |= filter.getBits();
        }

        return new BloomFilter(len, bits);
    }
}
