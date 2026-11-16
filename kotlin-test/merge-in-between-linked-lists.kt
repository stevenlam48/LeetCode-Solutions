package mergeinbetweenlinkedlists

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MergeInBetweenLinkedListsTest {
    @Test
    fun exampleOne() {
        val list1 = listOf(10, 1, 13, 6, 9, 5)
        val list2 = listOf(1000000, 1000001, 1000002)
        val result = Solution().mergeInBetween(list1, 3, 4, list2)
        assertArrayEquals(intArrayOf(10, 1, 13, 1000000, 1000001, 1000002, 5), toArray(result))
    }

    @Test
    fun removeOneNode() {
        val result = Solution().mergeInBetween(listOf(1, 2, 3), 1, 1, listOf(7, 8))
        assertArrayEquals(intArrayOf(1, 7, 8, 3), toArray(result))
    }

    @Test
    fun removeMultipleNodes() {
        val result = Solution().mergeInBetween(listOf(1, 2, 3, 4, 5), 1, 3, listOf(9))
        assertArrayEquals(intArrayOf(1, 9, 5), toArray(result))
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
