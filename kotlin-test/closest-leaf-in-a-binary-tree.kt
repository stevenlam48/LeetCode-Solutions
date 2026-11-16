package closestleafinabinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ClosestLeafInABinaryTreeTest {
    @Test
    fun singleNodeIsItsOwnClosestLeaf() {
        assertEquals(1, Solution().findClosestLeaf(treeOf(1), 1))
    }

    @Test
    fun equalDistanceLeavesFollowBreadthFirstOrder() {
        assertEquals(3, Solution().findClosestLeaf(treeOf(1, 3, 2), 1))
    }

    @Test
    fun targetIsInternalNode() {
        val root = treeOf(1, 2, 3, 4, null, null, null, 5, null, 6)
        assertEquals(3, Solution().findClosestLeaf(root, 2))
    }

    @Test
    fun closestLeafCanBeBelowTarget() {
        val root = treeOf(1, 2, 3, 4, null, null, null, 5, null, 6)
        assertEquals(6, Solution().findClosestLeaf(root, 4))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = java.util.ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (i < values.size) {
        val node = queue.removeFirst()
        if (i < values.size && values[i] != null) {
            val left = TreeNode(values[i]!!)
            node.left = left
            queue.add(left)
        }
        ++i
        if (i < values.size && values[i] != null) {
            val right = TreeNode(values[i]!!)
            node.right = right
            queue.add(right)
        }
        ++i
    }
    return root
}
