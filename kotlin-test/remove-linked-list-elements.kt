package removelinkedlistelements

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

private fun listOf(vararg v: Int): ListNode? {
    val dummy = ListNode(0)
    var tail = dummy
    for (x in v) {
        tail.next = ListNode(x)
        tail = tail.next!!
    }
    return dummy.next
}

private fun toArray(head: ListNode?): IntArray {
    val result = ArrayList<Int>()
    var curr = head
    while (curr != null) {
        result.add(curr.`val`)
        curr = curr.next
    }
    return result.toIntArray()
}

class RemoveLinkedListElementsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val head = listOf(1, 2, 6, 3, 4, 5, 6)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), toArray(solution.removeElements(head, 6)))
    }

    @Test
    fun testEmptyList() {
        assertNull(solution.removeElements(null, 1))
    }

    @Test
    fun testRemoveAllNodes() {
        assertNull(solution.removeElements(listOf(7, 7, 7, 7), 7))
    }

    @Test
    fun testRemoveMiddleValues() {
        assertArrayEquals(intArrayOf(1, 1), toArray(solution.removeElements(listOf(1, 2, 2, 1), 2)))
    }

    @Test
    fun testSingleNodeRemoved() {
        assertNull(solution.removeElements(listOf(1), 1))
    }
}
