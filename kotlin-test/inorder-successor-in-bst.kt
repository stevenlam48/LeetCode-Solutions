package inordersuccessorinbst

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class InorderSuccessorInBstTest {
    @Test
    fun findsSuccessorInRightSubtree() {
        val root = treeOf(2, 1, 4, null, null, 3, 5)
        assertEquals(3, Solution().inorderSuccessor(root, find(root, 2))?.`val`)
    }

    @Test
    fun findsSuccessorAmongAncestors() {
        val root = treeOf(20, 8, 22, 4, 12, null, null, null, null, 10, 14)
        assertEquals(12, Solution().inorderSuccessor(root, find(root, 10))?.`val`)
        assertEquals(20, Solution().inorderSuccessor(root, find(root, 14))?.`val`)
    }

    @Test
    fun returnsNullForMaximum() {
        val root = treeOf(2, 1, 3)
        assertNull(Solution().inorderSuccessor(root, find(root, 3)))
    }
}

private fun find(root: TreeNode?, value: Int): TreeNode? {
    if (root == null) return null
    if (root.`val` == value) return root
    return find(root.left, value) ?: find(root.right, value)
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
