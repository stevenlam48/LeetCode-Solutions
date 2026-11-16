package designlinkedlist

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignLinkedListTest {
    @Test
    fun leetCodeExample() {
        val list = MyLinkedList()
        list.addAtHead(1)
        list.addAtTail(3)
        list.addAtIndex(1, 2)
        assertEquals(2, list.get(1))
        list.deleteAtIndex(1)
        assertEquals(3, list.get(1))
    }

    @Test
    fun insertAtEveryPosition() {
        val list = MyLinkedList()
        list.addAtIndex(0, 2)
        list.addAtHead(1)
        list.addAtTail(4)
        list.addAtIndex(2, 3)
        list.addAtIndex(4, 5)
        for (i in 1..5) {
            assertEquals(i, list.get(i - 1))
        }
    }

    @Test
    fun invalidIndicesDoNotInsertOrDelete() {
        val list = MyLinkedList()
        list.addAtHead(1)
        list.addAtTail(2)
        list.addAtIndex(-1, 9)
        list.addAtIndex(3, 9)
        list.deleteAtIndex(-1)
        list.deleteAtIndex(2)
        assertEquals(1, list.get(0))
        assertEquals(2, list.get(1))
        assertEquals(-1, list.get(2))
    }

    @Test
    fun deleteFromHeadTailAndMiddle() {
        val list = MyLinkedList()
        for (i in 1..5) {
            list.addAtTail(i)
        }
        list.deleteAtIndex(0)
        list.deleteAtIndex(3)
        list.deleteAtIndex(1)
        assertEquals(2, list.get(0))
        assertEquals(4, list.get(1))
        assertEquals(-1, list.get(2))
        list.deleteAtIndex(0)
        list.deleteAtIndex(0)
        assertEquals(-1, list.get(0))
    }
}
