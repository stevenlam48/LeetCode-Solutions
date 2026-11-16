package binarysearchtreetogreatersumtree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinarySearchTreeToGreaterSumTreeTest {
    @Test
    fun example1() {
        val root = treeOf(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8)
        assertEquals(
            listOf(30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8),
            levelOrder(Solution().bstToGst(root)),
        )
    }

    @Test
    fun example2() {
        val root = treeOf(0, null, 1)
        assertEquals(listOf(1, null, 1), levelOrder(Solution().bstToGst(root)))
    }

    @Test
    fun singleNode() {
        assertEquals(listOf(5), levelOrder(Solution().bstToGst(treeOf(5))))
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<Int?>(), levelOrder(Solution().bstToGst(null)))
    }

    @Test
    fun leftOnlyChain() {
        assertEquals(listOf(6, null, 5, null, 3), levelOrder(Solution().bstToGst(treeOf(1, null, 2, null, 3))))
    }
}

private fun treeOf(vararg v: Int?): TreeNode? {
    if (v.isEmpty() || v[0] == null) {
        return null
    }
    val root = TreeNode(v[0]!!)
    val q = ArrayDeque<TreeNode>()
    q.add(root)
    var i = 1
    while (i < v.size && q.isNotEmpty()) {
        val node = q.removeFirst()
        if (i < v.size) {
            val x = v[i++]
            if (x != null) {
                node.left = TreeNode(x)
                q.add(node.left!!)
            }
        }
        if (i < v.size) {
            val x = v[i++]
            if (x != null) {
                node.right = TreeNode(x)
                q.add(node.right!!)
            }
        }
    }
    return root
}

private fun levelOrder(root: TreeNode?): List<Int?> {
    val res = ArrayList<Int?>()
    val q = ArrayDeque<TreeNode?>()
    q.add(root)
    while (q.isNotEmpty()) {
        val node = q.removeFirst()
        if (node == null) {
            res.add(null)
        } else {
            res.add(node.`val`)
            q.add(node.left)
            q.add(node.right)
        }
    }
    while (res.isNotEmpty() && res[res.size - 1] == null) {
        res.removeAt(res.size - 1)
    }
    return res
}
