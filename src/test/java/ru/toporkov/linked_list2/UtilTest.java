package ru.toporkov.linked_list2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilTest {

    @Test
    void reverseList_single_element() {
        LinkedList2 list = new LinkedList2();
        Node node = new Node(4);
        list.addInTail(node);

        LinkedList2 res = Util.reverseList(list);

        assertEquals(1, res.count());
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void reverseList_many_element() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(4);
        Node node2 = new Node(8);
        Node node3 = new Node(9);
        Node node4 = new Node(11);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        LinkedList2 res = Util.reverseList(list);

        assertEquals(4, res.count());
        assertEquals(4, list.tail.value);
        assertEquals(11, list.head.value);
        assertEquals(9, list.head.next.value);
        assertEquals(8, list.head.next.next.value);
        assertEquals(4, list.head.next.next.next.value);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void reverseList_two_element() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(4);
        Node node2 = new Node(8);
        list.addInTail(node1);
        list.addInTail(node2);

        LinkedList2 res = Util.reverseList(list);

        assertEquals(2, res.count());
        assertEquals(4, list.tail.value);
        assertEquals(8, list.head.value);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void isThereCycle_one_element() {
        LinkedList2 list = new LinkedList2();
        Node node = new Node(4);
        list.addInTail(node);

        assertFalse(Util.isThereCycle(list));
    }

    @Test
    void isThereCycle_two_elements_without_cycle() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        list.addInTail(node1);
        list.addInTail(node2);

        assertFalse(Util.isThereCycle(list));
    }

    @Test
    void isThereCycle_two_elements_with_cycle() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        list.addInTail(node1);
        list.addInTail(node2);

        list.tail.next = list.head;

        assertTrue(Util.isThereCycle(list));
    }

    @Test
    void isThereCycle_many_elements_with_cycle() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(7);
        Node node5 = new Node(8);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.addInTail(node5);

        list.tail.next = node3;

        assertTrue(Util.isThereCycle(list));
    }

    @Test
    void isThereCycle_many_elements_without_cycle() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(7);
        Node node5 = new Node(8);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.addInTail(node5);

        assertFalse(Util.isThereCycle(list));
    }

    @Test
    void isThereCycle_many_elements_with_cycle_no() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(7);
        Node node5 = new Node(8);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.addInTail(node5);
        list.addInTail(node2);

        assertTrue(Util.isThereCycle(list));
    }

    @Test
    void sort_single_element() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(3);
        list.addInTail(node1);

        Util.sort(list);

        assertEquals(3, list.head.value);

    }

    @Test
    void sort_pair_no_sort_element() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(3);
        Node node2 = new Node(4);
        list.addInTail(node1);
        list.addInTail(node2);

        Util.sort(list);

        assertEquals(3, list.head.value);
        assertEquals(4, list.tail.value);
    }

    @Test
    void sort_pair_element() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(4);
        Node node2 = new Node(3);
        list.addInTail(node1);
        list.addInTail(node2);

        Util.sort(list);

        assertEquals(3, list.head.value);
        assertEquals(4, list.tail.value);
    }

    @Test
    void sort_pair_equal_element() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(4);
        Node node2 = new Node(4);
        list.addInTail(node1);
        list.addInTail(node2);

        Util.sort(list);

        assertEquals(4, list.head.value);
        assertEquals(4, list.tail.value);
    }

    @Test
    void sort_many_sorted_element() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(7);
        Node node5 = new Node(8);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.addInTail(node5);

        Util.sort(list);

        Node node = list.head.next;

        while (node != null) {
            assertTrue(node.value > node.prev.value);
            node = node.next;
        }
    }

    @Test
    void sort_many_not_sorted_element() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(4);
        Node node2 = new Node(6);
        Node node3 = new Node(5);
        Node node4 = new Node(7);
        Node node5 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.addInTail(node5);

        Util.sort(list);

        Node node = list.head.next;

        while (node != null) {
            assertTrue(node.value > node.prev.value);
            node = node.next;
        }
    }
}