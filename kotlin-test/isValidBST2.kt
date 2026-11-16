package isValidBST2

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.ArrayDeque

class IsValidBST2Test {
    private val solution = Solution()

    private fun treeOf(vararg v: Int?): TreeNode? {
        if (v.isEmpty() || v[0] == null) return null
        val root = TreeNode(v[0]!!)
        val q = ArrayDeque<TreeNode>()
        q.addLast(root)
        var i = 1
        while (q.isNotEmpty() && i < v.size) {
            val node = q.removeFirst()
            if (i < v.size) {
                val value = v[i++]
                if (value != null) {
                    node.left = TreeNode(value)
                    q.addLast(node.left!!)
                }
            }
            if (i < v.size) {
                val value = v[i++]
                if (value != null) {
                    node.right = TreeNode(value)
                    q.addLast(node.right!!)
                }
            }
        }
        return root
    }

    @Test
    fun testExample1() {
        assertTrue(solution.isValidBST(treeOf(2, 1, 3)))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.isValidBST(treeOf(5, 1, 4, null, null, 3, 6)))
    }

    @Test
    fun testEmptyTree() {
        assertTrue(solution.isValidBST(null))
    }

    @Test
    fun testSingleNode() {
        assertTrue(solution.isValidBST(treeOf(1)))
    }

    @Test
    fun testDuplicateValue() {
        assertFalse(solution.isValidBST(treeOf(1, 1)))
    }

    @Test
    fun testDeepViolation() {
        assertFalse(solution.isValidBST(treeOf(10, 5, 15, null, null, 6, 20)))
    }
}
