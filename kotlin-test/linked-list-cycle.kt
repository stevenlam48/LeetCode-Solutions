package linkedlistcycle
// Time:  O(n)
// Space: O(1)

import common.ListNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LinkedListCycleTest {
    @Test
    fun detectsCycleToMiddleNode() {
        assertTrue(Solution().hasCycle(linkedListWithCycle(intArrayOf(3, 2, 0, -4), 1)))
    }

    @Test
    fun detectsSelfCycle() {
        assertTrue(Solution().hasCycle(linkedListWithCycle(intArrayOf(1), 0)))
    }

    @Test
    fun rejectsAcyclicList() {
        assertFalse(Solution().hasCycle(linkedListWithCycle(intArrayOf(1, 2, 3), -1)))
    }

    @Test
    fun handlesEmptyAndSingleNodeLists() {
        assertFalse(Solution().hasCycle(null))
        assertFalse(Solution().hasCycle(ListNode(1)))
    }
}

private fun linkedListWithCycle(values: IntArray, position: Int): ListNode? {
    if (values.isEmpty()) {
        return null
    }
    val nodes = values.map { ListNode(it) }
    for (i in 0 until nodes.lastIndex) {
        nodes[i].next = nodes[i + 1]
    }
    if (position >= 0) {
        nodes.last().next = nodes[position]
    }
    return nodes.first()
}
