package convertdoublylinkedlisttoarrayi

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConvertDoublyLinkedListToArrayITest {
    @Test
    fun convertThreeNodeList() {
        val head = listOf(1, 2, 3)
        assertArrayEquals(intArrayOf(1, 2, 3), Solution().toArray(head))
    }

    @Test
    fun convertSingleNodeList() {
        assertArrayEquals(intArrayOf(4), Solution().toArray(Node(4)))
    }

    @Test
    fun nullHeadReturnsEmptyArray() {
        assertArrayEquals(intArrayOf(), Solution().toArray(null))
    }

    private fun listOf(vararg values: Int): Node? {
        if (values.isEmpty()) {
            return null
        }
        val head = Node(values[0])
        var tail = head
        for (i in 1 until values.size) {
            val node = Node(values[i])
            tail.next = node
            node.prev = tail
            tail = node
        }
        return head
    }
}
