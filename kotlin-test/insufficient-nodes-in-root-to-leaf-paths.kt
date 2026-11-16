package insufficientnodesinroottoleafpaths

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class InsufficientNodesInRootToLeafPathsTest {
    @Test
    fun prunesLeetCodeExample() {
        val root = treeOf(1, 2, 3, 4, -99, -99, 7, 8, 9, -99, -99, 12, 13, -99, 14)
        assertEquals(
            listOf(1, 2, 3, 4, null, null, 7, 8, 9, null, 14),
            levelOrder(Solution().sufficientSubset(root, 1))
        )
    }

    @Test
    fun removesRootWhenEveryPathIsInsufficient() {
        val root = treeOf(1, 2, 3)
        assertNull(Solution().sufficientSubset(root, 100))
        assertNull(Solution().sufficientSubset(null, 1))
    }

    @Test
    fun keepsLeafWhosePathEqualsLimit() {
        val root = treeOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)
        assertEquals(
            listOf(5, 4, 8, 11, null, 13, null, 7, 2),
            levelOrder(Solution().sufficientSubset(root, 22))
        )
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

private fun levelOrder(root: TreeNode?): List<Int?> {
    if (root == null) return emptyList()
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
    while (result.lastOrNull() == null) result.removeAt(result.lastIndex)
    return result
}
