package reverselinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ReverseLinkedListTest {
    @Test
    fun example() {
        assertArrayEquals(
            intArrayOf(5, 4, 3, 2, 1),
            toArray(Solution().reverseList(listOf(1, 2, 3, 4, 5)))
        )
    }

    @Test
    fun twoNodes() {
        assertArrayEquals(intArrayOf(2, 1), toArray(Solution().reverseList(listOf(1, 2))))
    }

    @Test
    fun emptyList() {
        assertNull(Solution().reverseList(null))
    }

    @Test
    fun singleNode() {
        assertArrayEquals(intArrayOf(1), toArray(Solution().reverseList(listOf(1))))
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
