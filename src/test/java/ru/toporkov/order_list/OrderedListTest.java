package ru.toporkov.order_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderedListTest {

    OrderedList<Integer> list;

    @Test
    void find_asc_head_el() {
        list = new OrderedList<>(true);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);

        assertEquals(7, list.find(7).value);
    }

    @Test
    void find_asc_last_el() {
        list = new OrderedList<>(true);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);

        assertEquals(16, list.find(16).value);
    }

    @Test
    void find_asc_middle_el() {
        list = new OrderedList<>(true);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);

        assertEquals(8, list.find(8).value);
    }

    @Test
    void find_asc_not_existing_el() {
        list = new OrderedList<>(true);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);

        assertNull(list.find(9));
    }

    @Test
    void find_desc_head_el() {
        list = new OrderedList<>(false);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);

        assertEquals(7, list.find(7).value);
    }

    @Test
    void find_desc_last_el() {
        list = new OrderedList<>(false);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);

        assertEquals(16, list.find(16).value);
    }

    @Test
    void find_desc_middle_el() {
        list = new OrderedList<>(false);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);

        assertEquals(8, list.find(8).value);
    }

    @Test
    void find_desc_not_existing_el() {
        list = new OrderedList<>(false);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);

        assertNull(list.find(9));
    }

    @Test
    void add_one_el() {
        list = new OrderedList<>(false);
        list.add(19);

        assertEquals(19, list.tail.value);
    }

    @Test
    void add_in_asc_order() {
        list = new OrderedList<>(true);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);

        assertEquals(7, list.head.value);
        assertEquals(8, list.head.next.value);
        assertEquals(12, list.head.next.next.value);
        assertEquals(16, list.tail.value);
    }

    @Test
    void add_in_desc_order() {
        list = new OrderedList<>(false);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);

        assertEquals(16, list.head.value);
        assertEquals(12, list.head.next.value);
        assertEquals(8, list.head.next.next.value);
        assertEquals(7, list.tail.value);
    }

    @Test
    void delete_single_element() {
        list = new OrderedList<>(false);
        list.add(7);

        list.delete(7);

        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void delete_first_min_in_desc_list() {
        list = new OrderedList<>(false);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);

        list.delete(7);

        assertEquals(8, list.tail.value);
        assertNull(list.head.prev);
    }

    @Test
    void delete_first_min_in_asc_list() {
        list = new OrderedList<>(true);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);

        list.delete(7);

        assertEquals(8, list.head.value);
        assertNull(list.head.prev);
    }

    @Test
    void delete_first_max_in_asc_list() {
        list = new OrderedList<>(true);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);

        list.delete(16);

        assertEquals(12, list.tail.value);
        assertNull(list.tail.next);
    }

    @Test
    void delete_first_max_in_desc_list() {
        list = new OrderedList<>(false);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);
        assertEquals(4, list.count());

        list.delete(16);

        assertEquals(12, list.head.value);
        assertEquals(3, list.count());
        assertNull(list.head.prev);
    }

    @Test
    void delete_all_in_desc_list() {
        list = new OrderedList<>(false);
        list.add(7);
        list.add(12);
        list.add(16);
        list.add(8);
        assertEquals(4, list.count());

        list.delete(16);

        assertEquals(12, list.head.value);
        assertEquals(3, list.count());
        assertNull(list.head.prev);

        list.delete(12);

        assertEquals(8, list.head.value);
        assertEquals(2, list.count());
        assertNull(list.head.prev);

        list.delete(8);

        assertEquals(7, list.head.value);
        assertEquals(7, list.tail.value);
        assertEquals(1, list.count());
        assertNull(list.head.prev);

        list.delete(7);
        assertNull(list.head);
        assertNull(list.tail);
        assertEquals(0, list.count());
    }

    @Test
    void removeDuplicates_from_empty() {
        list = new OrderedList<>(true);

        list.removeDuplicates();

        assertEquals(0, list.count());
        assertNull(list.head);
    }

    @Test
    void removeDuplicates_from_asc_single_el_list() {
        list = new OrderedList<>(true);
        list.add(2);
        list.removeDuplicates();

        assertEquals(1, list.count());
        assertEquals(2, list.head.value);
    }

    @Test
    void removeDuplicates_from_asc_pair_el_list() {
        list = new OrderedList<>(true);
        list.add(2);
        list.add(2);
        list.removeDuplicates();

        assertEquals(1, list.count());
        assertEquals(2, list.tail.value);
        assertEquals(list.head, list.tail);
    }

    @Test
    void removeDuplicates_from_asc_three_el_list() {
        list = new OrderedList<>(true);
        list.add(2);
        list.add(2);
        list.add(2);
        list.removeDuplicates();

        assertEquals(1, list.count());
        assertEquals(2, list.tail.value);
        assertEquals(list.head, list.tail);
    }

    @Test
    void removeDuplicates_from_tail_asc() {
        list = new OrderedList<>(true);
        list.add(2);
        list.add(2);
        list.add(1);
        list.removeDuplicates();

        assertEquals(2, list.count());
        assertEquals(1, list.head.value);
        assertEquals(2, list.tail.value);
    }

    @Test
    void removeDuplicates_from_head_asc() {
        list = new OrderedList<>(true);
        list.add(2);
        list.add(1);
        list.add(1);
        list.removeDuplicates();

        assertEquals(2, list.count());
        assertEquals(1, list.head.value);
        assertEquals(2, list.tail.value);
    }

    @Test
    void removeDuplicates_without_dups() {
        list = new OrderedList<>(true);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.removeDuplicates();

        assertEquals(4, list.count());
        assertEquals(1, list.head.value);
        assertEquals(4, list.tail.value);
    }

    @Test
    void removeDuplicates_with_every_el() {
        list = new OrderedList<>(true);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(1);
        list.add(1);

        list.removeDuplicates();

        assertEquals(4, list.count());
        assertEquals(1, list.head.value);
        assertEquals(2, list.head.next.value);
        assertEquals(3, list.tail.prev.value);
        assertEquals(4, list.tail.value);
    }

    @Test
    void isSubList_emptyInputList() {
        list = new OrderedList<>(true);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);

        assertTrue(list.isSubList(new OrderedList<>(true)));
    }

    @Test
    void isSubList_singleSubListEl_positive() {
        list = new OrderedList<>(true);
        list.add(2);
        list.add(2);
        list.add(3);

        var subList = new OrderedList<Integer>(true);
        subList.add(2);

        assertTrue(list.isSubList(subList));
    }

    @Test
    void isSubList_singleSubListEl_negative() {
        list = new OrderedList<>(true);
        list.add(2);
        list.add(2);
        list.add(3);

        var subList = new OrderedList<Integer>(true);
        subList.add(1);

        assertFalse(list.isSubList(subList));
    }

    @Test
    void isSubList_singleListEl_singleSubListEl_positive() {
        list = new OrderedList<>(true);
        list.add(2);

        var subList = new OrderedList<Integer>(true);
        subList.add(2);

        assertTrue(list.isSubList(subList));
    }

    @Test
    void isSubList_singleListEl_singleSubListEl_negative() {
        list = new OrderedList<>(true);
        list.add(2);

        var subList = new OrderedList<Integer>(true);
        subList.add(1);

        assertFalse(list.isSubList(subList));
    }

    @Test
    void isSubList_pairEl_pairSubListEl_positive() {
        list = new OrderedList<>(true);
        list.add(2);
        list.add(2);

        var subList = new OrderedList<Integer>(true);
        subList.add(2);
        subList.add(2);

        assertTrue(list.isSubList(subList));
    }

    @Test
    void isSubList_pairEl_pairSubListEl_negative() {
        list = new OrderedList<>(true);
        list.add(1);
        list.add(2);

        var subList = new OrderedList<Integer>(true);
        subList.add(2);
        subList.add(2);

        assertFalse(list.isSubList(subList));
    }

    @Test
    void isSubList_manyEls_singleSubListEl_positive() {
        list = new OrderedList<>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(9);

        var subList = new OrderedList<Integer>(true);
        subList.add(3);

        assertTrue(list.isSubList(subList));
    }

    @Test
    void isSubList_manyEls_singleSubListEl_negative() {
        list = new OrderedList<>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(9);

        var subList = new OrderedList<Integer>(true);
        subList.add(4);

        assertFalse(list.isSubList(subList));
    }

    @Test
    void isSubList_manyEls_manySubListEl_positive() {
        list = new OrderedList<>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(9);

        var subList = new OrderedList<Integer>(true);
        subList.add(2);
        subList.add(3);
        subList.add(6);

        assertTrue(list.isSubList(subList));
    }

    @Test
    void isSubList_manyEls_manySubListEl_negative() {
        list = new OrderedList<>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(9);

        var subList = new OrderedList<Integer>(true);
        subList.add(4);
        subList.add(3);
        subList.add(6);

        assertFalse(list.isSubList(subList));
    }

    @Test
    void isSubList_manyEls_manySubListEls_negative() {
        list = new OrderedList<>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(9);

        var subList = new OrderedList<Integer>(true);
        subList.add(1);
        subList.add(4);
        subList.add(6);

        assertFalse(list.isSubList(subList));
    }

    @Test
    void isSubList_eqLength_positive() {
        list = new OrderedList<>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);

        var subList = new OrderedList<Integer>(true);
        subList.add(1);
        subList.add(2);
        subList.add(3);
        subList.add(6);

        assertTrue(list.isSubList(subList));
    }

    @Test
    void isSubList_eqLength_negative() {
        list = new OrderedList<>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);

        var subList = new OrderedList<Integer>(true);
        subList.add(2);
        subList.add(2);
        subList.add(3);
        subList.add(6);

        assertFalse(list.isSubList(subList));
    }
}