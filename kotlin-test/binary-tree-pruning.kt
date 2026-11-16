package binarytreepruning

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class BinaryTreePruningTest {
    @Test
    fun prunesZeroOnlyLeftSubtree() {
        val root = treeOf(1, null, 0, 0, 1)
        assertEquals(listOf(1, null, 0, null, 1), levelOrder(Solution().pruneTree(root)))
    }

    @Test
    fun prunesBothBranches() {
        val root = treeOf(1, 0, 1, 0, 0, 0, 1)
        assertEquals(listOf(1, null, 1, null, 1), levelOrder(Solution().pruneTree(root)))
    }

    @Test
    fun removesEntireZeroTree() {
        assertNull(Solution().pruneTree(treeOf(0, 0, 0)))
    }

    @Test
    fun leavesTreeContainingOnesUnchanged() {
        val root = treeOf(1, 0, 1, 1)
        assertEquals(listOf(1, 0, 1, 1), levelOrder(Solution().pruneTree(root)))
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
        values[i++]?.let {
            val child = TreeNode(it)
            node.left = child
            queue.add(child)
        }
        if (i < values.size) {
            values[i++]?.let {
                val child = TreeNode(it)
                node.right = child
                queue.add(child)
            }
        }
    }
    return root
}

private fun levelOrder(root: TreeNode?): List<Int?> {
    if (root == null) return emptyList()
    val result = mutableListOf<Int?>()
    val queue = mutableListOf<TreeNode?>()
    queue.add(root)
    var i = 0
    while (i < queue.size) {
        val node = queue[i++]
        result.add(node?.`val`)
        if (node != null) {
            queue.add(node.left)
            queue.add(node.right)
        }
    }
    while (result.lastOrNull() == null) result.removeAt(result.lastIndex)
    return result
}
