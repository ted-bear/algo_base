package ru.toporkov.hash_table;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

public class MultipleHashTable {

    private final int[] simpleNums = {11, 13, 17, 19, 23, 29, 31, 37};
    public String[] slots;
    protected int size;

    public MultipleHashTable(int sz) {
        size = sz;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    private int hashFun(String value, Function<Integer, Boolean> condition) {
        int charSum = value.chars().sum();
        return iterateFunctions(charSum, condition);
    }

    public int seekSlot(String value) {
        int firstIndex = hashFun(value, i -> slots[i] == null);

        if (slots[firstIndex] == null) {
            return firstIndex;
        }

        int index = getIndex(firstIndex);

        while (slots[index] != null) {
            if (index <= firstIndex && index + 1 >= firstIndex) {
                return -1;
            }

            index = getIndex(index);
        }

        return index;
    }

    private int getIndex(int index) {
        return index + 1 < size ?
                index + 1 :
                (index + 1) % size;
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
        int firstIndex = hashFun(value, i -> slots[i] != null);

        if (Objects.equals(slots[firstIndex], value)) {
            return firstIndex;
        }

        int index = getIndex(firstIndex);

        while (!Objects.equals(slots[index], value)) {
            if (index <= firstIndex && index + 1 >= firstIndex) {
                return -1;
            }

            index = getIndex(index);
        }

        return index;
    }

    public long count() {
        return Arrays.stream(slots).filter(Objects::nonNull).count();
    }

    private int iterateFunctions(int input, Function<Integer, Boolean> condition) {
        int index = 0;

        for (Integer sn : simpleNums) {
            index = ((5 * input + 7) % sn) % size;

            if (condition.apply(index)) {
                return index;
            }
        }

        return index;
    }
}
