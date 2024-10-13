package ru.toporkov.set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PowerSetTest {

    PowerSet set;

    @Test
    void get_from_empty() {
        set = new PowerSet();

        assertFalse(set.get("a"));
    }

    @Test
    void get_from_single_el() {
        set = new PowerSet();
        set.put("a");

        assertTrue(set.get("a"));
    }

    @Test
    void get_firstElement() {
        set = generateRandomWordsSet();

        assertTrue(set.get("Array"));
    }

    @Test
    void get_repeated() {
        set = new PowerSet();
        set.put("a");
        set.put("a");

        assertEquals(1, set.size());
        assertTrue(set.get("a"));
    }

    @Test
    void get_lastElement() {
        set = generateRandomWordsSet();

        assertTrue(set.get("Work"));
    }

    @Test
    void get_anyElement() {
        set = generateRandomWordsSet();

        assertTrue(set.get("String"));
    }

    @Test
    void get_element_20k_not_exists() {
        set = generate20kElements();

        long start = System.currentTimeMillis();

        assertFalse(set.get("VAL"));

        long stop = System.currentTimeMillis();

        assertTrue((stop - start) < 20);
    }

    @Test
    void get_element_20k_from_start() {
        set = generate20kElements();

        long start = System.currentTimeMillis();

        assertTrue(set.get("el0"));

        long stop = System.currentTimeMillis();

        assertTrue((stop - start) < 20);
    }

    @Test
    void get_element_20k_from_end() {
        set = generate20kElements();

        long start = System.currentTimeMillis();

        assertTrue(set.get("el19997"));

        long stop = System.currentTimeMillis();

        assertTrue((stop - start) < 20);
    }

    @Test
    void get_element_20k_from_middle() {
        set = generate20kElements();

        long start = System.currentTimeMillis();

        assertTrue(set.get("el2345"));

        long stop = System.currentTimeMillis();

        assertTrue((stop - start) < 20);
    }

    @Test
    void get_notExists_firstElement() {
        set = generateRandomWordsSet();

        assertFalse(set.get("Dog"));
    }

    @Test
    void remove_from_empty() {
        set = new PowerSet();

        assertFalse(set.remove("a"));
        assertEquals(0, set.size());
    }

    @Test
    void remove_notExists() {
        set = generateRandomWordsSet();

        assertFalse(set.remove("a"));
        assertEquals(6, set.size());
    }

    @Test
    void remove_existsEl() {
        set = generateRandomWordsSet();

        assertTrue(set.remove("Work"));
        assertEquals(5, set.size());
    }

    @Test
    void remove_element_20k_not_exists() {
        set = generate20kElements();

        long start = System.currentTimeMillis();

        assertFalse(set.remove("VAL"));

        long stop = System.currentTimeMillis();

        assertTrue((stop - start) < 20);
    }

    @Test
    void remove_element_20k_from_start() {
        set = generate20kElements();

        long start = System.currentTimeMillis();

        assertTrue(set.remove("el0"));

        long stop = System.currentTimeMillis();

        assertTrue((stop - start) < 20);
    }

    @Test
    void remove_element_20k_from_end() {
        set = generate20kElements();

        long start = System.currentTimeMillis();

        assertTrue(set.remove("el19997"));

        long stop = System.currentTimeMillis();

        assertTrue((stop - start) < 20);
    }

    @Test
    void remove_element_20k_from_middle() {
        set = generate20kElements();

        long start = System.currentTimeMillis();

        assertTrue(set.remove("el2345"));

        long stop = System.currentTimeMillis();

        assertTrue((stop - start) < 20);
    }

    @Test
    void intersection_empty_sets() {
        set = new PowerSet();
        PowerSet set1 = new PowerSet();

        PowerSet inter = set.intersection(set1);

        assertEquals(0, inter.size());
    }

    @Test
    void intersection_emptySet_and_notEmpty() {
        set = new PowerSet();
        set.put("a");
        PowerSet set1 = new PowerSet();

        PowerSet inter = set.intersection(set1);

        assertEquals(0, inter.size());
    }

    @Test
    void intersection_singleEqEls() {
        set = new PowerSet();
        set.put("a");
        PowerSet set1 = new PowerSet();
        set1.put("a");

        PowerSet inter = set.intersection(set1);

        assertTrue(inter.get("a"));
        assertEquals(1, inter.size());
    }

    @Test
    void intersection_singleNotEqEls() {
        set = new PowerSet();
        set.put("b");
        PowerSet set1 = new PowerSet();
        set1.put("a");

        PowerSet inter = set.intersection(set1);

        assertFalse(inter.get("a"));
        assertFalse(inter.get("b"));
        assertEquals(0, inter.size());
    }

    @Test
    void intersection_emptySet_withNotEmpty() {
        set = new PowerSet();
        PowerSet set1 = new PowerSet();
        set1.put("a");

        PowerSet inter = set.intersection(set1);

        assertFalse(inter.get("a"));
        assertFalse(inter.get("b"));
        assertEquals(0, inter.size());
    }

    @Test
    void intersection_manyEls() {
        set = new PowerSet();
        set.put("a");
        set.put("b");
        set.put("c");
        PowerSet set1 = new PowerSet();
        set1.put("a");
        set1.put("b");
        set1.put("d");

        PowerSet inter = set.intersection(set1);

        assertTrue(inter.get("a"));
        assertTrue(inter.get("b"));
        assertEquals(2, inter.size());
    }

    @Test
    void intersection_one_el() {
        set = new PowerSet();
        set.put("a");
        set.put("d");
        set.put("e");

        PowerSet set1 = new PowerSet();
        set1.put("a");
        set1.put("c");
        set1.put("f");

        PowerSet inter = set.intersection(set1);

        assertTrue(inter.get("a"));
        assertEquals(1, inter.size());
    }

    @Test
    void union_empty_sets() {
        set = new PowerSet();
        PowerSet set1 = new PowerSet();

        PowerSet union = set.union(set1);

        assertEquals(0, union.size());
    }

    @Test
    void union_oneEl_withEmpty() {
        set = new PowerSet();
        set.put("a");
        PowerSet set1 = new PowerSet();

        PowerSet union = set.union(set1);

        assertTrue(union.get("a"));
        assertEquals(1, union.size());
    }

    @Test
    void union_empty_withOneEl() {
        set = new PowerSet();
        PowerSet set1 = new PowerSet();
        set1.put("a");

        PowerSet union = set.union(set1);

        assertTrue(union.get("a"));
        assertEquals(1, union.size());
    }

    @Test
    void union_setsWithEqEls() {
        set = new PowerSet();
        set.put("a");
        PowerSet set1 = new PowerSet();
        set1.put("a");

        PowerSet union = set.union(set1);

        assertTrue(union.get("a"));
        assertEquals(1, union.size());
    }

    @Test
    void union_setsWithNotEqEls() {
        set = new PowerSet();
        set.put("a");
        PowerSet set1 = new PowerSet();
        set1.put("b");

        PowerSet union = set.union(set1);

        assertTrue(union.get("a"));
        assertTrue(union.get("b"));
        assertEquals(2, union.size());
    }

    @Test
    void union_withManyNotEqEls() {
        set = new PowerSet();
        set.put("a");
        set.put("b");
        set.put("c");
        PowerSet set1 = new PowerSet();
        set1.put("f");
        set1.put("d");
        set1.put("e");

        PowerSet union = set.union(set1);

        assertTrue(union.get("a"));
        assertTrue(union.get("b"));
        assertTrue(union.get("c"));
        assertTrue(union.get("f"));
        assertTrue(union.get("d"));
        assertTrue(union.get("e"));
        assertEquals(6, union.size());
    }

    @Test
    void union_withManyEqEls() {
        set = new PowerSet();
        set.put("a");
        set.put("d");
        set.put("e");
        PowerSet set1 = new PowerSet();
        set1.put("f");
        set1.put("d");
        set1.put("e");

        PowerSet union = set.union(set1);

        assertTrue(union.get("a"));
        assertTrue(union.get("f"));
        assertTrue(union.get("d"));
        assertTrue(union.get("e"));
        assertEquals(4, union.size());
    }

    @Test
    void difference() {
        set = new PowerSet();
        set.put("a");
        set.put("d");
        set.put("e");
        PowerSet set1 = new PowerSet();
        set1.put("f");
        set1.put("d");
        set1.put("e");

        PowerSet diff = set.difference(set1);

        assertTrue(diff.get("a"));
        assertEquals(1, diff.size());
    }

    @Test
    void difference_emptySets() {
        set = new PowerSet();
        PowerSet set1 = new PowerSet();

        PowerSet diff = set.difference(set1);

        assertFalse(diff.get("a"));
        assertFalse(diff.get("f"));
        assertEquals(0, diff.size());
    }

    @Test
    void difference_oneEl_andEmpty() {
        set = new PowerSet();
        set.put("a");
        PowerSet set1 = new PowerSet();

        PowerSet diff = set.difference(set1);

        assertTrue(diff.get("a"));
        assertEquals(1, diff.size());
    }

    @Test
    void difference_empty_andOneEl() {
        set = new PowerSet();
        PowerSet set1 = new PowerSet();
        set1.put("f");

        PowerSet diff = set.difference(set1);

        assertFalse(diff.get("a"));
        assertFalse(diff.get("f"));
        assertEquals(0, diff.size());
    }

    @Test
    void difference_notEqOneEl() {
        set = new PowerSet();
        set.put("a");
        PowerSet set1 = new PowerSet();
        set1.put("f");

        PowerSet diff = set.difference(set1);

        assertTrue(diff.get("a"));
        assertEquals(1, diff.size());
    }

    @Test
    void difference_eqOneEl() {
        set = new PowerSet();
        set.put("a");
        PowerSet set1 = new PowerSet();
        set1.put("a");

        PowerSet diff = set.difference(set1);

        assertFalse(diff.get("a"));
        assertFalse(diff.get("f"));
        assertEquals(0, diff.size());
    }

    @Test
    void difference_manyNotEq_els() {
        set = new PowerSet();
        set.put("a");
        set.put("b");
        set.put("c");
        PowerSet set1 = new PowerSet();
        set1.put("f");
        set1.put("e");
        set1.put("d");

        PowerSet diff = set.difference(set1);

        assertTrue(diff.get("a"));
        assertTrue(diff.get("b"));
        assertTrue(diff.get("c"));
        assertEquals(3, diff.size());
    }

    @Test
    void difference_someNotEq_els() {
        set = new PowerSet();
        set.put("a");
        set.put("b");
        set.put("c");
        PowerSet set1 = new PowerSet();
        set1.put("c");
        set1.put("e");
        set1.put("a");

        PowerSet diff = set.difference(set1);

        assertTrue(diff.get("b"));
        assertEquals(1, diff.size());
    }

    @Test
    void difference_allEq_els() {
        set = new PowerSet();
        set.put("a");
        set.put("b");
        set.put("c");
        PowerSet set1 = new PowerSet();
        set1.put("a");
        set1.put("b");
        set1.put("c");

        PowerSet diff = set.difference(set1);

        assertEquals(0, diff.size());
    }

    @Test
    void difference_oneNotEq_els() {
        set = new PowerSet();
        set.put("a");
        set.put("b");
        set.put("c");
        set.put("d");
        PowerSet set1 = new PowerSet();
        set1.put("a");
        set1.put("b");
        set1.put("c");

        PowerSet diff = set.difference(set1);

        assertTrue(diff.get("d"));
        assertEquals(1, diff.size());
    }

    @Test
    void isSubset_emptySets() {
        set = new PowerSet();
        PowerSet set1 = new PowerSet();

        assertTrue(set.isSubset(set1));
    }

    @Test
    void isSubset_singleElAndEmptySet() {
        set = new PowerSet();
        set.put("a");
        PowerSet set1 = new PowerSet();

        assertTrue(set.isSubset(set1));
    }

    @Test
    void isSubset_singleElSets_positive() {
        set = new PowerSet();
        set.put("a");
        PowerSet set1 = new PowerSet();
        set1.put("a");

        assertTrue(set.isSubset(set1));
    }

    @Test
    void isSubset_singleElSets_negative() {
        set = new PowerSet();
        set.put("a");
        PowerSet set1 = new PowerSet();
        set1.put("d");

        assertFalse(set.isSubset(set1));
    }

    @Test
    void isSubset_withLessEls() {
        set = new PowerSet();
        set.put("a");
        set.put("b");
        set.put("c");
        set.put("d");
        PowerSet set1 = new PowerSet();
        set1.put("a");
        set1.put("b");
        set1.put("c");

        assertTrue(set.isSubset(set1));
    }

    @Test
    void isSubset_withMoreEls() {
        set = new PowerSet();
        set.put("a");
        set.put("b");
        set.put("c");
        set.put("d");
        PowerSet set1 = new PowerSet();
        set1.put("a");
        set1.put("e");
        set1.put("c");

        assertFalse(set1.isSubset(set));
    }

    @Test
    void testEquals_emptySets() {
        set = new PowerSet();
        PowerSet set1 = new PowerSet();

        assertTrue(set.equals(set1));
    }

    @Test
    void testEquals_singleEl() {
        set = new PowerSet();
        set.put("a");
        PowerSet set1 = new PowerSet();

        assertFalse(set.equals(set1));
    }

    @Test
    void testEquals_setsWithSingleEl() {
        set = new PowerSet();
        set.put("a");
        PowerSet set1 = new PowerSet();
        set1.put("a");

        assertTrue(set.equals(set1));
    }

    private PowerSet generateRandomWordsSet() {
        PowerSet newSet = new PowerSet();
        newSet.put("Array");
        newSet.put("Demon");
        newSet.put("String");
        newSet.put("List");
        newSet.put("Work");
        newSet.put("Family");

        return newSet;
    }

    private PowerSet generate20kElements() {
        PowerSet newSet = new PowerSet();

        for (int i = 0; i < 20_000; i++) {
            newSet.put("el" + i);
        }

        return newSet;
    }

    @Test
    void cartesianProduction_empty_sets() {
        set = new PowerSet();
        var prodSet = new PowerSet();

        var result = set.cartesianProduction(prodSet);

        assertEquals(0, result.size());
    }

    @Test
    void cartesianProduction_single_and_empty_sets() {
        set = new PowerSet();
        set.put("string");
        var prodSet = new PowerSet();

        var result = set.cartesianProduction(prodSet);

        assertEquals(0, result.size());
    }

    @Test
    void cartesianProduction_empty_and_single_sets() {
        set = new PowerSet();
        var prodSet = new PowerSet();
        prodSet.put("string");

        var result = set.cartesianProduction(prodSet);

        assertEquals(0, result.size());
    }

    @Test
    void cartesianProduction_singles_sets() {
        set = new PowerSet();
        set.put("string1");
        var prodSet = new PowerSet();
        prodSet.put("string2");

        var result = set.cartesianProduction(prodSet);

        assertTrue(result.get("string1:string2"));
        assertTrue(result.get("string2:string1"));
        assertEquals(2, result.size());
    }

    @Test
    void cartesianProduction_one_with_many_sets() {
        set = new PowerSet();
        set.put("1");
        set.put("2");
        set.put("3");
        var prodSet = new PowerSet();
        prodSet.put("3");

        var result = set.cartesianProduction(prodSet);

        assertTrue(result.get("1:3"));
        assertTrue(result.get("3:1"));
        assertTrue(result.get("2:3"));
        assertTrue(result.get("3:2"));
        assertTrue(result.get("3:3"));
        assertEquals(5, result.size());
    }
}