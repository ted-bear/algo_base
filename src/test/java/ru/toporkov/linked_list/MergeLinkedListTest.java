package ru.toporkov.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class MergeLinkedListTest {

    MergeLinkedList mergeLinkedList = new MergeLinkedList();

    @Test
    void merge_not_equal_length_ll() {
        LinkedList ll1 = new LinkedList();
        ll1.addInTail(new Node(2));

        LinkedList ll2 = new LinkedList();

        LinkedList result = mergeLinkedList.merge(ll1, ll2);

        assertNull(result);
    }

    @Test
    void merge_empty_ll() {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();

        LinkedList result = mergeLinkedList.merge(ll1, ll2);

        assertEquals(0, result.count());
        assertNull(result.head);
        assertNull(result.tail);
    }

    @Test
    void merge_two_single_elements() {
        LinkedList ll1 = new LinkedList();
        ll1.addInTail(new Node(2));

        LinkedList ll2 = new LinkedList();
        ll2.addInTail(new Node(5));

        LinkedList result = mergeLinkedList.merge(ll1, ll2);

        assertEquals(1, result.count());
        assertEquals(7, result.head.value);
        assertEquals(7, result.tail.value);
    }

    @Test
    void merge_more_than_one_elements() {
        LinkedList ll1 = new LinkedList();
        ll1.addInTail(new Node(2));
        ll1.addInTail(new Node(3));
        ll1.addInTail(new Node(7));

        LinkedList ll2 = new LinkedList();
        ll2.addInTail(new Node(5));
        ll2.addInTail(new Node(6));
        ll2.addInTail(new Node(8));

        LinkedList result = mergeLinkedList.merge(ll1, ll2);

        assertEquals(3, result.count());
        assertEquals(7, result.head.value);
        assertNotNull(result.find(7));
        assertEquals(15, result.tail.value);
    }
}