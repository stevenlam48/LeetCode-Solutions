package swapnodesinpairs

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SwapNodesInPairsTest {
    @Test
    fun evenLengthList() {
        assertArrayEquals(intArrayOf(2, 1, 4, 3), toArray(Solution().swapPairs(listOf(1, 2, 3, 4))))
    }

    @Test
    fun oddLengthList() {
        assertArrayEquals(intArrayOf(2, 1, 4, 3, 5), toArray(Solution().swapPairs(listOf(1, 2, 3, 4, 5))))
    }

    @Test
    fun emptyAndSingleNodeLists() {
        assertArrayEquals(intArrayOf(), toArray(Solution().swapPairs(null)))
        assertArrayEquals(intArrayOf(7), toArray(Solution().swapPairs(listOf(7))))
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
    val values = mutableListOf<Int>()
    var curr = head
    while (curr != null) {
        values.add(curr.`val`)
        curr = curr.next
    }
    return values.toIntArray()
}
