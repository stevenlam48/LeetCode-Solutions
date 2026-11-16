package removeduplicatesfromsortedlistii

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

class RemoveDuplicatesFromSortedListIiTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(1, 2, 5),
            toArray(solution.deleteDuplicates(listOf(1, 2, 3, 3, 4, 4, 5)))
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(2, 3), toArray(solution.deleteDuplicates(listOf(1, 1, 1, 2, 3))))
    }

    @Test
    fun testEmptyList() {
        assertNull(solution.deleteDuplicates(null))
    }

    @Test
    fun testAllDuplicates() {
        assertNull(solution.deleteDuplicates(listOf(1, 1)))
    }

    @Test
    fun testTrailingDuplicates() {
        assertArrayEquals(intArrayOf(1), toArray(solution.deleteDuplicates(listOf(1, 2, 2))))
    }
}
