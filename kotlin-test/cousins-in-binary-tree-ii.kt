package cousinsinbinarytreeii

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CousinsInBinaryTreeIiTest {
    @Test
    fun `replaces each node with its cousin sum`() {
        val root = Solution().replaceValueInTree(treeOf(5, 4, 9, 1, 10, null, 7)!!)
        assertEquals(listOf(0, 0, 0, 7, 7, 11), levelOrder(root))
    }

    @Test
    fun `clears every level in a three node tree`() {
        val root = Solution().replaceValueInTree(treeOf(3, 1, 2)!!)
        assertEquals(listOf(0, 0, 0), levelOrder(root))
    }

    @Test
    fun `a single node becomes zero`() {
        val root = Solution().replaceValueInTree(TreeNode(1))
        assertEquals(0, root.`val`)
    }

    @Test
    fun `uses sibling sums when the tree is unbalanced`() {
        val root = Solution().replaceValueInTree(treeOf(4, 2, 7, 1, 3, null, 5)!!)
        assertEquals(listOf(0, 0, 0, 5, 5, 4), levelOrder(root))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val nodes = values.map { it?.let(::TreeNode) }
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

private fun levelOrder(root: TreeNode): List<Int> {
    val result = mutableListOf<Int>()
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        result.add(node.`val`)
        node.left?.let(queue::add)
        node.right?.let(queue::add)
    }
    return result
}
