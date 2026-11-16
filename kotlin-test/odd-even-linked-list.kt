package oddevenlinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OddEvenLinkedListTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(1, 3, 5, 2, 4), toArray(solution.oddEvenList(listOf(1, 2, 3, 4, 5))))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            intArrayOf(2, 3, 6, 7, 1, 5, 4),
            toArray(solution.oddEvenList(listOf(2, 1, 3, 5, 6, 4, 7)))
        )
    }

    @Test
    fun testEmpty() {
        assertNull(solution.oddEvenList(null))
    }

    @Test
    fun testSingle() {
        assertArrayEquals(intArrayOf(1), toArray(solution.oddEvenList(listOf(1))))
    }

    @Test
    fun testTwo() {
        assertArrayEquals(intArrayOf(1, 2), toArray(solution.oddEvenList(listOf(1, 2))))
    }
}

private fun listOf(vararg v: Int): ListNode? {
    if (v.isEmpty()) return null
    val head = ListNode(v[0])
    var tail = head
    for (i in 1 until v.size) {
        tail.next = ListNode(v[i])
        tail = tail.next!!
    }
    return head
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
