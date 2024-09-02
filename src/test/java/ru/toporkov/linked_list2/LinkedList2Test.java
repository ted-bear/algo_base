package ru.toporkov.linked_list2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedList2Test {

    LinkedList2 ll;

    @Test
    void remove_first_elem() {
        initLongLinkedList2();

        Node nextHead = ll.head.next;
        Node tail = ll.tail;

        boolean removed = ll.remove(12);

        assertTrue(removed);
        assertEquals(nextHead, ll.head);
        assertEquals(tail, ll.tail);
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void remove_empty() {
        ll = new LinkedList2();

        boolean removed = ll.remove(12);

        assertFalse(removed);
        assertNull(ll.head);
        assertNull(ll.tail);
    }

    @Test
    void remove_last_elem() {
        initLongLinkedList2();

        boolean removed = ll.remove(32);

        assertTrue(removed);
        assertEquals(ll.head.value, 12);
        assertEquals(ll.tail.value, 4);
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void remove_rand_elem() {
        initLongLinkedList2();

        boolean removed = ll.remove(17);

        assertTrue(removed);
        assertEquals(ll.head.value, 12);
        assertEquals(ll.tail.value, 32);
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void remove_single_elem() {
        initSingleNodeLinkedList2();

        boolean removed = ll.remove(12);

        assertTrue(removed);
        assertNull(ll.head);
        assertNull(ll.tail);
    }

    @Test
    void remove_single_elem_not_exist() {
        initSingleNodeLinkedList2();

        boolean removed = ll.remove(13);

        assertFalse(removed);
    }

    @Test
    void insertAfter_empty_list() {
        LinkedList2 ll = new LinkedList2();

        Node nodeToInsert = new Node(5);
        ll.insertAfter(null, nodeToInsert);

        assertEquals(1, ll.count());
        assertEquals(ll.head, nodeToInsert);
        assertEquals(ll.tail, nodeToInsert);
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void insertAfter_before_single_element_list() {
        LinkedList2 ll = new LinkedList2();
        ll.addInTail(new Node(1));
        Node tail = ll.tail;

        Node nodeToInsert = new Node(5);
        ll.insertAfter(null, nodeToInsert);

        assertEquals(2, ll.count());
        assertEquals(ll.head, nodeToInsert);
        assertEquals(ll.tail, tail);
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void insertAfter_single_element_list() {
        LinkedList2 ll = new LinkedList2();
        ll.addInTail(new Node(1));
        Node head = ll.head;

        Node nodeToInsert = new Node(5);
        ll.insertAfter(ll.head, nodeToInsert);

        assertEquals(2, ll.count());
        assertEquals(ll.head, head);
        assertEquals(ll.tail, nodeToInsert);
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void insertAfter_head_many_elements_list() {
        initLongLinkedList2();
        Node head = ll.head;
        Node tail = ll.tail;
        int size = ll.count();

        Node nodeToInsert = new Node(5);
        ll.insertAfter(ll.head, nodeToInsert);

        assertEquals(size + 1, ll.count());
        assertEquals(ll.head, head);
        assertEquals(ll.tail, tail);
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void insertAfter_tail_many_elements_list() {
        initLongLinkedList2();
        Node head = ll.head;
        int size = ll.count();

        Node nodeToInsert = new Node(5);
        ll.insertAfter(ll.tail, nodeToInsert);

        assertEquals(size + 1, ll.count());
        assertEquals(ll.head, head);
        assertEquals(ll.tail, nodeToInsert);
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void insertAfter_many_elements_list() {
        Node node1 = new Node(12);
        Node node2 = new Node(3);
        Node node3 = new Node(8);

        ll = new LinkedList2();
        ll.addInTail(node1);
        ll.addInTail(node2);
        ll.addInTail(node3);

        Node head = ll.head;
        Node tail = ll.tail;
        int size = ll.count();

        Node nodeToInsert = new Node(5);
        ll.insertAfter(node2, nodeToInsert);

        assertEquals(size + 1, ll.count());
        assertNotNull(ll.find(5));
        assertEquals(ll.head, head);
        assertEquals(ll.tail, tail);
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void removeAll_empty_list() {
        LinkedList2 ll = new LinkedList2();

        ll.removeAll(21);

        assertEquals(0, ll.count());
        assertNull(ll.head);
        assertNull(ll.tail);
    }

    @Test
    void removeAll_single_element_list() {
        Node node = new Node(21);
        LinkedList2 ll = new LinkedList2();

        ll.addInTail(node);

        ll.removeAll(21);

        assertEquals(0, ll.count());
        assertNull(ll.head);
        assertNull(ll.tail);
    }

    @Test
    void removeAll_pair_element_list() {
        Node node1 = new Node(21);
        Node node2 = new Node(21);
        LinkedList2 ll = new LinkedList2();

        ll.addInTail(node1);
        ll.addInTail(node2);

        ll.removeAll(21);

        assertEquals(0, ll.count());
        assertNull(ll.head);
        assertNull(ll.tail);
    }

    @Test
    void removeAll_head_element_list() {
        Node node1 = new Node(21);
        Node node2 = new Node(5);
        Node node3 = new Node(17);
        LinkedList2 ll = new LinkedList2();

        ll.addInTail(node1);
        ll.addInTail(node2);
        ll.addInTail(node3);

        ll.removeAll(21);

        assertEquals(2, ll.count());
        assertEquals(5, ll.head.value);
        assertEquals(17, ll.tail.value);
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void removeAll_tail_element_list() {
        Node node1 = new Node(21);
        Node node2 = new Node(5);
        Node node3 = new Node(17);
        LinkedList2 ll = new LinkedList2();

        ll.addInTail(node1);
        ll.addInTail(node2);
        ll.addInTail(node3);

        ll.removeAll(17);

        assertEquals(2, ll.count());
        assertEquals(21, ll.head.value);
        assertEquals(5, ll.tail.value);
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void removeAll_rand_element_list() {
        Node node1 = new Node(21);
        Node node2 = new Node(5);
        Node node3 = new Node(17);
        LinkedList2 ll = new LinkedList2();

        ll.addInTail(node1);
        ll.addInTail(node2);
        ll.addInTail(node3);

        ll.removeAll(5);

        assertEquals(2, ll.count());
        assertEquals(21, ll.head.value);
        assertEquals(17, ll.tail.value);
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void removeAll_rand_elements_list() {
        Node node1 = new Node(21);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(17);
        LinkedList2 ll = new LinkedList2();

        ll.addInTail(node1);
        ll.addInTail(node2);
        ll.addInTail(node3);
        ll.addInTail(node4);

        ll.removeAll(5);

        assertEquals(3, ll.count());
        assertEquals(21, ll.head.value);
        assertEquals(17, ll.tail.value);
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void removeAll_rand_pair_elements_list() {
        Node node1 = new Node(21);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(5);
        Node node5 = new Node(17);
        LinkedList2 ll = new LinkedList2();

        ll.addInTail(node1);
        ll.addInTail(node2);
        ll.addInTail(node4);
        ll.addInTail(node3);
        ll.addInTail(node5);

        ll.removeAll(5);

        assertEquals(3, ll.count());
        assertEquals(21, ll.head.value);
        assertEquals(17, ll.tail.value);
        assertNull(ll.find(5));
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    @Test
    void removeAll_not_exists_element_list() {
        Node node1 = new Node(21);
        Node node3 = new Node(6);
        Node node5 = new Node(17);
        LinkedList2 ll = new LinkedList2();

        ll.addInTail(node1);
        ll.addInTail(node3);
        ll.addInTail(node5);

        ll.removeAll(5);

        assertEquals(3, ll.count());
        assertEquals(21, ll.head.value);
        assertEquals(17, ll.tail.value);
        assertNull(ll.find(5));
        assertNull(ll.head.prev);
        assertNull(ll.tail.next);
    }

    private void initLongLinkedList2() {
        Node node1 = new Node(12);
        Node node2 = new Node(54);
        Node node3 = new Node(54);
        Node node4 = new Node(19);
        Node node5 = new Node(17);
        Node node6 = new Node(4);
        Node node7 = new Node(32);

        ll = new LinkedList2();
        ll.addInTail(node1);
        ll.addInTail(node2);
        ll.addInTail(node4);
        ll.addInTail(node3);
        ll.addInTail(node5);
        ll.addInTail(node6);
        ll.addInTail(node7);
    }

    private void initSingleNodeLinkedList2() {
        Node node1 = new Node(12);

        ll = new LinkedList2();
        ll.addInTail(node1);
    }

    private void initPairElementsLinkedList2() {
        Node node1 = new Node(12);
        Node node2 = new Node(12);

        ll = new LinkedList2();
        ll.addInTail(node1);
        ll.addInTail(node2);
    }

}