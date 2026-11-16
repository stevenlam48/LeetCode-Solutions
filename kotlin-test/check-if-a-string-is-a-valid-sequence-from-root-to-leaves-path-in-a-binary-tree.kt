package checkifastringisavalidsequencefromroottoleavespathinabinarytree

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTreeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val root = treeOf(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0)
        assertTrue(solution.isValidSequence(root, intArrayOf(0, 1, 0, 1)))
    }

    @Test
    fun testExample2() {
        val root = treeOf(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0)
        assertFalse(solution.isValidSequence(root, intArrayOf(0, 0, 1)))
    }

    @Test
    fun testExample3() {
        val root = treeOf(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0)
        assertFalse(solution.isValidSequence(root, intArrayOf(0, 1, 1)))
    }

    @Test
    fun testSingleNode() {
        assertTrue(solution.isValidSequence(TreeNode(5), intArrayOf(5)))
        assertFalse(solution.isValidSequence(TreeNode(5), intArrayOf(6)))
    }

    @Test
    fun testPathEndsBeforeLeaf() {
        val root = treeOf(1, 2, 3)
        assertFalse(solution.isValidSequence(root, intArrayOf(1)))
        assertTrue(solution.isValidSequence(root, intArrayOf(1, 2)))
    }

    @Test
    fun testEmptyArray() {
        assertFalse(solution.isValidSequence(TreeNode(1), intArrayOf()))
    }

    private fun treeOf(vararg v: Int?): TreeNode? {
        if (v.isEmpty() || v[0] == null) {
            return null
        }
        val root = TreeNode(v[0]!!)
        val q = ArrayDeque<TreeNode>()
        q.add(root)
        var i = 1
        while (q.isNotEmpty() && i < v.size) {
            val node = q.removeFirst()
            if (i < v.size && v[i] != null) {
                node.left = TreeNode(v[i]!!)
                q.add(node.left!!)
            }
            ++i
            if (i < v.size && v[i] != null) {
                node.right = TreeNode(v[i]!!)
                q.add(node.right!!)
            }
            ++i
        }
        return root
    }
}
