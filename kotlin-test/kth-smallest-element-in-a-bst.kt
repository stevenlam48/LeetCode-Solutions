package kthsmallestelementinabst

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthSmallestElementInABstTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(1, solution.kthSmallest(treeOf(3, 1, 4, null, 2), 1))
    }

    @Test
    fun example2() {
        assertEquals(3, solution.kthSmallest(treeOf(5, 3, 6, 2, 4, null, null, 1), 3))
    }

    @Test
    fun singleNode() {
        assertEquals(1, solution.kthSmallest(treeOf(1), 1))
    }

    @Test
    fun balancedTree() {
        assertEquals(2, solution.kthSmallest(treeOf(2, 1, 3), 2))
    }

    @Test
    fun thirdSmallest() {
        assertEquals(3, solution.kthSmallest(treeOf(3, 1, 4, null, 2), 3))
    }

    @Test
    fun largestElement() {
        assertEquals(4, solution.kthSmallest(treeOf(3, 1, 4, null, 2), 4))
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
