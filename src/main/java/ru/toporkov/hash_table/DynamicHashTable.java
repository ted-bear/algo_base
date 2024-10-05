package ru.toporkov.hash_table;

import java.util.Arrays;
import java.util.Objects;

public class DynamicHashTable extends HashTable {

    public DynamicHashTable(int sz, int stp) {
        super(sz, stp);
    }

    @Override
    public int put(String value) {
        checkIfNeedToExpand();

        int slotIndex = seekSlot(value);

        if (slotIndex == -1) {
            return -1;
        }

        slots[slotIndex] = value;

        return slotIndex;
    }

    private void checkIfNeedToExpand() {
        long count = Arrays.stream(slots).filter(Objects::nonNull).count();
        if (4 * count > 3L * size) {
            expand();
        }
    }

    private void expand() {
        int doubleSize = size * 2;
        size = doubleSize;
        String[] newSlots = new String[doubleSize];
        String[] oldSlots = slots;
        slots = newSlots;

        for (String str : oldSlots) {
            if (str != null) {
                put(str);
            }
        }
    }
}
