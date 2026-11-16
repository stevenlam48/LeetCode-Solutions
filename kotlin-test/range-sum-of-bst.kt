package rangesumofbst

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RangeSumOfBstTest {
    private val solution = Solution()

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
            if (i < v.size && v[i] != null) {
                node.left = TreeNode(v[i]!!)
                queue.addLast(node.left!!)
            }
            ++i
            if (i < v.size && v[i] != null) {
                node.right = TreeNode(v[i]!!)
                queue.addLast(node.right!!)
            }
            ++i
        }
        return root
    }

    @Test
    fun testExample1() {
        val root = treeOf(10, 5, 15, 3, 7, null, 18)
        assertEquals(32, solution.rangeSumBST(root, 7, 15))
    }

    @Test
    fun testExample2() {
        val root = treeOf(10, 5, 15, 3, 7, 13, 18, 1, null, 6)
        assertEquals(23, solution.rangeSumBST(root, 6, 10))
    }

    @Test
    fun testEmptyTree() {
        assertEquals(0, solution.rangeSumBST(null, 1, 10))
    }

    @Test
    fun testSingleNodeInRange() {
        assertEquals(5, solution.rangeSumBST(TreeNode(5), 5, 5))
    }

    @Test
    fun testSingleNodeOutOfRange() {
        assertEquals(0, solution.rangeSumBST(TreeNode(5), 6, 10))
    }
}
