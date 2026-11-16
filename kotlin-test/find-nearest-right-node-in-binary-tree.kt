package findnearestrightnodeinbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class FindNearestRightNodeInBinaryTreeTest {
    private val solution = Solution()

    @Test
    fun rightmostNodeHasNoNeighbor() {
        val root = treeOf(1, 4, 2, 6, 3, 1, 5)
        assertNull(solution.findNeartestRightNode(root, findNode(root, 5)))
    }

    @Test
    fun neighborCanComeFromAnotherParent() {
        val root = treeOf(1, 4, 2, null, null, 3, 7)
        assertEquals(7, solution.findNeartestRightNode(root, findNode(root, 3))?.`val`)
    }

    @Test
    fun absentTargetReturnsNull() {
        val root = treeOf(1, 2, 3)
        assertNull(solution.findNeartestRightNode(root, TreeNode(99)))
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

private fun findNode(root: TreeNode?, value: Int): TreeNode? {
    if (root == null) {
        return null
    }
    if (root.`val` == value) {
        return root
    }
    return findNode(root.left, value) ?: findNode(root.right, value)
}
