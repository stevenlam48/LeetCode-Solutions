package deletennodesaftermnodesofalinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DeleteNNodesAfterMNodesOfALinkedListTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        val head = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
        assertArrayEquals(intArrayOf(1, 2, 6, 7, 11, 12), toArray(solution.deleteNodes(head, 2, 3)))
    }

    @Test
    fun keepOneDeleteTwo() {
        assertArrayEquals(
            intArrayOf(1, 4, 7, 10),
            toArray(solution.deleteNodes(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 1, 2))
        )
    }

    @Test
    fun deleteRemainingTail() {
        assertArrayEquals(intArrayOf(1, 2), toArray(solution.deleteNodes(listOf(1, 2, 3, 4), 2, 8)))
    }

    @Test
    fun emptyList() {
        assertArrayEquals(IntArray(0), toArray(solution.deleteNodes(null, 2, 2)))
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
