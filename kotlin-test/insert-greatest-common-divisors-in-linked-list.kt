package insertgreatestcommondivisorsinlinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class InsertGreatestCommonDivisorsInLinkedListTest {
    @Test
    fun insertsDivisorsIntoLeetCodeExample() {
        val head = listOf(18, 6, 10, 3)
        assertSame(head, Solution().insertGreatestCommonDivisors(head))
        assertArrayEquals(intArrayOf(18, 6, 6, 2, 10, 1, 3), toArray(head))
    }

    @Test
    fun handlesTwoNodes() {
        val head = listOf(7, 14)
        assertArrayEquals(intArrayOf(7, 7, 14), toArray(Solution().insertGreatestCommonDivisors(head)))
    }

    @Test
    fun handlesSingleNode() {
        val head = listOf(5)
        assertArrayEquals(intArrayOf(5), toArray(Solution().insertGreatestCommonDivisors(head)))
    }

    @Test
    fun handlesCoprimeAndRepeatedValues() {
        val head = listOf(2, 3, 9)
        assertArrayEquals(intArrayOf(2, 1, 3, 3, 9), toArray(Solution().insertGreatestCommonDivisors(head)))
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
