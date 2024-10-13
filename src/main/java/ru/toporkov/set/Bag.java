package ru.toporkov.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bag<T extends Comparable<T>> {

    final List<T> storage;
    final Map<T, Integer> elementFreq;

    public Bag() {
        storage = new ArrayList<>();
        elementFreq = new HashMap<>();
    }

    public void put(T element) {
        elementFreq.putIfAbsent(element, 0);
        elementFreq.put(element, elementFreq.get(element) + 1);

        int insertIndex = Collections.binarySearch(storage, element);
        insertIndex = (insertIndex < 0) ? insertIndex * -1 - 1 : insertIndex;
        storage.add(insertIndex, element);
    }

    public int getElementFrequency(T element) {
        Integer frequency = elementFreq.get(element);
        return frequency == null ? 0 : frequency;
    }

    public boolean remove(T element) {
        Integer frequency = elementFreq.get(element);

        if (frequency == null) {
            return false;
        }

        elementFreq.put(element, frequency - 1);
        storage.remove(element);
        return true;
    }

    public Set<Map.Entry<T, Integer>> getElementsFrequencies() {
        return elementFreq.entrySet();
    }
}
