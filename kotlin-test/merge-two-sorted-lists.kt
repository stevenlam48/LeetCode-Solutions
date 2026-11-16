package mergetwosortedlists

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class MergeTwoSortedListsTest {
    @Test
    fun example() {
        assertArrayEquals(
            intArrayOf(1, 1, 2, 3, 4, 4),
            toArray(Solution().mergeTwoLists(listOf(1, 2, 4), listOf(1, 3, 4)))
        )
    }

    @Test
    fun bothEmpty() {
        assertNull(Solution().mergeTwoLists(null, null))
    }

    @Test
    fun oneEmpty() {
        assertArrayEquals(intArrayOf(0), toArray(Solution().mergeTwoLists(null, listOf(0))))
    }

    @Test
    fun negativeAndDuplicateValues() {
        assertArrayEquals(
            intArrayOf(-3, -2, -2, 0, 1),
            toArray(Solution().mergeTwoLists(listOf(-3, -2, 1), listOf(-2, 0)))
        )
    }
}

private fun listOf(vararg values: Int): ListNode? {
    val dummy = ListNode(0)
    var curr = dummy
    for (value in values) {
        curr.next = ListNode(value)
        curr = curr.next!!
    }
    return dummy.next
}

private fun toArray(head: ListNode?): IntArray {
    val result = mutableListOf<Int>()
    var curr = head
    while (curr != null) {
        result.add(curr.`val`)
        curr = curr.next
    }
    return result.toIntArray()
}
