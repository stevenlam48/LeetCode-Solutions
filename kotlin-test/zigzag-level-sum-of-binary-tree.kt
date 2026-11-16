package zigzaglevelsumofbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ZigzagLevelSumOfBinaryTreeTest {
    @Test
    fun emptyTree() {
        assertEquals(emptyList<Long>(), Solution().zigzagLevelSum(null))
    }

    @Test
    fun singleNode() {
        assertEquals(listOf(0L), Solution().zigzagLevelSum(treeOf(1)))
    }

    @Test
    fun rootWithTwoLeaves() {
        assertEquals(listOf(1L, 0L), Solution().zigzagLevelSum(treeOf(1, 2, 3)))
    }

    @Test
    fun fullThreeLevels() {
        assertEquals(
            listOf(1L, 5L, 0L),
            Solution().zigzagLevelSum(treeOf(1, 2, 3, 4, 5, 6, 7)),
        )
    }

    @Test
    fun rootWithOnlyRightChild() {
        assertEquals(listOf(0L, 0L), Solution().zigzagLevelSum(treeOf(1, null, 3)))
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
