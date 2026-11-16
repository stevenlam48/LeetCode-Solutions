package kthlargestsuminabinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthLargestSumInABinaryTreeTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(13, solution.kthLargestLevelSum(treeOf(5, 8, 9, 2, 1, 3, 7, 4, 6), 2))
    }

    @Test
    fun example2() {
        assertEquals(3, solution.kthLargestLevelSum(treeOf(1, 2, null, 3), 1))
    }

    @Test
    fun singleNode() {
        assertEquals(1, solution.kthLargestLevelSum(treeOf(1), 1))
    }

    @Test
    fun notEnoughLevels() {
        assertEquals(-1, solution.kthLargestLevelSum(treeOf(1), 2))
    }

    @Test
    fun twoLevels() {
        assertEquals(1, solution.kthLargestLevelSum(treeOf(1, 2, 3), 2))
    }

    @Test
    fun fullTree() {
        assertEquals(22, solution.kthLargestLevelSum(treeOf(1, 2, 3, 4, 5, 6, 7), 1))
    }
}

private fun treeOf(vararg v: Int?): TreeNode? {
    if (v.isEmpty() || v[0] == null) {
        return null
    }
    val root = TreeNode(v[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    var i = 1
    while (queue.isNotEmpty() && i < v.size) {
        val node = queue.removeFirst()
        if (i < v.size) {
            val leftValue = v[i++]
            if (leftValue != null) {
                node.left = TreeNode(leftValue)
                queue.addLast(node.left!!)
            }
        }
        if (i < v.size) {
            val rightValue = v[i++]
            if (rightValue != null) {
                node.right = TreeNode(rightValue)
                queue.addLast(node.right!!)
            }
        }
    }
    return root
}
