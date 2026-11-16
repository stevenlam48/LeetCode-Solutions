package finddistanceinabinarytree

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindDistanceInABinaryTreeTest {
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
                val l = v[i++]
                if (l != null) {
                    node.left = TreeNode(l)
                    q.addLast(node.left!!)
                }
            }
            if (i < v.size) {
                val r = v[i++]
                if (r != null) {
                    node.right = TreeNode(r)
                    q.addLast(node.right!!)
                }
            }
        }
        return root
    }

    @Test
    fun standardExample() {
        val root = treeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        assertEquals(3, Solution().findDistance(root, 5, 0))
    }

    @Test
    fun ancestorAndDescendant() {
        val root = treeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        assertEquals(2, Solution().findDistance(root, 5, 7))
    }

    @Test
    fun smallTree() {
        val root = treeOf(1, 2, 3)
        assertEquals(2, Solution().findDistance(root, 2, 3))
    }

    @Test
    fun sameNode() {
        val root = treeOf(1, 2)
        assertEquals(0, Solution().findDistance(root, 1, 1))
    }

    @Test
    fun siblings() {
        val root = treeOf(1, 2, 3)
        assertEquals(2, Solution().findDistance(root, 2, 3))
    }
}
