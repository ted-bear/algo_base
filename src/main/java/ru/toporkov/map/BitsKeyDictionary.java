package ru.toporkov.map;

import java.lang.reflect.Array;

public class BitsKeyDictionary<T> {

    private final int[] slots;
    private final T[] values;
    private final int size;

    public BitsKeyDictionary(int sz, Class clz) {
        size = sz;
        slots = new int[sz];
        values = (T[]) Array.newInstance(clz, size);
        for (int i = 0; i < size; i++) values[i] = null;
    }

    public void put(String key, T value) {
        int position = getBitPosition(key);

        if (position >= (1 << size)) {
            return;
        }

        int index = key.indexOf('1');
        slots[index] = 1;
        values[index] = value;
    }

    public T get(String key) {
        int position = getBitPosition(key);

        if (position >= (1 << size)) {
            return null;
        }

        int index = key.indexOf('1');
        return values[index];
    }

    public boolean remove(String key) {
        int position = getBitPosition(key);

        if (position >= (1 << size)) {
            return false;
        }

        int index = key.indexOf('1');

        if (slots[index] == 0) {
            return false;
        }

        values[index] = null;
        return true;
    }

    private int getBitPosition(String key) {
        return Integer.valueOf(key, 2);
    }
}
