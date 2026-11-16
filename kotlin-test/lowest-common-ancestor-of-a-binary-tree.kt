package lowestcommonancestorofabinarytree

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LowestCommonAncestorOfABinaryTreeTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        val root = treeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val result = solution.lowestCommonAncestor(root, find(root, 5)!!, find(root, 1)!!)
        assertEquals(3, result?.`val`)
    }

    @Test
    fun testExampleTwo() {
        val root = treeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val result = solution.lowestCommonAncestor(root, find(root, 5)!!, find(root, 4)!!)
        assertEquals(5, result?.`val`)
    }

    @Test
    fun testSameNode() {
        val root = treeOf(1, 2)
        val node = find(root, 2)!!
        val result = solution.lowestCommonAncestor(root, node, node)
        assertEquals(2, result?.`val`)
    }

    @Test
    fun testRootAsAncestor() {
        val root = treeOf(1, 2, 3)
        val result = solution.lowestCommonAncestor(root, find(root, 2)!!, find(root, 3)!!)
        assertEquals(1, result?.`val`)
    }

    @Test
    fun testDeepAncestor() {
        val root = treeOf(1, 2, null, 3, null, 4, null, 5)
        val result = solution.lowestCommonAncestor(root, find(root, 4)!!, find(root, 5)!!)
        assertEquals(4, result?.`val`)
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
                if (v[i] != null) {
                    node.left = TreeNode(v[i]!!)
                    queue.addLast(node.left!!)
                }
                ++i
            }
            if (i < v.size) {
                if (v[i] != null) {
                    node.right = TreeNode(v[i]!!)
                    queue.addLast(node.right!!)
                }
                ++i
            }
        }
        return root
    }

    private fun find(node: TreeNode?, value: Int): TreeNode? {
        if (node == null) {
            return null
        }
        if (node.`val` == value) {
            return node
        }
        return find(node.left, value) ?: find(node.right, value)
    }
}
