package minimumoperationstostabilizeabinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToStabilizeABinaryTreeTest {
    @Test
    fun singleNodeNeedsNoOperations() {
        assertEquals(0L, Solution().stabilizeBinaryTree(treeOf(5)))
    }

    @Test
    fun adjacentValuesAlreadyFormAStableEdge() {
        assertEquals(0L, Solution().stabilizeBinaryTree(treeOf(1, 2)))
    }

    @Test
    fun increasingChildByTwoNeedsOneOperation() {
        assertEquals(1L, Solution().stabilizeBinaryTree(treeOf(1, 3)))
    }

    @Test
    fun decreasingChildByTwoNeedsOneOperation() {
        assertEquals(1L, Solution().stabilizeBinaryTree(treeOf(3, 1)))
    }

    @Test
    fun movingRootCanStabilizeBothEdges() {
        assertEquals(1L, Solution().stabilizeBinaryTree(treeOf(1, 3, 3)))
    }

    @Test
    fun asymmetricChildrenAddBothEdgeCosts() {
        assertEquals(17L, Solution().stabilizeBinaryTree(treeOf(10, 1, 20)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    var i = 1
    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.removeFirst()
        values[i]?.let {
            val child = TreeNode(it)
            node.left = child
            queue.addLast(child)
        }
        ++i
        if (i < values.size) {
            values[i]?.let {
                val child = TreeNode(it)
                node.right = child
                queue.addLast(child)
            }
            ++i
        }
    }
    return root
}
