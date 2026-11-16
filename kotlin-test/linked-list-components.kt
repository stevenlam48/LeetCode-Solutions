package linkedlistcomponents
// Time:  O(m + n), m is the number of G, n is the number of nodes
// Space: O(m)

import common.ListNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LinkedListComponentsTest {
    @Test
    fun countsFirstLeetCodeExample() {
        assertEquals(2, Solution().numComponents(listOf(0, 1, 2, 3), intArrayOf(0, 1, 3)))
    }

    @Test
    fun countsSecondLeetCodeExample() {
        assertEquals(2, Solution().numComponents(listOf(0, 1, 2, 3, 4), intArrayOf(0, 3, 1, 4)))
    }

    @Test
    fun ignoresDuplicateValuesInG() {
        assertEquals(1, Solution().numComponents(listOf(1, 2, 2, 3), intArrayOf(2, 2, 3)))
    }

    @Test
    fun handlesEmptyInputs() {
        assertEquals(0, Solution().numComponents(listOf(1, 2), IntArray(0)))
        assertEquals(0, Solution().numComponents(null, intArrayOf(1, 2)))
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
