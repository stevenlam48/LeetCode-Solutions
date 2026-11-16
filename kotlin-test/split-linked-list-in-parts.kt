package splitlinkedlistinparts

import common.ListNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SplitLinkedListInPartsTest {
    private val solution = Solution()

    @Test
    fun `splits ten nodes into three balanced parts`() {
        val result = solution.splitListToParts(linkedListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3)

        assertParts(result, intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7), intArrayOf(8, 9, 10))
    }

    @Test
    fun `adds empty parts when k exceeds the list length`() {
        val result = solution.splitListToParts(linkedListOf(1, 2, 3), 5)

        assertParts(result, intArrayOf(1), intArrayOf(2), intArrayOf(3), intArrayOf(), intArrayOf())
    }

    @Test
    fun `keeps a single node in one part`() {
        val result = solution.splitListToParts(linkedListOf(42), 1)

        assertParts(result, intArrayOf(42))
    }

    @Test
    fun `returns k empty parts for an empty list`() {
        val result = solution.splitListToParts(null, 3)

        assertParts(result, intArrayOf(), intArrayOf(), intArrayOf())
    }

    private fun assertParts(result: Array<ListNode?>, vararg expected: IntArray) {
        assertEquals(expected.size, result.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], toArray(result[i]))
        }
    }
}

private fun linkedListOf(vararg values: Int): ListNode? {
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
