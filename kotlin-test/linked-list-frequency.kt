package linkedlistfrequency

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LinkedListFrequencyTest {
    @Test
    fun groupedValues() {
        val head = listOf(1, 1, 2, 2, 2, 3)
        assertArrayEquals(intArrayOf(2, 3, 1), toArray(Solution().frequenciesOfElements(head)))
    }

    @Test
    fun emptyList() {
        assertArrayEquals(intArrayOf(), toArray(Solution().frequenciesOfElements(null)))
    }

    @Test
    fun singleElement() {
        val head = listOf(7)
        assertArrayEquals(intArrayOf(1), toArray(Solution().frequenciesOfElements(head)))
    }

    @Test
    fun negativeAndRepeatedValues() {
        val head = listOf(-1, -1, -1, 0, 0, 4)
        assertArrayEquals(intArrayOf(3, 2, 1), toArray(Solution().frequenciesOfElements(head)))
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
    val values = mutableListOf<Int>()
    var node = head
    while (node != null) {
        values.add(node.`val`)
        node = node.next
    }
    return values.toIntArray()
}
