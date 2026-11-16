package maxPathSum

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxPathSumTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(6, solution.maxPathSum(treeOf(1, 2, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(42, solution.maxPathSum(treeOf(-10, 9, 20, null, null, 15, 7)))
    }

    @Test
    fun testSingleNegative() {
        assertEquals(-3, solution.maxPathSum(treeOf(-3)))
    }

    @Test
    fun testNegativeRootWithPositiveChild() {
        assertEquals(2, solution.maxPathSum(treeOf(2, -1)))
    }
}

private fun treeOf(vararg v: Int?): TreeNode? {
    if (v.isEmpty() || v[0] == null) return null
    val root = TreeNode(v[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    var i = 1
    while (queue.isNotEmpty() && i < v.size) {
        val node = queue.removeFirst()
        if (i < v.size) {
            val left = v[i++]
            if (left != null) {
                node.left = TreeNode(left)
                queue.addLast(node.left!!)
            }
        }
        if (i < v.size) {
            val right = v[i++]
            if (right != null) {
                node.right = TreeNode(right)
                queue.addLast(node.right!!)
            }
        }
    }
    return root
}
