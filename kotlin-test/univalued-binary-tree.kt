package univaluedbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UnivaluedBinaryTreeTest {
    @Test
    fun allValuesMatch() {
        assertTrue(Solution().isUnivalTree(treeOf(1, 1, 1, 1, 1, null, 1)))
    }

    @Test
    fun oneValueDiffers() {
        assertFalse(Solution().isUnivalTree(treeOf(2, 2, 2, 5, 2)))
    }

    @Test
    fun singleNode() {
        assertTrue(Solution().isUnivalTree(treeOf(7)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.removeFirst()
        values[i++]?.let {
            node.left = TreeNode(it)
            queue.add(node.left!!)
        }
        if (i < values.size) {
            values[i++]?.let {
                node.right = TreeNode(it)
                queue.add(node.right!!)
            }
        }
    }
    return root
}
