package removeduplicatesfromsortedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

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

class RemoveDuplicatesFromSortedListTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(1, 2), toArray(solution.deleteDuplicates(listOf(1, 1, 2))))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(1, 2, 3), toArray(solution.deleteDuplicates(listOf(1, 1, 2, 3, 3))))
    }

    @Test
    fun testEmptyList() {
        assertNull(solution.deleteDuplicates(null))
    }

    @Test
    fun testAllSame() {
        assertArrayEquals(intArrayOf(1), toArray(solution.deleteDuplicates(listOf(1, 1, 1))))
    }

    @Test
    fun testNoDuplicates() {
        assertArrayEquals(intArrayOf(1, 2), toArray(solution.deleteDuplicates(listOf(1, 2))))
    }
}
