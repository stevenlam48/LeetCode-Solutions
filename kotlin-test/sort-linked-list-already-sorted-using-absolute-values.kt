package sortlinkedlistalreadysortedusingabsolutevalues

import common.ListNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortLinkedListAlreadySortedUsingAbsoluteValuesTest {
    @Test
    fun standardExample() {
        val head = listOf(0, 2, -5, 5, 10, -10)
        assertArrayEquals(
            intArrayOf(-10, -5, 0, 2, 5, 10),
            toArray(Solution().sortLinkedList(head))
        )
    }

    @Test
    fun alternatingSigns() {
        assertArrayEquals(
            intArrayOf(-4, -2, 1, 3),
            toArray(Solution().sortLinkedList(listOf(1, -2, 3, -4)))
        )
    }

    @Test
    fun positiveValuesStayAtTail() {
        assertArrayEquals(
            intArrayOf(1, 2, 3),
            toArray(Solution().sortLinkedList(listOf(1, 2, 3)))
        )
    }

    @Test
    fun zeroIsMovedToFront() {
        assertArrayEquals(
            intArrayOf(0, -1, 2),
            toArray(Solution().sortLinkedList(listOf(-1, 2, 0)))
        )
    }

    @Test
    fun singleNode() {
        assertArrayEquals(intArrayOf(-1), toArray(Solution().sortLinkedList(listOf(-1))))
    }
}

private fun listOf(vararg values: Int): ListNode? {
    val dummy = ListNode(0)
    var tail = dummy
    for (value in values) {
        tail.next = ListNode(value)
        tail = tail.next!!
    }
    return dummy.next
}

private fun toArray(head: ListNode?): IntArray {
    val result = ArrayList<Int>()
    var curr = head
    while (curr != null) {
        result.add(curr.`val`)
        curr = curr.next
    }
    return result.toIntArray()
}
