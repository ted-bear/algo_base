package ru.toporkov.linked_list2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
}