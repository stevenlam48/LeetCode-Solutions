package stepbystepdirectionsfromabinarytreenodetoanother

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StepByStepDirectionsFromABinaryTreeNodeToAnotherTest {
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

    @Test
    fun testExample1() {
        val root = treeOf(5, 1, 2, 3, null, 6, 4)
        assertEquals("UURL", solution.getDirections(root, 3, 6))
    }

    @Test
    fun testExample2() {
        val root = treeOf(2, 1)
        assertEquals("L", solution.getDirections(root, 2, 1))
    }

    @Test
    fun testSameNode() {
        val root = treeOf(1, 2, 3)
        assertEquals("", solution.getDirections(root, 2, 2))
    }

    @Test
    fun testRightChild() {
        val root = treeOf(1, 2, 3)
        assertEquals("R", solution.getDirections(root, 1, 3))
    }

    @Test
    fun testUpAndDown() {
        val root = treeOf(1, 2, 3, 4, 5, 6, 7)
        assertEquals("UURR", solution.getDirections(root, 4, 7))
    }
}
