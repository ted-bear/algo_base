package ru.toporkov.set;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.binarySearch;

public class PowerSet {

    final List<String> storage;

    public PowerSet() {
        storage = new ArrayList<>();
    }

    public int size() {
        return storage.size();
    }

    public void put(String value) {
        int index = binarySearch(storage, value);

        if (index < 0) {
            int insertionPoint = index * -1 - 1;
            storage.add(insertionPoint, value);
        }
    }

    public boolean get(String value) {
        int index = binarySearch(storage, value);
        return index >= 0;
    }

    public boolean remove(String value) {
        int index = binarySearch(storage, value);

        if (index >= 0) {
            storage.remove(value);
            return true;
        } else {
            return false;
        }
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet intersectionSet = new PowerSet();

        for (String el : set2.storage) {
            if (get(el)) {
                intersectionSet.put(el);
            }
        }

        return intersectionSet;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet unionSet = new PowerSet();

        for (String el : storage) {
            unionSet.put(el);
        }

        for (String el : set2.storage) {
            unionSet.put(el);
        }

        return unionSet;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet diffSet = new PowerSet();

        for (String el : set2.storage) {
            if (!get(el)) {
                diffSet.put(el);
            }
        }

        return diffSet;
    }

    public boolean isSubset(PowerSet set2) {

        for (String el : set2.storage) {
            if (!get(el)) {
                return false;
            }
        }

        return true;
    }

    public boolean equals(PowerSet set2) {
        return storage.equals(set2.storage);
    }
}
