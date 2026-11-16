package nextgreaternodeinlinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

private fun listOf(vararg values: Int): ListNode? {
    val dummy = ListNode(0)
    var current = dummy
    for (value in values) {
        current.next = ListNode(value)
        current = current.next!!
    }
    return dummy.next
}

class NextGreaterNodeInLinkedListTest {
    @Test
    fun `finds next larger node values`() {
        assertArrayEquals(intArrayOf(5, 5, 0), Solution().nextLargerNodes(listOf(2, 1, 5)))
    }

    @Test
    fun `finds greater values across nonmonotonic list`() {
        assertArrayEquals(intArrayOf(7, 0, 5, 5, 0), Solution().nextLargerNodes(listOf(2, 7, 4, 3, 5)))
    }

    @Test
    fun `handles increasing and decreasing lists`() {
        assertArrayEquals(intArrayOf(2, 3, 0), Solution().nextLargerNodes(listOf(1, 2, 3)))
        assertArrayEquals(intArrayOf(0, 0, 0), Solution().nextLargerNodes(listOf(3, 2, 1)))
    }

    @Test
    fun `handles empty and single node lists`() {
        assertArrayEquals(IntArray(0), Solution().nextLargerNodes(null))
        assertArrayEquals(intArrayOf(0), Solution().nextLargerNodes(listOf(1)))
    }
}
