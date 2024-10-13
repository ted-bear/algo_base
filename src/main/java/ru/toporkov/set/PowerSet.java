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

        for (String el : storage) {
            if (!set2.get(el)) {
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

    /*
     * 1 2
     * 3 4
     * 13 31 14 41 23 32 24 42
     * */

    public PowerSet cartesianProduction(PowerSet set) {
        PowerSet result = new PowerSet();

        if (set.size() == 0) {
            System.err.println("Second set has zero size");
            return new PowerSet();
        }

        if (size() == 0) {
            System.err.println("First set has zero size");
            return new PowerSet();
        }

        for (String el1 : storage) {
            for (String el2 : set.storage) {
                result.put(el1 + ":" + el2);
                result.put(el2 + ":" + el1);
            }
        }

        return result;
    }

    public boolean equals(PowerSet set2) {
        return storage.equals(set2.storage);
    }
}
