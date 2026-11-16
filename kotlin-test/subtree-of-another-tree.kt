package subtreeofanothertree

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val nodes = arrayOfNulls<TreeNode>(values.size)
    nodes[0] = root
    for (i in values.indices) {
        val node = nodes[i] ?: continue
        val left = 2 * i + 1
        val right = 2 * i + 2
        if (left < values.size && values[left] != null) {
            node.left = TreeNode(values[left]!!)
            nodes[left] = node.left
        }
        if (right < values.size && values[right] != null) {
            node.right = TreeNode(values[right]!!)
            nodes[right] = node.right
        }
    }
    return root
}

class SubtreeOfAnotherTreeTest {
    @Test
    fun exampleOne() {
        val root = treeOf(3, 4, 5, 1, 2)
        val subRoot = treeOf(4, 1, 2)
        assertTrue(Solution().isSubtree(root, subRoot))
    }

    @Test
    fun exampleTwo() {
        val root = treeOf(3, 4, 5, 1, 2, null, null, null, null, 0)
        val subRoot = treeOf(4, 1, 2)
        assertFalse(Solution().isSubtree(root, subRoot))
    }

    @Test
    fun identicalTrees() {
        assertTrue(Solution().isSubtree(treeOf(1, 2, 3), treeOf(1, 2, 3)))
    }

    @Test
    fun subtreeCanBeLeaf() {
        assertTrue(Solution().isSubtree(treeOf(1, 2, 3), treeOf(3)))
        assertFalse(Solution().isSubtree(treeOf(1, 2, 3), treeOf(4)))
    }
}
