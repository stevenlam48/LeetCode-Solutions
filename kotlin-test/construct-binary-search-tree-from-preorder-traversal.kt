package constructbinarysearchtreefrompreordertraversal

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ConstructBinarySearchTreeFromPreorderTraversalTest {
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
        val result = Solution().bstFromPreorder(intArrayOf(8, 5, 1, 7, 10, 12))
        assertEquals(listOf(8, 5, 10, 1, 7, null, 12), levelOrder(result))
    }

    @Test
    fun testSingleNode() {
        val result = Solution().bstFromPreorder(intArrayOf(1))
        assertEquals(listOf(1), levelOrder(result))
    }

    @Test
    fun testRightSkewed() {
        val result = Solution().bstFromPreorder(intArrayOf(1, 2, 3, 4))
        assertEquals(listOf(1, null, 2, null, 3, null, 4), levelOrder(result))
    }

    @Test
    fun testLeftSkewed() {
        val result = Solution().bstFromPreorder(intArrayOf(4, 3, 2, 1))
        assertEquals(listOf(4, 3, null, 2, null, 1), levelOrder(result))
    }

    @Test
    fun testEmpty() {
        assertNull(Solution().bstFromPreorder(intArrayOf()))
    }
}
