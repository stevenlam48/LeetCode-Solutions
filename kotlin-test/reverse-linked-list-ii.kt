package reverselinkedlistii

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ReverseLinkedListIiTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(1, 4, 3, 2, 5),
            toArray(Solution().reverseBetween(listOf(1, 2, 3, 4, 5), 2, 4))
        )
    }

    @Test
    fun singleNode() {
        assertArrayEquals(
            intArrayOf(5),
            toArray(Solution().reverseBetween(listOf(5), 1, 1))
        )
    }

    @Test
    fun headToTail() {
        assertArrayEquals(
            intArrayOf(3, 2, 1),
            toArray(Solution().reverseBetween(listOf(1, 2, 3), 1, 3))
        )
    }

    @Test
    fun reversedAtHead() {
        assertArrayEquals(
            intArrayOf(2, 1, 3),
            toArray(Solution().reverseBetween(listOf(1, 2, 3), 1, 2))
        )
    }

    @Test
    fun reversedAtTail() {
        assertArrayEquals(
            intArrayOf(1, 3, 2),
            toArray(Solution().reverseBetween(listOf(1, 2, 3), 2, 3))
        )
    }

    @Test
    fun singlePositionUnchanged() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 4, 5),
            toArray(Solution().reverseBetween(listOf(1, 2, 3, 4, 5), 3, 3))
        )
    }

    @Test
    fun twoNodes() {
        assertArrayEquals(
            intArrayOf(2, 1),
            toArray(Solution().reverseBetween(listOf(1, 2), 1, 2))
        )
    }
}

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
