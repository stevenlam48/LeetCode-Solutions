package convertbinarysearchtreetosorteddoublylinkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class ConvertBinarySearchTreeToSortedDoublyLinkedListTest {
    @Test
    fun balancedTreeBecomesSortedCircularList() {
        val root = treeOf(4, 2, 5, 1, 3)
        val head = Solution().treeToDoublyList(root)!!
        assertEquals(listOf(1, 2, 3, 4, 5), values(head, 5))
        assertSame(head, head.left!!.right)
        var current = head
        repeat(5) {
            assertSame(current, current.right!!.left)
            current = current.right!!
        }
        assertSame(head, current)
    }

    @Test
    fun singleNodePointsToItself() {
        val head = Solution().treeToDoublyList(Node(1))!!
        assertSame(head, head.left)
        assertSame(head, head.right)
    }

    @Test
    fun nullRoot() {
        assertNull(Solution().treeToDoublyList(null))
    }

    @Test
    fun rightSkewedTree() {
        val root = treeOf(1, null, 2, null, null, null, 3)
        assertEquals(listOf(1, 2, 3), values(Solution().treeToDoublyList(root)!!, 3))
    }

    private fun treeOf(vararg values: Int?): Node? {
        if (values.isEmpty() || values[0] == null) {
            return null
        }
        val nodes = Array<Node?>(values.size) { i -> values[i]?.let(::Node) }
        for (i in nodes.indices) {
            val node = nodes[i] ?: continue
            if (2 * i + 1 < nodes.size) {
                node.left = nodes[2 * i + 1]
            }
            if (2 * i + 2 < nodes.size) {
                node.right = nodes[2 * i + 2]
            }
        }
        return nodes[0]
    }

    private fun values(head: Node, count: Int): List<Int> {
        val result = mutableListOf<Int>()
        var current = head
        repeat(count) {
            result.add(current.`val`)
            current = current.right!!
        }
        return result
    }
}
