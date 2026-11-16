package convertsortedarraytobinarysearchtree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ConvertSortedArrayToBinarySearchTreeTest {
    private val solution = Solution()

    private fun inorder(node: TreeNode?, out: MutableList<Int>) {
        if (node == null) return
        inorder(node.left, out)
        out.add(node.`val`)
        inorder(node.right, out)
    }

    private fun levelOrder(root: TreeNode?): List<Int?> {
        val result = mutableListOf<Int?>()
        if (root == null) return result
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (node == null) {
                result.add(null)
                continue
            }
            result.add(node.`val`)
            queue.add(node.left)
            queue.add(node.right)
        }
        while (result.isNotEmpty() && result.last() == null) {
            result.removeAt(result.size - 1)
        }
        return result
    }

    @Test
    fun testExample() {
        val nums = intArrayOf(-10, -3, 0, 5, 9)
        val root = solution.sortedArrayToBST(nums)
        assertEquals(listOf(0, -10, 5, null, -3, null, 9), levelOrder(root))
        val values = mutableListOf<Int>()
        inorder(root, values)
        assertEquals(nums.toList(), values)
    }

    @Test
    fun testEmpty() {
        assertNull(solution.sortedArrayToBST(intArrayOf()))
    }

    @Test
    fun testSingle() {
        val root = solution.sortedArrayToBST(intArrayOf(1))
        assertEquals(listOf(1), levelOrder(root))
    }
}
