package evaluatebooleanbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EvaluateBooleanBinaryTreeTest {
    private val solution = Solution()

    private fun treeOf(vararg v: Int?): TreeNode? {
        if (v.isEmpty() || v[0] == null) {
            return null
        }
        val root = TreeNode(v[0]!!)
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var i = 1
        while (queue.isNotEmpty() && i < v.size) {
            val node = queue.removeFirst()
            if (i < v.size) {
                val left = v[i++]
                if (left != null) {
                    node.left = TreeNode(left)
                    queue.add(node.left!!)
                }
            }
            if (i < v.size) {
                val right = v[i++]
                if (right != null) {
                    node.right = TreeNode(right)
                    queue.add(node.right!!)
                }
            }
        }
        return root
    }

    @Test
    fun testExample1() {
        assertTrue(solution.evaluateTree(treeOf(2, 1, 3, null, null, 0, 1)))
    }

    @Test
    fun testSingleLeaf() {
        assertFalse(solution.evaluateTree(treeOf(0)))
        assertTrue(solution.evaluateTree(treeOf(1)))
    }

    @Test
    fun testOrOperator() {
        assertFalse(solution.evaluateTree(treeOf(2, 0, 0)))
        assertTrue(solution.evaluateTree(treeOf(2, 0, 1)))
    }

    @Test
    fun testAndOperator() {
        assertFalse(solution.evaluateTree(treeOf(3, 0, 1)))
        assertTrue(solution.evaluateTree(treeOf(3, 1, 1)))
    }

    @Test
    fun testNested() {
        assertTrue(solution.evaluateTree(treeOf(3, 1, 2, null, null, 0, 1)))
        assertFalse(solution.evaluateTree(treeOf(2, 3, 0, 0, 1)))
    }
}
