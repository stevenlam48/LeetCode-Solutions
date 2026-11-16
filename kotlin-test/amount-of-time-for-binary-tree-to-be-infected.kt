package amountoftimeforbinarytreetobeinfected

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AmountOfTimeForBinaryTreeToBeInfectedTest {
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
        val root = treeOf(1, 5, 3, null, 4, 10, 6, 9, 2)
        assertEquals(4, Solution().amountOfTime(root, 3))
    }

    @Test
    fun testSingleNode() {
        assertEquals(0, Solution().amountOfTime(TreeNode(1), 1))
    }

    @Test
    fun testLine() {
        val root = treeOf(1, 2, null, 3)
        assertEquals(2, Solution().amountOfTime(root, 1))
        assertEquals(2, Solution().amountOfTime(root, 3))
        assertEquals(1, Solution().amountOfTime(root, 2))
    }

    @Test
    fun testStartAtLeaf() {
        val root = treeOf(1, 2, 3)
        assertEquals(2, Solution().amountOfTime(root, 2))
    }
}
