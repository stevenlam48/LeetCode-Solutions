package deletenodeinalinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DeleteNodeInALinkedListTest {
    private val solution = Solution()

    @Test
    fun deletesMiddleNode() {
        val head = listOf(4, 5, 1, 9)
        solution.deleteNode(head?.next)
        assertArrayEquals(intArrayOf(4, 1, 9), toArray(head))
    }

    @Test
    fun deletesSecondToLastNode() {
        val head = listOf(4, 5, 1, 9)
        solution.deleteNode(head?.next?.next)
        assertArrayEquals(intArrayOf(4, 5, 9), toArray(head))
    }

    @Test
    fun nullAndTailAreUnchanged() {
        val head = listOf(1, 2)
        solution.deleteNode(null)
        solution.deleteNode(head?.next)
        assertArrayEquals(intArrayOf(1, 2), toArray(head))
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
