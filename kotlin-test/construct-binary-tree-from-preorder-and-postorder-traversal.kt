package constructbinarytreefrompreorderandpostordertraversal

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructBinaryTreeFromPreorderAndPostorderTraversalTest {
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
        val result = Solution().constructFromPrePost(
            intArrayOf(1, 2, 4, 5, 3, 6, 7),
            intArrayOf(4, 5, 2, 6, 7, 3, 1)
        )
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7), levelOrder(result))
    }

    @Test
    fun testSingleNode() {
        val result = Solution().constructFromPrePost(intArrayOf(1), intArrayOf(1))
        assertEquals(listOf(1), levelOrder(result))
    }

    @Test
    fun testLeftSkewed() {
        val result = Solution().constructFromPrePost(
            intArrayOf(1, 2, 3),
            intArrayOf(3, 2, 1)
        )
        assertEquals(listOf(1, 2, null, 3), levelOrder(result))
    }

    @Test
    fun testRootWithTwoChildren() {
        val result = Solution().constructFromPrePost(
            intArrayOf(1, 2, 3),
            intArrayOf(2, 3, 1)
        )
        assertEquals(listOf(1, 2, 3), levelOrder(result))
    }
}
