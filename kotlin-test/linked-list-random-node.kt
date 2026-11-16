package linkedlistrandomnode

import common.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LinkedListRandomNodeTest {
    @Test
    fun singleElementAlwaysReturned() {
        val solution = Solution(listOf(42))
        repeat(20) {
            assertEquals(42, solution.getRandom())
        }
    }

    @Test
    fun everyResultComesFromList() {
        val values = setOf(-3, 0, 7, 11)
        val solution = Solution(listOf(-3, 0, 7, 11))
        repeat(200) {
            assertTrue(solution.getRandom() in values)
        }
    }

    @Test
    fun emptyListMatchesCppSentinel() {
        assertEquals(-1, Solution(null).getRandom())
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
