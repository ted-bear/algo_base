package ru.toporkov.map;

import java.lang.reflect.Array;

public class BitsKeyDictionary<T> {

    private int bites;
    private T[] values;
    private int size;

    public BitsKeyDictionary(int sz, Class clz) {
        bites = 0;
        size = sz;
        values = (T[]) Array.newInstance(clz, size);
        for (int i = 0; i < size; i++) values[i] = null;
    }

    public void put(String key, T value) {
        int position = getBitPosition(key);

        if (position >= (1 << size)) {
            return;
        }

        bites |= 1 << position;
        int index = key.indexOf('1');
        values[index] = value;
    }

    public T get(String key) {
        int position = getBitPosition(key);

        if (position >= (1 << size)) {
            return null;
        }

        if ((bites & (1 << position)) != 0) {
            int index = key.indexOf('1');
            return values[index];
        }

        return null;
    }

    public boolean remove(String key) {
        int position = getBitPosition(key);

        if (position >= (1 << size)) {
            return false;
        }

        if ((bites & (1 << position)) == 0) {
            return false;
        }

        bites &= (1 << position);
        int index = key.indexOf('1');
        values[index] = null;
        return true;
    }

    private int getBitPosition(String key) {
        return Integer.valueOf(key, 2);
    }
}
