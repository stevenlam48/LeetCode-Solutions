package flipbinarytreetomatchpreordertraversal

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FlipBinaryTreeToMatchPreorderTraversalTest {
    @Test
    fun impossible() {
        assertEquals(listOf(-1), Solution().flipMatchVoyage(treeOf(1, 2), intArrayOf(2, 1)))
    }

    @Test
    fun flipAtRoot() {
        assertEquals(listOf(1), Solution().flipMatchVoyage(treeOf(1, 2, 3), intArrayOf(1, 3, 2)))
    }

    @Test
    fun alreadyMatches() {
        assertEquals(emptyList<Int>(), Solution().flipMatchVoyage(treeOf(1, 2, 3), intArrayOf(1, 2, 3)))
    }

    @Test
    fun flipAtInnerNode() {
        val root = treeOf(1, 2, 3, 4, 5, 6, 7)
        assertEquals(listOf(2), Solution().flipMatchVoyage(root, intArrayOf(1, 2, 5, 4, 3, 6, 7)))
    }

    @Test
    fun flipAtRootAndInnerNode() {
        val root = treeOf(1, 2, 3, 4, 5)
        assertEquals(listOf(1, 2), Solution().flipMatchVoyage(root, intArrayOf(1, 3, 2, 5, 4)))
    }

    @Test
    fun singleNode() {
        assertEquals(emptyList<Int>(), Solution().flipMatchVoyage(treeOf(1), intArrayOf(1)))
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
                val l = v[i++]
                if (l != null) {
                    node.left = TreeNode(l)
                    queue.addLast(node.left!!)
                }
            }
            if (i < v.size) {
                val r = v[i++]
                if (r != null) {
                    node.right = TreeNode(r)
                    queue.addLast(node.right!!)
                }
            }
        }
        return root
    }
}
