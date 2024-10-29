package ru.toporkov.hash_table;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Random;

public class HashTable {
    public String[] slots;
    protected int size;
    protected int step;
    private final String salt;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        salt = generateRandomString(7);
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        int charSum = value.chars().sum();
        return charSum % size;
    }

    public int seekSlot(String value) {
        int firstIndexToInsert = hashFun(value);

        if (slots[firstIndexToInsert] == null) {
            return firstIndexToInsert;
        }

        int nextIndexToInsert = getIndex(firstIndexToInsert);

        while (slots[nextIndexToInsert] != null) {
            if (
                    nextIndexToInsert <= firstIndexToInsert &&
                            nextIndexToInsert + step >= firstIndexToInsert
            ) {
                return -1;
            }

            nextIndexToInsert = getIndex(nextIndexToInsert);
        }

        return nextIndexToInsert;
    }

    private int getIndex(int index) {
        return index + step < size ?
                index + step :
                (index + step) % size;
    }

    public int put(String value) {
        String valueWithSalt = salt + value;
        int slotIndex = seekSlot(valueWithSalt);

        if (slotIndex == -1) {
            return -1;
        }

        slots[slotIndex] = value;

        return slotIndex;
    }

    public int find(String value) {
        String valueWithSalt = salt + value;
        int firstIndex = hashFun(valueWithSalt);

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

    private String generateRandomString(int length) {
        byte[] bytes = new byte[length];
        new Random().nextBytes(bytes);

        return new String(bytes, StandardCharsets.UTF_8);
    }
}
