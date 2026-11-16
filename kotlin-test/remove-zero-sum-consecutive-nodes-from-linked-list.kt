package removezerosumconsecutivenodesfromlinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

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

class RemoveZeroSumConsecutiveNodesFromLinkedListTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        val head = solution.removeZeroSumSublists(listOf(1, 2, -3, 3, 1))
        assertArrayEquals(intArrayOf(3, 1), toArray(head))
    }

    @Test
    fun removesInteriorZeroSumSequence() {
        val head = solution.removeZeroSumSublists(listOf(1, 2, 3, -3, 4))
        assertArrayEquals(intArrayOf(1, 2, 4), toArray(head))
    }

    @Test
    fun removesSequenceEndingAtTail() {
        val head = solution.removeZeroSumSublists(listOf(1, 2, 3, -3, -2))
        assertArrayEquals(intArrayOf(1), toArray(head))
    }

    @Test
    fun removesEntireList() {
        val head = solution.removeZeroSumSublists(listOf(0, 1, -1, 2, -2))
        assertArrayEquals(intArrayOf(), toArray(head))
    }

    @Test
    fun removesSeveralSeparateSequences() {
        val head = solution.removeZeroSumSublists(listOf(-1, 1, 2, -2, 3))
        assertArrayEquals(intArrayOf(3), toArray(head))
    }
}
