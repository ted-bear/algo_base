package ru.toporkov.order_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static ru.toporkov.order_list.OrderedListUtil.mergeList;

class OrderedListUtilTest {

    private static void assertEqualsArrayAndLinkedList(
            OrderedList<Integer> merged,
            int[] x
    ) {
        Node<Integer> cur = merged.head;

        for (Integer i : x) {
            assertEquals(i, cur.value);
            cur = cur.next;
        }
    }

    @Test
    void merge_empty_lists() {
        OrderedList<Integer> first = new OrderedList<>(true);
        OrderedList<Integer> second = new OrderedList<>(true);

        var merged = mergeList(first, second);

        assertNull(merged.head);
        assertNull(merged.tail);
    }

    @Test
    void merge_asc_oneEmptyAndOneSingleEl_lists() {
        OrderedList<Integer> first = new OrderedList<>(true);
        first.add(1);
        OrderedList<Integer> second = new OrderedList<>(true);

        var merged = mergeList(first, second);
        assertEqualsArrayAndLinkedList(merged, new int[]{1});
    }

    @Test
    void merge_diff_oneEmptyAndOneSingleEl_lists() {
        OrderedList<Integer> first = new OrderedList<>(false);
        first.add(1);
        OrderedList<Integer> second = new OrderedList<>(false);

        var merged = mergeList(first, second);
        assertEqualsArrayAndLinkedList(merged, new int[]{1});
    }

    @Test
    void merge_desc_oneEmptyAndOneSingleEl_lists() {
        OrderedList<Integer> first = new OrderedList<>(false);
        first.add(1);
        OrderedList<Integer> second = new OrderedList<>(false);

        var merged = mergeList(first, second);
        assertEqualsArrayAndLinkedList(merged, new int[]{1});
    }

    @Test
    void merge_twoAsc_singleEl_lists() {
        OrderedList<Integer> first = new OrderedList<>(true);
        first.add(1);
        OrderedList<Integer> second = new OrderedList<>(true);
        second.add(2);

        var merged = mergeList(first, second);
        assertEqualsArrayAndLinkedList(merged, new int[]{1, 2});
    }

    @Test
    void merge_diff_singleEl_lists() {
        OrderedList<Integer> first = new OrderedList<>(true);
        first.add(1);
        OrderedList<Integer> second = new OrderedList<>(false);
        second.add(2);

        var merged = mergeList(first, second);
        assertEqualsArrayAndLinkedList(merged, new int[]{1, 2});
    }

    @Test
    void merge_desc_singleEl_lists() {
        OrderedList<Integer> first = new OrderedList<>(false);
        first.add(1);
        OrderedList<Integer> second = new OrderedList<>(false);
        second.add(2);

        var merged = mergeList(first, second);
        assertEqualsArrayAndLinkedList(merged, new int[]{1, 2});
    }

    @Test
    void merge_twoAsc_eqLen_lists() {
        OrderedList<Integer> first = new OrderedList<>(true);
        first.add(1);
        first.add(4);
        first.add(7);
        first.add(8);

        OrderedList<Integer> second = new OrderedList<>(true);
        second.add(2);
        second.add(3);
        second.add(9);
        second.add(10);

        OrderedList<Integer> merged = mergeList(first, second);

        assertEqualsArrayAndLinkedList(merged, new int[]{1, 2, 3, 4, 7, 8, 9, 10});
    }

    @Test
    void merge_diff_eqLen_lists() {
        OrderedList<Integer> first = new OrderedList<>(true);
        first.add(1);
        first.add(4);
        first.add(7);
        first.add(8);

        OrderedList<Integer> second = new OrderedList<>(false);
        second.add(2);
        second.add(3);
        second.add(9);
        second.add(10);

        OrderedList<Integer> merged = mergeList(first, second);

        assertEqualsArrayAndLinkedList(merged, new int[]{1, 2, 3, 4, 7, 8, 9, 10});
    }

    @Test
    void merge_desc_eqLen_lists() {
        OrderedList<Integer> first = new OrderedList<>(false);
        first.add(1);
        first.add(4);
        first.add(7);
        first.add(8);

        OrderedList<Integer> second = new OrderedList<>(false);
        second.add(2);
        second.add(3);
        second.add(9);
        second.add(10);

        OrderedList<Integer> merged = mergeList(first, second);

        assertEqualsArrayAndLinkedList(merged, new int[]{1, 2, 3, 4, 7, 8, 9, 10});
    }

    @Test
    void merge_twoAsc_diffLen_lists() {
        OrderedList<Integer> first = new OrderedList<>(true);
        first.add(1);
        first.add(4);
        first.add(7);
        first.add(8);

        OrderedList<Integer> second = new OrderedList<>(true);
        second.add(2);
        second.add(3);
        second.add(9);

        OrderedList<Integer> merged = mergeList(first, second);
        assertEqualsArrayAndLinkedList(merged, new int[]{1, 2, 3, 4, 7, 8, 9});
    }

    @Test
    void merge_twoDiff__diffLen__lists() {
        OrderedList<Integer> first = new OrderedList<>(true);
        first.add(1);
        first.add(4);
        first.add(7);
        first.add(8);

        OrderedList<Integer> second = new OrderedList<>(false);
        second.add(2);
        second.add(3);
        second.add(9);

        OrderedList<Integer> merged = mergeList(first, second);
        assertEqualsArrayAndLinkedList(merged, new int[]{1, 2, 3, 4, 7, 8, 9});
    }

    @Test
    void merge_two_desc_many_els_lists() {
        OrderedList<Integer> first = new OrderedList<>(false);
        first.add(1);
        first.add(4);
        first.add(7);
        first.add(8);

        OrderedList<Integer> second = new OrderedList<>(false);
        second.add(2);
        second.add(3);
        second.add(9);

        OrderedList<Integer> merged = mergeList(first, second);
        assertEqualsArrayAndLinkedList(merged, new int[]{1, 2, 3, 4, 7, 8, 9});
    }
}