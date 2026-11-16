package minDepth

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinDepthTest {
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

    @Test
    fun example1() {
        assertEquals(2, Solution().minDepth(treeOf(3, 9, 20, null, null, 15, 7)))
    }

    @Test
    fun onlyLeftChain() {
        assertEquals(5, Solution().minDepth(treeOf(2, null, 3, null, 4, null, 5, null, 6)))
    }

    @Test
    fun emptyTree() {
        assertEquals(0, Solution().minDepth(null))
    }

    @Test
    fun singleNode() {
        assertEquals(1, Solution().minDepth(treeOf(1)))
    }
}
