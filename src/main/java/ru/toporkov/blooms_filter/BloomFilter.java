package ru.toporkov.blooms_filter;

public class BloomFilter {

    protected final int filter_len;
    protected int bits;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        bits = 0;
    }

    public BloomFilter(int f_len, int bits) {
        filter_len = f_len;
        this.bits = bits;
    }

    public int hash1(String str1) {
        int result = 0;

        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            result = result * 17 + code;
            result %= filter_len;
        }

        return result;
    }

    public int hash2(String str1) {
        int result = 0;

        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            result = result * 223 + code;
            result %= filter_len;
        }

        return result;
    }

    public void add(String str1) {
        int strHash1 = hash1(str1);
        int strHash2 = hash2(str1);

        bits |= strHash1;
        bits |= strHash2;

        strHash1 = 0;
        strHash2 = 0;
    }

    public boolean isValue(String str1) {
        int strHash1 = hash1(str1);
        int strHash2 = hash2(str1);

        return (bits & strHash1) >= strHash1 &&
                (bits & strHash2) >= strHash2;
    }

    public int getBits() {
        return bits;
    }

    public int getFilterLen() {
        return filter_len;
    }
}
