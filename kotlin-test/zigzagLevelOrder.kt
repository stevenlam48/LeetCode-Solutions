package zigzagLevelOrder

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ZigzagLevelOrderTest {
    @Test
    fun example1() {
        assertEquals(
            listOf(listOf(3), listOf(20, 9), listOf(15, 7)),
            Solution().zigzagLevelOrder(treeOf(3, 9, 20, null, null, 15, 7)),
        )
    }

    @Test
    fun singleNode() {
        assertEquals(listOf(listOf(1)), Solution().zigzagLevelOrder(treeOf(1)))
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<List<Int>>(), Solution().zigzagLevelOrder(null))
    }

    @Test
    fun leftSkewed() {
        assertEquals(
            listOf(listOf(1), listOf(2), listOf(3)),
            Solution().zigzagLevelOrder(treeOf(1, 2, null, 3)),
        )
    }

    @Test
    fun fullThreeLevels() {
        assertEquals(
            listOf(listOf(1), listOf(3, 2), listOf(4, 5, 6, 7)),
            Solution().zigzagLevelOrder(treeOf(1, 2, 3, 4, 5, 6, 7)),
        )
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
                val left = v[i++]
                if (left != null) {
                    node.left = TreeNode(left)
                    queue.addLast(node.left!!)
                }
            }
            if (i < v.size) {
                val right = v[i++]
                if (right != null) {
                    node.right = TreeNode(right)
                    queue.addLast(node.right!!)
                }
            }
        }
        return root
    }
}
