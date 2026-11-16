package addtwonumbersii

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class AddTwoNumbersIiTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        val result = solution.addTwoNumbers(listOf(7, 2, 4, 3), listOf(5, 6, 4))
        assertArrayEquals(intArrayOf(7, 8, 0, 7), toArray(result))
    }

    @Test
    fun differentLengths() {
        val result = solution.addTwoNumbers(listOf(2, 4, 3), listOf(5, 6, 4))
        assertArrayEquals(intArrayOf(8, 0, 7), toArray(result))
    }

    @Test
    fun carryExtendsResult() {
        val result = solution.addTwoNumbers(listOf(9, 9, 9), listOf(1))
        assertArrayEquals(intArrayOf(1, 0, 0, 0), toArray(result))
    }

    @Test
    fun zeros() {
        val result = solution.addTwoNumbers(listOf(0), listOf(0))
        assertArrayEquals(intArrayOf(0), toArray(result))
    }

    @Test
    fun emptyLists() {
        assertNull(solution.addTwoNumbers(null, null))
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
    val result = mutableListOf<Int>()
    var node = head
    while (node != null) {
        result.add(node.`val`)
        node = node.next
    }
    return result.toIntArray()
}
