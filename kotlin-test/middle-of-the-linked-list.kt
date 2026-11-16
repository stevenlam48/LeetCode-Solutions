package middleofthelinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MiddleOfTheLinkedListTest {
    private fun listOf(vararg v: Int): ListNode? {
        var head: ListNode? = null
        for (i in v.size - 1 downTo 0) {
            val node = ListNode(v[i])
            node.next = head
            head = node
        }
        return head
    }

    private fun toArray(head: ListNode?): IntArray {
        val result = mutableListOf<Int>()
        var cur = head
        while (cur != null) {
            result.add(cur.`val`)
            cur = cur.next
        }
        return result.toIntArray()
    }

    @Test
    fun oddLength() {
        assertEquals(3, Solution().middleNode(listOf(1, 2, 3, 4, 5))!!.`val`)
    }

    @Test
    fun evenLengthTakesSecondMiddle() {
        val middle = Solution().middleNode(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(intArrayOf(4, 5, 6).toList(), toArray(middle).toList())
    }

    @Test
    fun singleNode() {
        assertEquals(1, Solution().middleNode(listOf(1))!!.`val`)
    }

    @Test
    fun twoNodes() {
        assertEquals(2, Solution().middleNode(listOf(1, 2))!!.`val`)
    }
}
