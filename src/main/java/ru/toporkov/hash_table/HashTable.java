package ru.toporkov.hash_table;

import java.util.Objects;

public class HashTable {
    public String[] slots;
    private int size;
    private int step;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        int charSum = value.chars().sum();
        return charSum % size;
    }

    public int seekSlot(String value) {
        int firstIndex = hashFun(value);

        if (slots[firstIndex] == null) {
            return firstIndex;
        }

        int index = getIndex(firstIndex);

        while (slots[index] != null) {
            if (index <= firstIndex && index + step >= firstIndex) {
                return -1;
            }

            index = getIndex(index);
        }

        return index;
    }

    private int getIndex(int index) {
        return index + step < size ?
                index + step :
                (index + step) % size;
    }

    public int put(String value) {
        int slotIndex = seekSlot(value);

        if (slotIndex == -1) {
            return -1;
        }

        slots[slotIndex] = value;

        return slotIndex;
    }

    public int find(String value) {
        int firstIndex = hashFun(value);

        if (Objects.equals(slots[firstIndex], value)) {
            return firstIndex;
        }

        int index = getIndex(firstIndex);

        while (!Objects.equals(slots[index], value)) {
            if (index <= firstIndex && index + step >= firstIndex) {
                return -1;
            }

            index = getIndex(index);
        }

        return index;
    }
}
