package mergenodesinbetweenzeros

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MergeNodesInBetweenZerosTest {
    @Test
    fun exampleOne() {
        val head = listOf(0, 3, 1, 0, 4, 5, 2, 0)!!
        assertArrayEquals(intArrayOf(4, 11), toArray(Solution().mergeNodes(head)))
    }

    @Test
    fun exampleTwo() {
        val head = listOf(0, 1, 0, 3, 0, 2, 2, 0)!!
        assertArrayEquals(intArrayOf(1, 3, 4), toArray(Solution().mergeNodes(head)))
    }

    @Test
    fun singleSegment() {
        val head = listOf(0, 5, 0)!!
        assertArrayEquals(intArrayOf(5), toArray(Solution().mergeNodes(head)))
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
    var curr = head
    while (curr != null) {
        result.add(curr.`val`)
        curr = curr.next
    }
    return result.toIntArray()
}
