package deletethemiddlenodeofalinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

private fun listOf(vararg v: Int): ListNode? {
    if (v.isEmpty()) return null
    val head = ListNode(v[0])
    var cur = head
    for (i in 1 until v.size) {
        cur.next = ListNode(v[i])
        cur = cur.next!!
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

class DeleteTheMiddleNodeOfALinkedListTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val head = listOf(1, 3, 4, 7, 1, 2, 6)
        assertArrayEquals(intArrayOf(1, 3, 4, 1, 2, 6), toArray(solution.deleteMiddle(head)))
    }

    @Test
    fun testExample2() {
        val head = listOf(1, 2, 3, 4)
        assertArrayEquals(intArrayOf(1, 2, 4), toArray(solution.deleteMiddle(head)))
    }

    @Test
    fun testExample3() {
        val head = listOf(2, 1)
        assertArrayEquals(intArrayOf(2), toArray(solution.deleteMiddle(head)))
    }

    @Test
    fun testSingleNode() {
        val head = listOf(1)
        assertNull(solution.deleteMiddle(head))
    }

    @Test
    fun testThreeNodes() {
        val head = listOf(1, 2, 3)
        assertArrayEquals(intArrayOf(1, 3), toArray(solution.deleteMiddle(head)))
    }
}
