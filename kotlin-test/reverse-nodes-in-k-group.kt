package reversenodesinkgroup

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ReverseNodesInKGroupTest {
    @Test
    fun groupsOfTwo() {
        assertArrayEquals(intArrayOf(2, 1, 4, 3, 5), toArray(Solution().reverseKGroup(listOf(1, 2, 3, 4, 5), 2)))
    }

    @Test
    fun groupsOfThree() {
        assertArrayEquals(intArrayOf(3, 2, 1, 4, 5), toArray(Solution().reverseKGroup(listOf(1, 2, 3, 4, 5), 3)))
    }

    @Test
    fun groupOfOne() {
        assertArrayEquals(intArrayOf(1, 2, 3), toArray(Solution().reverseKGroup(listOf(1, 2, 3), 1)))
    }

    @Test
    fun groupLongerThanList() {
        assertArrayEquals(intArrayOf(1, 2), toArray(Solution().reverseKGroup(listOf(1, 2), 3)))
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
