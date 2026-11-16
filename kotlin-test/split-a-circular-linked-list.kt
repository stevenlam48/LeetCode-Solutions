package splitacircularlinkedlist

import common.ListNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SplitACircularLinkedListTest {
    @Test
    fun evenLength() {
        val result = Solution().splitCircularLinkedList(circularListOf(1, 2, 3, 4))
        assertArrayEquals(intArrayOf(1, 2), toArray(result[0], 2))
        assertArrayEquals(intArrayOf(3, 4), toArray(result[1], 2))
    }

    @Test
    fun oddLength() {
        val result = Solution().splitCircularLinkedList(circularListOf(1, 2, 3, 4, 5))
        assertArrayEquals(intArrayOf(1, 2, 3), toArray(result[0], 3))
        assertArrayEquals(intArrayOf(4, 5), toArray(result[1], 2))
    }

    @Test
    fun twoElements() {
        val result = Solution().splitCircularLinkedList(circularListOf(1, 2))
        assertArrayEquals(intArrayOf(1), toArray(result[0], 1))
        assertArrayEquals(intArrayOf(2), toArray(result[1], 1))
    }

    @Test
    fun singleElement() {
        val result = Solution().splitCircularLinkedList(circularListOf(1))
        assertArrayEquals(intArrayOf(1), toArray(result[0], 1))
        assertArrayEquals(intArrayOf(1), toArray(result[1], 1))
    }
}

private fun circularListOf(vararg v: Int): ListNode? {
    val dummy = ListNode(0)
    var curr = dummy
    for (x in v) {
        curr.next = ListNode(x)
        curr = curr.next!!
    }
    val head = dummy.next
    curr.next = head
    return head
}

private fun toArray(head: ListNode?, count: Int): IntArray {
    val result = IntArray(count)
    var node = head
    for (i in 0 until count) {
        result[i] = node!!.`val`
        node = node.next
    }
    return result
}
