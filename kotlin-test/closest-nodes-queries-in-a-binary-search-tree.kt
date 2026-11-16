package closestnodesqueriesinabinarysearchtree

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ClosestNodesQueriesInABinarySearchTreeTest {
    @Test
    fun standardTreeQueries() {
        val actual = Solution().closestNodes(
            treeOf(6, 2, 13, 1, 4, 9, 15, null, null, null, null, 7, null, 14),
            intArrayOf(2, 5, 16)
        )
        assertEquals(3, actual.size)
        assertArrayEquals(intArrayOf(2, 2), actual[0])
        assertArrayEquals(intArrayOf(4, 6), actual[1])
        assertArrayEquals(intArrayOf(15, -1), actual[2])
    }

    @Test
    fun queriesOutsideValueRange() {
        val actual = Solution().closestNodes(
            treeOf(4, 2, 6, 1, 3, 5, 7),
            intArrayOf(0, 8)
        )
        assertEquals(2, actual.size)
        assertArrayEquals(intArrayOf(-1, 1), actual[0])
        assertArrayEquals(intArrayOf(7, -1), actual[1])
    }

    @Test
    fun singleNodeTree() {
        val actual = Solution().closestNodes(treeOf(5), intArrayOf(-5, 5, 6))
        assertEquals(3, actual.size)
        assertArrayEquals(intArrayOf(-1, 5), actual[0])
        assertArrayEquals(intArrayOf(5, 5), actual[1])
        assertArrayEquals(intArrayOf(5, -1), actual[2])
    }

    @Test
    fun emptyQueries() {
        assertEquals(0, Solution().closestNodes(treeOf(1), intArrayOf()).size)
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = java.util.ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (i < values.size) {
        val node = queue.removeFirst()
        if (i < values.size && values[i] != null) {
            val left = TreeNode(values[i]!!)
            node.left = left
            queue.add(left)
        }
        ++i
        if (i < values.size && values[i] != null) {
            val right = TreeNode(values[i]!!)
            node.right = right
            queue.add(right)
        }
        ++i
    }
    return root
}
