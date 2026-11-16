package removenthnodefromendoflist

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

class RemoveNthNodeFromEndOfListTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 5),
            toArray(solution.removeNthFromEnd(listOf(1, 2, 3, 4, 5), 2))
        )
    }

    @Test
    fun testSingleNode() {
        assertNull(solution.removeNthFromEnd(listOf(1), 1))
    }

    @Test
    fun testRemoveLast() {
        assertArrayEquals(intArrayOf(1), toArray(solution.removeNthFromEnd(listOf(1, 2), 1)))
    }

    @Test
    fun testRemoveFirst() {
        assertArrayEquals(intArrayOf(2), toArray(solution.removeNthFromEnd(listOf(1, 2), 2)))
    }
}
