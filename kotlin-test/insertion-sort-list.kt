package insertionsortlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class InsertionSortListTest {
    @Test
    fun sortsLeetCodeExample() {
        assertArrayEquals(intArrayOf(1, 2, 3, 4), toArray(Solution().insertionSortList(listOf(4, 2, 1, 3))))
    }

    @Test
    fun sortsReverseOrderedAndNegativeValues() {
        assertArrayEquals(
            intArrayOf(-5, -1, 0, 1, 2, 3),
            toArray(Solution().insertionSortList(listOf(3, 2, 1, 0, -1, -5)))
        )
    }

    @Test
    fun keepsDuplicatesStable() {
        assertArrayEquals(intArrayOf(1, 1, 2, 2, 2, 3), toArray(Solution().insertionSortList(listOf(2, 1, 2, 3, 1, 2))))
    }

    @Test
    fun handlesEmptyAndSingleNodeLists() {
        assertArrayEquals(IntArray(0), toArray(Solution().insertionSortList(null)))
        assertArrayEquals(intArrayOf(Int.MIN_VALUE), toArray(Solution().insertionSortList(listOf(Int.MIN_VALUE))))
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
    val result = mutableListOf<Int>()
    var current = head
    while (current != null) {
        result.add(current.`val`)
        current = current.next
    }
    return result.toIntArray()
}
