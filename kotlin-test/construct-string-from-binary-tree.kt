package constructstringfrombinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructStringFromBinaryTreeTest {
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

    @Test
    fun testExample1() {
        assertEquals("1(2(4))(3)", Solution().tree2str(treeOf(1, 2, 3, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals("1(2()(4))(3)", Solution().tree2str(treeOf(1, 2, 3, null, 4)))
    }

    @Test
    fun testSingleNode() {
        assertEquals("1", Solution().tree2str(treeOf(1)))
    }

    @Test
    fun testEmpty() {
        assertEquals("", Solution().tree2str(null))
    }

    @Test
    fun testLeftOnly() {
        assertEquals("1(2)", Solution().tree2str(treeOf(1, 2)))
    }
}
