package lowestcommonancestorofabinarysearchtree

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LowestCommonAncestorOfABinarySearchTreeTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        val root = treeOf(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)
        val result = solution.lowestCommonAncestor(root, find(root, 2)!!, find(root, 8)!!)
        assertEquals(6, result?.`val`)
    }

    @Test
    fun testExampleTwo() {
        val root = treeOf(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)
        val result = solution.lowestCommonAncestor(root, find(root, 2)!!, find(root, 4)!!)
        assertEquals(2, result?.`val`)
    }

    @Test
    fun testRootIsOneOfNodes() {
        val root = treeOf(2, 1)
        val result = solution.lowestCommonAncestor(root, root!!, find(root, 1)!!)
        assertEquals(2, result?.`val`)
    }

    @Test
    fun testSameNode() {
        val root = treeOf(2, 1, 3)
        val node = find(root, 3)!!
        val result = solution.lowestCommonAncestor(root, node, node)
        assertEquals(3, result?.`val`)
    }

    @Test
    fun testAncestorInLeftSubtree() {
        val root = treeOf(10, 5, 15, 3, 7)
        val result = solution.lowestCommonAncestor(root, find(root, 3)!!, find(root, 7)!!)
        assertEquals(5, result?.`val`)
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
