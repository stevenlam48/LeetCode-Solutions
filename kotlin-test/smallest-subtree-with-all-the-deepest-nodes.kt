package smallestsubtreewithallthedeepestnodes

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestSubtreeWithAllTheDeepestNodesTest {
    @Test
    fun example1() {
        val root = treeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        assertEquals(listOf(2, 7, 4), levelOrder(Solution().subtreeWithAllDeepest(root)))
    }

    @Test
    fun singleNode() {
        assertEquals(listOf(1), levelOrder(Solution().subtreeWithAllDeepest(treeOf(1))))
    }

    @Test
    fun deepestOnOneSide() {
        assertEquals(listOf(2), levelOrder(Solution().subtreeWithAllDeepest(treeOf(0, 1, 3, null, 2))))
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<Int?>(), levelOrder(Solution().subtreeWithAllDeepest(null)))
    }
}

private fun treeOf(vararg v: Int?): TreeNode? {
    if (v.isEmpty() || v[0] == null) {
        return null
    }
    val root = TreeNode(v[0]!!)
    val q = ArrayDeque<TreeNode>()
    q.addLast(root)
    var i = 1
    while (q.isNotEmpty() && i < v.size) {
        val node = q.removeFirst()
        if (i < v.size) {
            val x = v[i++]
            if (x != null) {
                node.left = TreeNode(x)
                q.addLast(node.left!!)
            }
        }
        if (i < v.size) {
            val x = v[i++]
            if (x != null) {
                node.right = TreeNode(x)
                q.addLast(node.right!!)
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
    q.addLast(root)
    while (q.isNotEmpty()) {
        val node = q.removeFirst()
        if (node == null) {
            result.add(null)
            continue
        }
        result.add(node.`val`)
        q.addLast(node.left)
        q.addLast(node.right)
    }
    while (result.isNotEmpty() && result.last() == null) {
        result.removeAt(result.size - 1)
    }
    return result
}
