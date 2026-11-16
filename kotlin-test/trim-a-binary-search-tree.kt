package trimabinarysearchtree

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

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

private fun levelOrder(root: TreeNode?): List<Int?> {
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
        result.removeAt(result.lastIndex)
    }
    return result
}

class TrimABinarySearchTreeTest {
    @Test
    fun standardExamples() {
        assertEquals(listOf(1, null, 2), levelOrder(Solution().trimBST(treeOf(1, 0, 2), 1, 2)))
        assertEquals(listOf(3, 2, null, 1), levelOrder(Solution().trimBST(treeOf(3, 0, 4, null, 2, null, null, 1), 1, 3)))
    }

    @Test
    fun wholeTreeInsideOrOutsideRange() {
        assertEquals(listOf(1, 2, 3), levelOrder(Solution().trimBST(treeOf(1, 2, 3), 0, 4)))
        assertEquals(emptyList<Int?>(), levelOrder(Solution().trimBST(treeOf(1, 2, 3), 4, 5)))
    }

    @Test
    fun emptyAndSingleBoundaryTrees() {
        assertNull(Solution().trimBST(null, 0, 1))
        assertEquals(listOf(2), levelOrder(Solution().trimBST(treeOf(2), 2, 2)))
    }
}
