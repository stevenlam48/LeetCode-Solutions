package reorderlist

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

class ReorderListTest {
    private val solution = Solution()

    @Test
    fun evenLengthExample() {
        val head = listOf(1, 2, 3, 4)
        solution.reorderList(head)
        assertArrayEquals(intArrayOf(1, 4, 2, 3), toArray(head))
    }

    @Test
    fun oddLengthExample() {
        val head = listOf(1, 2, 3, 4, 5)
        solution.reorderList(head)
        assertArrayEquals(intArrayOf(1, 5, 2, 4, 3), toArray(head))
    }

    @Test
    fun emptyListRemainsEmpty() {
        assertArrayEquals(intArrayOf(), toArray(null))
        solution.reorderList(null)
    }

    @Test
    fun singleNodeIsUnchanged() {
        val head = listOf(1)
        solution.reorderList(head)
        assertArrayEquals(intArrayOf(1), toArray(head))
    }

    @Test
    fun twoNodesAreUnchanged() {
        val head = listOf(1, 2)
        solution.reorderList(head)
        assertArrayEquals(intArrayOf(1, 2), toArray(head))
    }
}
