package recoverbinarysearchtree

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RecoverBinarySearchTreeTest {
    private val solution = Solution()

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
            if (i < v.size) {
                val l = v[i++]
                if (l != null) {
                    node.left = TreeNode(l)
                    q.add(node.left!!)
                }
            }
            if (i < v.size) {
                val r = v[i++]
                if (r != null) {
                    node.right = TreeNode(r)
                    q.add(node.right!!)
                }
            }
        }
        return root
    }

    private fun levelOrder(root: TreeNode?): List<Int?> {
        val result = ArrayList<Int?>()
        if (root == null) {
            return result
        }
        val q = ArrayDeque<TreeNode?>()
        q.add(root)
        while (q.isNotEmpty()) {
            val node = q.removeFirst()
            if (node == null) {
                result.add(null)
                continue
            }
            result.add(node.`val`)
            q.add(node.left)
            q.add(node.right)
        }
        while (result.isNotEmpty() && result.last() == null) {
            result.removeAt(result.size - 1)
        }
        return result
    }

    private fun inorder(root: TreeNode?, out: MutableList<Int>) {
        if (root == null) {
            return
        }
        inorder(root.left, out)
        out.add(root.`val`)
        inorder(root.right, out)
    }

    private fun assertRecovered(expected: List<Int?>, vararg input: Int?) {
        val root = treeOf(*input)
        solution.recoverTree(root)
        assertEquals(expected, levelOrder(root))
        val values = ArrayList<Int>()
        inorder(root, values)
        assertEquals(values.sorted(), values)
    }

    @Test
    fun testExample1() {
        assertRecovered(listOf(3, 1, null, null, 2), 1, 3, null, null, 2)
    }

    @Test
    fun testExample2() {
        assertRecovered(listOf(2, 1, 4, null, null, 3), 3, 1, 4, null, null, 2)
    }

    @Test
    fun testAdjacentSwap() {
        assertRecovered(listOf(2, 1, 3), 2, 3, 1)
    }

    @Test
    fun testTwoNodeSwap() {
        assertRecovered(listOf(2, 1), 1, 2)
    }

    @Test
    fun testDeepLeftInversions() {
        assertRecovered(listOf(4, 3, null, 2, null, 1), 4, 1, null, 2, null, 3)
    }
}
