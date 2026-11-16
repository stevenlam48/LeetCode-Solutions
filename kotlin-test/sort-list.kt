package sortlist

import common.ListNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortListTest {
    @Test
    fun standardPositiveExample() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 4),
            toArray(Solution().sortList(listOf(4, 2, 1, 3)))
        )
    }

    @Test
    fun negativesAndZero() {
        assertArrayEquals(
            intArrayOf(-1, 0, 3, 4, 5),
            toArray(Solution().sortList(listOf(-1, 5, 3, 4, 0)))
        )
    }

    @Test
    fun duplicates() {
        assertArrayEquals(
            intArrayOf(1, 1, 2, 2, 3),
            toArray(Solution().sortList(listOf(2, 1, 3, 1, 2)))
        )
    }

    @Test
    fun emptyAndSingleNode() {
        assertNull(Solution().sortList(null))
        assertArrayEquals(intArrayOf(7), toArray(Solution().sortList(listOf(7))))
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
