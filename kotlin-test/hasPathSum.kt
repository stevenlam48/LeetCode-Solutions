package hasPathSum

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HasPathSumTest {
    private val solution = Solution()

    @Test
    fun treeContainsRootToLeafPath() {
        val root = treeOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)
        assertTrue(solution.hasPathSum(root, 22))
    }

    @Test
    fun targetRequiresLeaf() {
        val root = treeOf(1, 2, 3)
        assertFalse(solution.hasPathSum(root, 5))
        assertFalse(solution.hasPathSum(root, 1))
    }

    @Test
    fun emptyTree() {
        assertFalse(solution.hasPathSum(null, 0))
    }

    @Test
    fun singleNode() {
        assertTrue(solution.hasPathSum(treeOf(7), 7))
        assertFalse(solution.hasPathSum(treeOf(7), 0))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.removeFirst()
        if (i < values.size && values[i] != null) {
            node.left = TreeNode(values[i]!!)
            queue.add(node.left!!)
        }
        ++i
        if (i < values.size && values[i] != null) {
            node.right = TreeNode(values[i]!!)
            queue.add(node.right!!)
        }
        ++i
    }
    return root
}
