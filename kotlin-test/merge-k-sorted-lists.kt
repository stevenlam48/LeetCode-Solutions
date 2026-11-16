package mergeksortedlists

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class MergeKSortedListsTest {
    @Test
    fun exampleLists() {
        val lists = arrayOf(listOf(1, 4, 5), listOf(1, 3, 4), listOf(2, 6))
        assertArrayEquals(intArrayOf(1, 1, 2, 3, 4, 4, 5, 6), toArray(Solution().mergeKLists(lists)))
    }

    @Test
    fun emptyArray() {
        assertNull(Solution().mergeKLists(emptyArray<ListNode?>()))
    }

    @Test
    fun nullAndEmptyLists() {
        assertNull(Solution().mergeKLists(arrayOf(null)))
        assertNull(Solution().mergeKLists(arrayOf(null, null)))
    }

    @Test
    fun duplicatesAndNegatives() {
        val lists = arrayOf(listOf(-5, -1, -1), null, listOf(-3, 0, 0), listOf(-2))
        assertArrayEquals(intArrayOf(-5, -3, -2, -1, -1, 0, 0), toArray(Solution().mergeKLists(lists)))
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
    var curr = head
    while (curr != null) {
        result.add(curr.`val`)
        curr = curr.next
    }
    return result.toIntArray()
}
