package mergetwobinarytrees

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class MergeTwoBinaryTreesTest {
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
        val result = mutableListOf<Int?>()
        if (root == null) {
            return result
        }
        val q = ArrayDeque<TreeNode?>()
        q.addLast(root)
        while (q.isNotEmpty()) {
            val n = q.removeFirst()
            if (n == null) {
                result.add(null)
                continue
            }
            result.add(n.`val`)
            q.addLast(n.left)
            q.addLast(n.right)
        }
        while (result.isNotEmpty() && result.last() == null) {
            result.removeAt(result.size - 1)
        }
        return result
    }

    @Test
    fun example1() {
        val t1 = treeOf(1, 3, 2, 5)
        val t2 = treeOf(2, 1, 3, null, 4, null, 7)
        assertEquals(listOf(3, 4, 5, 5, 4, null, 7), levelOrder(Solution().mergeTrees(t1, t2)))
    }

    @Test
    fun firstEmpty() {
        val t2 = treeOf(1, 2, 3)
        assertEquals(listOf(1, 2, 3), levelOrder(Solution().mergeTrees(null, t2)))
    }

    @Test
    fun secondEmpty() {
        val t1 = treeOf(1, 2, 3)
        assertEquals(listOf(1, 2, 3), levelOrder(Solution().mergeTrees(t1, null)))
    }

    @Test
    fun bothEmpty() {
        assertNull(Solution().mergeTrees(null, null))
    }

    @Test
    fun singleNodes() {
        assertEquals(listOf(5), levelOrder(Solution().mergeTrees(treeOf(2), treeOf(3))))
    }
}
