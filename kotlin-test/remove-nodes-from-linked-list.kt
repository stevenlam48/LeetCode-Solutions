package removenodesfromlinkedlist

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

class RemoveNodesFromLinkedListTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(13, 8),
            toArray(solution.removeNodes(listOf(5, 2, 13, 3, 8)))
        )
    }

    @Test
    fun testEqualValues() {
        assertArrayEquals(intArrayOf(1, 1, 1, 1), toArray(solution.removeNodes(listOf(1, 1, 1, 1))))
    }

    @Test
    fun testStrictlyIncreasing() {
        assertArrayEquals(intArrayOf(4), toArray(solution.removeNodes(listOf(1, 2, 3, 4))))
    }

    @Test
    fun testSingleNode() {
        assertArrayEquals(intArrayOf(5), toArray(solution.removeNodes(listOf(5))))
    }

    @Test
    fun testEmptyList() {
        assertNull(solution.removeNodes(null))
    }
}
