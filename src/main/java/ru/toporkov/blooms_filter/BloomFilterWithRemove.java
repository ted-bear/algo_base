package ru.toporkov.blooms_filter;

public class BloomFilterWithRemove extends BloomFilter {

    public BloomFilterWithRemove(int f_len) {
        super(f_len);
    }

    public BloomFilterWithRemove(int f_len, int bits) {
        super(f_len, bits);
    }

    public void remove(String element) {
        int hash1 = hash1(element);
        int hash2 = hash2(element);

        bits &= ~hash1;
        bits &= ~hash2;
    }
}
