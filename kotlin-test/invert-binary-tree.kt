package invertbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.LinkedList

class InvertBinaryTreeTest {
    private val solution = Solution()

    private fun treeOf(vararg v: Int?): TreeNode? {
        if (v.isEmpty() || v[0] == null) return null
        val root = TreeNode(v[0]!!)
        val q = LinkedList<TreeNode>()
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

    private fun levelOrder(root: TreeNode?): List<Int?> {
        val result = mutableListOf<Int?>()
        if (root == null) return result
        val q = LinkedList<TreeNode?>()
        q.addLast(root)
        while (q.isNotEmpty()) {
            val node = q.removeFirst()
            if (node == null) {
                result.add(null)
            } else {
                result.add(node.`val`)
                q.addLast(node.left)
                q.addLast(node.right)
            }
        }
        while (result.isNotEmpty() && result[result.size - 1] == null) {
            result.removeAt(result.size - 1)
        }
        return result
    }

    @Test
    fun testExample1() {
        val root = treeOf(4, 2, 7, 1, 3, 6, 9)
        assertEquals(listOf(4, 7, 2, 9, 6, 3, 1), levelOrder(solution.invertTree(root)))
    }

    @Test
    fun testExample2() {
        val root = treeOf(2, 1, 3)
        assertEquals(listOf(2, 3, 1), levelOrder(solution.invertTree(root)))
    }

    @Test
    fun testEmptyTree() {
        assertNull(solution.invertTree(null))
    }

    @Test
    fun testSingleNode() {
        val root = treeOf(1)
        assertEquals(listOf(1), levelOrder(solution.invertTree(root)))
    }

    @Test
    fun testUnbalancedTree() {
        val root = treeOf(1, 2, null, 3)
        assertEquals(listOf(1, null, 2, null, 3), levelOrder(solution.invertTree(root)))
    }
}
