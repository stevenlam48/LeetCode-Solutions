package swappingnodesinalinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SwappingNodesInALinkedListTest {
    @Test
    fun interiorNodes() {
        assertArrayEquals(intArrayOf(1, 4, 3, 2, 5), toArray(Solution().swapNodes(listOf(1, 2, 3, 4, 5), 2)))
    }

    @Test
    fun endpoints() {
        assertArrayEquals(intArrayOf(5, 2, 3, 4, 1), toArray(Solution().swapNodes(listOf(1, 2, 3, 4, 5), 1)))
    }

    @Test
    fun sameNodeAndSingleNode() {
        assertArrayEquals(intArrayOf(1, 2, 3), toArray(Solution().swapNodes(listOf(1, 2, 3), 2)))
        assertArrayEquals(intArrayOf(9), toArray(Solution().swapNodes(listOf(9), 1)))
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
    var curr = head
    while (curr != null) {
        values.add(curr.`val`)
        curr = curr.next
    }
    return values.toIntArray()
}
