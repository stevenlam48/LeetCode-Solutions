package deletenodesfromlinkedlistpresentinarray

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DeleteNodesFromLinkedListPresentInArrayTest {
    private val solution = Solution()

    @Test
    fun removesInitialValues() {
        assertArrayEquals(intArrayOf(4, 5), toArray(solution.modifiedList(intArrayOf(1, 2, 3), listOf(1, 2, 3, 4, 5))))
    }

    @Test
    fun removesAlternatingValues() {
        assertArrayEquals(
            intArrayOf(2, 2, 2),
            toArray(solution.modifiedList(intArrayOf(1), listOf(1, 2, 1, 2, 1, 2)))
        )
    }

    @Test
    fun allNodesRemoved() {
        assertArrayEquals(IntArray(0), toArray(solution.modifiedList(intArrayOf(1, 2), listOf(1, 2, 1))))
    }

    @Test
    fun emptyNumsLeavesListUnchanged() {
        assertArrayEquals(intArrayOf(3, 1, 3), toArray(solution.modifiedList(IntArray(0), listOf(3, 1, 3))))
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
    var current = head
    while (current != null) {
        result.add(current.`val`)
        current = current.next
    }
    return result.toIntArray()
}
