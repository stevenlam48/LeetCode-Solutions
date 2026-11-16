package partitionlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PartitionListTest {
    private val solution = Solution()

    @Test
    fun preservesRelativeOrderWithinPartitions() {
        val result = solution.partition(listOf(1, 4, 3, 2, 5, 2), 3)
        assertArrayEquals(intArrayOf(1, 2, 2, 4, 3, 5), toArray(result))
    }

    @Test
    fun handlesTwoElements() {
        val result = solution.partition(listOf(2, 1), 2)
        assertArrayEquals(intArrayOf(1, 2), toArray(result))
    }

    @Test
    fun handlesAllValuesBelowThreshold() {
        val result = solution.partition(listOf(1, 2, 3), 4)
        assertArrayEquals(intArrayOf(1, 2, 3), toArray(result))
    }

    @Test
    fun handlesEmptyList() {
        assertArrayEquals(IntArray(0), toArray(solution.partition(null, 3)))
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
