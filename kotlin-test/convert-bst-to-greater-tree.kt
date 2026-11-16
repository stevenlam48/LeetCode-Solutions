package convertbsttogreatertree

import common.TreeNode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ConvertBstToGreaterTreeTest {
    @Test
    fun leetCodeExample() {
        val root = treeOf(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8)
        Solution().convertBST(root)
        assertEquals(
            listOf(30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8),
            values(root)
        )
    }

    @Test
    fun simpleBalancedTree() {
        val root = treeOf(2, 1, 3)
        Solution().convertBST(root)
        assertEquals(listOf(5, 6, 3), values(root))
    }

    @Test
    fun rightSkewedTree() {
        val root = treeOf(0, null, 1)
        Solution().convertBST(root)
        assertEquals(listOf(1, null, 1), values(root))
    }

    @Test
    fun nullRoot() {
        assertNull(Solution().convertBST(null))
    }

    private fun treeOf(vararg values: Int?): TreeNode? {
        if (values.isEmpty() || values[0] == null) {
            return null
        }
        val nodes = Array<TreeNode?>(values.size) { i -> values[i]?.let(::TreeNode) }
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

    private fun values(root: TreeNode?): List<Int?> {
        if (root == null) {
            return emptyList()
        }
        val result = mutableListOf<Int?>()
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            result.add(node?.`val`)
            if (node != null) {
                queue.add(node.left)
                queue.add(node.right)
            }
        }
        while (result.isNotEmpty() && result.last() == null) {
            result.removeLast()
        }
        return result
    }
}
