package ru.toporkov.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListTest {

    LinkedList ll;

    @Test
    void remove_first_elem() {
        initLongLinkedList();

        Node nextHead = ll.head.next;
        Node tail = ll.tail;

        boolean removed = ll.remove(12);

        assertTrue(removed);
        assertEquals(nextHead, ll.head);
        assertEquals(tail, ll.tail);
    }

    @Test
    void remove_empty() {
        ll = new LinkedList();

        boolean removed = ll.remove(12);

        assertFalse(removed);
        assertNull(ll.head);
        assertNull(ll.tail);
    }

    @Test
    void remove_last_elem() {
        initLongLinkedList();

        boolean removed = ll.remove(32);

        assertTrue(removed);
        assertEquals(ll.head.value, 12);
        assertEquals(ll.tail.value, 4);
    }

    @Test
    void remove_rand_elem() {
        initLongLinkedList();

        boolean removed = ll.remove(17);

        assertTrue(removed);
        assertEquals(ll.head.value, 12);
        assertEquals(ll.tail.value, 32);
    }

    @Test
    void remove_single_elem() {
        initSingleNodeLinkedList();

        boolean removed = ll.remove(12);

        assertTrue(removed);
        assertNull(ll.head);
        assertNull(ll.tail);
    }

    @Test
    void remove_single_elem_not_exist() {
        initSingleNodeLinkedList();

        boolean removed = ll.remove(13);

        assertFalse(removed);
    }

    @Test
    void removeAll_one_equal_elem() {
        initLongLinkedList();

        ll.removeAll(19);
        int endSize = ll.count();

        assertEquals(6, endSize);
        assertNull(ll.find(19));
    }

    @Test
    void removeAll_two_elem() {
        initLongLinkedList();

        ll.removeAll(54);
        int endSize = ll.count();

        assertEquals(5, endSize);
        assertNull(ll.find(54));
    }

    @Test
    void removeAll_two_single_elem() {
        initPairElementsLinkedList();

        ll.removeAll(12);
        int endSize = ll.count();

        assertEquals(0, endSize);
        assertNull(ll.find(12));
    }

    @Test
    void removeAll_single_elem() {
        initSingleNodeLinkedList();

        ll.removeAll(12);
        int endSize = ll.count();

        assertEquals(0, endSize);
        assertNull(ll.find(12));
    }

    @Test
    void count_empty() {
        LinkedList ll = new LinkedList();
        assertEquals(0, ll.count());
    }

    @Test
    void count_single_elem() {
        Node node = new Node(1);
        LinkedList ll = new LinkedList();

        ll.addInTail(node);

        assertEquals(1, ll.count());
    }

    @Test
    void count_elems_after_deleting() {
        initLongLinkedList();

        assertTrue(ll.remove(54));
        assertTrue(ll.remove(54));

        assertEquals(5, ll.count());
    }

    @Test
    void insertAfter_rand_position() {
        Node node1 = new Node(12);
        Node node2 = new Node(54);
        Node node3 = new Node(54);
        Node node4 = new Node(19);
        Node node5 = new Node(17);
        Node node6 = new Node(4);
        Node node7 = new Node(32);

        ll = new LinkedList();
        ll.addInTail(node1);
        ll.addInTail(node2);
        ll.addInTail(node3);
        ll.addInTail(node4);
        ll.addInTail(node5);
        ll.addInTail(node6);
        ll.addInTail(node7);

        ll.insertAfter(node1, new Node(2));

        assertEquals(8, ll.count());
        assertNotNull(ll.find(2));
    }

    @Test
    void insertAfter_null() {
        Node node1 = new Node(12);
        Node node2 = new Node(54);
        Node node3 = new Node(54);
        Node node4 = new Node(19);
        Node node5 = new Node(17);
        Node node6 = new Node(4);
        Node node7 = new Node(32);

        ll = new LinkedList();
        ll.addInTail(node1);
        ll.addInTail(node2);
        ll.addInTail(node3);
        ll.addInTail(node4);
        ll.addInTail(node5);
        ll.addInTail(node6);
        ll.addInTail(node7);

        Node newNode = new Node(2);
        ll.insertAfter(null, newNode);

        assertEquals(8, ll.count());
        assertEquals(ll.head, newNode);
        assertNotNull(ll.find(2));
    }

    @Test
    void insertAfter_null_empty_ll() {
        ll = new LinkedList();

        Node newNode = new Node(2);
        ll.insertAfter(null, newNode);

        assertEquals(1, ll.count());
        assertEquals(ll.head, newNode);
        assertEquals(ll.tail, newNode);
        assertNotNull(ll.find(2));
    }

    @Test
    void insertAfter_last_elem() {
        Node node1 = new Node(12);
        Node node2 = new Node(54);
        Node node3 = new Node(54);
        Node node4 = new Node(19);

        ll = new LinkedList();
        ll.addInTail(node1);
        ll.addInTail(node2);
        ll.addInTail(node3);
        ll.addInTail(node4);

        Node newNode = new Node(2);
        ll.insertAfter(node4, newNode);

        assertEquals(5, ll.count());
        assertEquals(ll.tail, newNode);
        assertNotNull(ll.find(2));
    }

    private void initLongLinkedList() {
        Node node1 = new Node(12);
        Node node2 = new Node(54);
        Node node3 = new Node(54);
        Node node4 = new Node(19);
        Node node5 = new Node(17);
        Node node6 = new Node(4);
        Node node7 = new Node(32);

        ll = new LinkedList();
        ll.addInTail(node1);
        ll.addInTail(node2);
        ll.addInTail(node4);
        ll.addInTail(node3);
        ll.addInTail(node5);
        ll.addInTail(node6);
        ll.addInTail(node7);
    }

    private void initSingleNodeLinkedList() {
        Node node1 = new Node(12);

        ll = new LinkedList();
        ll.addInTail(node1);
    }

    private void initPairElementsLinkedList() {
        Node node1 = new Node(12);
        Node node2 = new Node(12);

        ll = new LinkedList();
        ll.addInTail(node1);
        ll.addInTail(node2);
    }
}