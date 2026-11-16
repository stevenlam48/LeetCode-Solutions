package symmetrictree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SymmetricTreeTest {
    @Test
    fun symmetricTree() {
        assertTrue(Solution().isSymmetric(treeOf(1, 2, 2, 3, 4, 4, 3)))
    }

    @Test
    fun asymmetricStructure() {
        assertFalse(Solution().isSymmetric(treeOf(1, 2, 2, null, 3, null, 3)))
    }

    @Test
    fun differentValues() {
        assertFalse(Solution().isSymmetric(treeOf(1, 2, 3)))
    }

    @Test
    fun emptyAndSingleNodeTrees() {
        assertTrue(Solution().isSymmetric(null))
        assertTrue(Solution().isSymmetric(treeOf(1)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val nodes = ArrayDeque<TreeNode>()
    nodes.addLast(root)
    var i = 1
    while (i < values.size) {
        val node = nodes.removeFirst()
        if (values[i] != null) {
            node.left = TreeNode(values[i]!!)
            nodes.addLast(node.left!!)
        }
        ++i
        if (i < values.size && values[i] != null) {
            node.right = TreeNode(values[i]!!)
            nodes.addLast(node.right!!)
        }
        ++i
    }
    return root
}
