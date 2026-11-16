package convertdoublylinkedlisttoarrayii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConvertDoublyLinkedListToArrayIiTest {
    @Test
    fun startAtHead() {
        val nodes = listOf(1, 2, 3, 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 4), Solution().toArray(nodes[0]))
    }

    @Test
    fun startInMiddleWalksBackToHead() {
        val nodes = listOf(1, 2, 3, 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 4), Solution().toArray(nodes[2]))
    }

    @Test
    fun startAtTailWalksBackToHead() {
        val nodes = listOf(1, 2, 3, 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 4), Solution().toArray(nodes[3]))
    }

    @Test
    fun singleNode() {
        assertArrayEquals(intArrayOf(5), Solution().toArray(Node(5)))
    }

    private fun listOf(vararg values: Int): List<Node> {
        val nodes = values.map(::Node)
        for (i in nodes.indices) {
            if (i > 0) {
                nodes[i].prev = nodes[i - 1]
            }
            if (i + 1 < nodes.size) {
                nodes[i].next = nodes[i + 1]
            }
        }
        return nodes
    }
}
