package increasingordersearchtree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class IncreasingOrderSearchTreeTest {
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

    private fun rightChain(root: TreeNode?): List<Int> {
        val result = ArrayList<Int>()
        var node = root
        while (node != null) {
            assertNull(node.left)
            result.add(node.`val`)
            node = node.right
        }
        return result
    }

    @Test
    fun example() {
        val root = treeOf(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9)
        assertEquals((1..9).toList(), rightChain(Solution().increasingBST(root)))
    }

    @Test
    fun singleNode() {
        assertEquals(listOf(1), rightChain(Solution().increasingBST(treeOf(1))))
    }

    @Test
    fun smallTree() {
        assertEquals(listOf(1, 2, 3), rightChain(Solution().increasingBST(treeOf(2, 1, 3))))
    }

    @Test
    fun leftSkewed() {
        assertEquals(listOf(1, 2, 3), rightChain(Solution().increasingBST(treeOf(3, 2, null, 1))))
    }
}
