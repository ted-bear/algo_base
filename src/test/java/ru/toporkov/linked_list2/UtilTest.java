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

    @Test
    void merge_many_not_sorted_element() {
        LinkedList2 list1 = new LinkedList2();
        Node node1 = new Node(4);
        Node node2 = new Node(6);
        Node node3 = new Node(5);
        Node node4 = new Node(7);
        Node node5 = new Node(1);
        list1.addInTail(node1);
        list1.addInTail(node2);
        list1.addInTail(node3);
        list1.addInTail(node4);
        list1.addInTail(node5);

        LinkedList2 list2 = new LinkedList2();
        Node node21 = new Node(8);
        Node node22 = new Node(2);
        Node node23 = new Node(0);
        Node node24 = new Node(9);
        Node node25 = new Node(3);
        list2.addInTail(node21);
        list2.addInTail(node22);
        list2.addInTail(node23);
        list2.addInTail(node24);
        list2.addInTail(node25);

        LinkedList2 result = Util.merge(list1, list2);

        Node node = result.head.next;

        while (node != null) {
            assertTrue(node.value > node.prev.value);
            node = node.next;
        }
    }

    @Test
    void merge_empty_lists() {
        LinkedList2 list1 = new LinkedList2();
        LinkedList2 list2 = new LinkedList2();

        LinkedList2 result = Util.merge(list1, list2);

        assertNull(result.head);
    }

    @Test
    void merge_single_not_sorted_lists() {
        LinkedList2 list1 = new LinkedList2();
        list1.addInTail(new Node(10));
        LinkedList2 list2 = new LinkedList2();
        list2.addInTail(new Node(5));

        LinkedList2 result = Util.merge(list1, list2);
        Node node = result.head.next;

        while (node != null) {
            assertTrue(node.value > node.prev.value);
            node = node.next;
        }
    }

    @Test
    void merge_different_len_not_sorted_lists() {
        LinkedList2 list1 = new LinkedList2();
        list1.addInTail(new Node(10));
        list1.addInTail(new Node(9));
        list1.addInTail(new Node(8));
        list1.addInTail(new Node(7));
        LinkedList2 list2 = new LinkedList2();
        list2.addInTail(new Node(6));
        list2.addInTail(new Node(5));
        list2.addInTail(new Node(4));
        list2.addInTail(new Node(3));
        list2.addInTail(new Node(2));
        list2.addInTail(new Node(1));

        LinkedList2 result = Util.merge(list1, list2);
        Node node = result.head.next;

        while (node != null) {
            assertTrue(node.value > node.prev.value);
            node = node.next;
        }
    }

    @Test
    void merge_different_len_sorted_lists() {
        LinkedList2 list1 = new LinkedList2();
        list1.addInTail(new Node(10));
        list1.addInTail(new Node(11));
        list1.addInTail(new Node(12));
        list1.addInTail(new Node(13));
        LinkedList2 list2 = new LinkedList2();
        list2.addInTail(new Node(15));

        LinkedList2 result = Util.merge(list1, list2);
        Node node = result.head.next;

        while (node != null) {
            assertTrue(node.value > node.prev.value);
            node = node.next;
        }
    }
}