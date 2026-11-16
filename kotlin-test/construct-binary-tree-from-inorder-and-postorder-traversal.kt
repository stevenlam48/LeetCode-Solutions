package constructbinarytreefrominorderandpostordertraversal

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ConstructBinaryTreeFromInorderAndPostorderTraversalTest {
    private fun levelOrder(root: TreeNode?): List<Int?> {
        val result = mutableListOf<Int?>()
        if (root == null) return result
        val queue = ArrayDeque<TreeNode?>()
        queue.addLast(root)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (node == null) {
                result.add(null)
            } else {
                result.add(node.`val`)
                queue.addLast(node.left)
                queue.addLast(node.right)
            }
        }
        while (result.isNotEmpty() && result.last() == null) {
            result.removeAt(result.size - 1)
        }
        return result
    }

    @Test
    fun testExample() {
        val result = Solution().buildTree(
            intArrayOf(9, 3, 15, 20, 7),
            intArrayOf(9, 15, 7, 20, 3)
        )
        assertEquals(listOf(3, 9, 20, null, null, 15, 7), levelOrder(result))
    }

    @Test
    fun testSingleNode() {
        val result = Solution().buildTree(intArrayOf(1), intArrayOf(1))
        assertEquals(listOf(1), levelOrder(result))
    }

    @Test
    fun testEmpty() {
        assertNull(Solution().buildTree(intArrayOf(), intArrayOf()))
    }

    @Test
    fun testLeftSkewed() {
        val result = Solution().buildTree(
            intArrayOf(1, 2, 3),
            intArrayOf(3, 2, 1)
        )
        assertEquals(listOf(1, null, 2, null, 3), levelOrder(result))
    }

    @Test
    fun testRightSkewed() {
        val result = Solution().buildTree(
            intArrayOf(1, 2, 3),
            intArrayOf(1, 3, 2)
        )
        assertEquals(listOf(2, 1, 3), levelOrder(result))
    }
}
