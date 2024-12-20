package ru.toporkov.map;

import java.lang.reflect.Array;
import java.util.Objects;

public class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        int charSum = Math.abs(key.hashCode());
        return charSum % size;
    }

    public boolean isKey(String key) {
        int firstIndex = hashFun(key);

        if (Objects.equals(key, slots[firstIndex])) {
            return true;
        }

        int index = getIndex(firstIndex);

        while (index != firstIndex) {
            if (Objects.equals(key, slots[index])) {
                return true;
            }
            index = getIndex(index);
        }

        return false;
    }

    public void put(String key, T value) {
        int index = seekSlot(key);
        slots[index] = key;
        values[index] = value;
    }

    public T get(String key) {
        int firstIndex = hashFun(key);

        if (Objects.equals(slots[firstIndex], key)) {
            return values[firstIndex];
        }

        int index = getIndex(firstIndex);

        while (index != firstIndex) {
            if (Objects.equals(slots[index], key)) return values[index];
            index = getIndex(index);
        }

        return null;
    }

    private int seekSlot(final String key) {
        int firstIndex = hashFun(key);

        if (slots[firstIndex] == null) {
            return firstIndex;
        }

        int index = getIndex(firstIndex);

        while (index != firstIndex) {
            if (slots[index] == null) {
                return index;
            }
            index = getIndex(index);
        }

        return index;
    }

    private int getIndex(int index) {
        return index + 1 < size ?
                index + 1 : 0;
    }
}
