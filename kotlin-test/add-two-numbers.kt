package addtwonumbers

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class AddTwoNumbersTest {
    @Test
    fun example() {
        assertArrayEquals(
            intArrayOf(7, 0, 8),
            toArray(Solution().addTwoNumbers(listOf(2, 4, 3), listOf(5, 6, 4)))
        )
    }

    @Test
    fun differentLengths() {
        assertArrayEquals(
            intArrayOf(8, 9, 9, 9, 0, 0, 0, 1),
            toArray(Solution().addTwoNumbers(listOf(9, 9, 9, 9, 9, 9, 9), listOf(9, 9, 9, 9)))
        )
    }

    @Test
    fun zero() {
        assertArrayEquals(intArrayOf(0), toArray(Solution().addTwoNumbers(listOf(0), listOf(0))))
    }

    @Test
    fun finalCarry() {
        assertArrayEquals(intArrayOf(0, 1), toArray(Solution().addTwoNumbers(listOf(5), listOf(5))))
    }
}

private fun listOf(vararg values: Int): ListNode? {
    val dummy = ListNode(0)
    var curr = dummy
    for (value in values) {
        curr.next = ListNode(value)
        curr = curr.next!!
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
