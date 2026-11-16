package createbinarytreefromdescriptions

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class CreateBinaryTreeFromDescriptionsTest {
    @Test
    fun `creates the example tree whose root appears later`() {
        val descriptions = arrayOf(
            intArrayOf(20, 15, 1), intArrayOf(20, 17, 0), intArrayOf(50, 20, 1),
            intArrayOf(50, 80, 0), intArrayOf(80, 19, 1)
        )
        assertEquals(listOf(50, 20, 80, 15, 17, 19), levelOrder(Solution().createBinaryTree(descriptions)))
    }

    @Test
    fun `creates a chain with missing children`() {
        val descriptions = arrayOf(intArrayOf(1, 2, 1), intArrayOf(2, 3, 0), intArrayOf(3, 4, 1))
        assertEquals(listOf(1, 2, null, null, 3, 4), levelOrder(Solution().createBinaryTree(descriptions)))
    }

    @Test
    fun `reuses a node before its own description appears`() {
        val descriptions = arrayOf(intArrayOf(20, 15, 1), intArrayOf(50, 20, 1))
        assertEquals(listOf(50, 20, null, 15), levelOrder(Solution().createBinaryTree(descriptions)))
    }

    @Test
    fun `empty descriptions have no root`() {
        assertNull(Solution().createBinaryTree(emptyArray()))
    }
}

private fun levelOrder(root: TreeNode?): List<Int?> {
    if (root == null) {
        return emptyList()
    }
    val result = mutableListOf<Int?>()
    val queue = ArrayDeque<TreeNode?>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        result.add(node?.`val`)
        if (node != null) {
            queue.add(node.left)
            queue.add(node.right)
        }
    }
    while (result.lastOrNull() == null) {
        result.removeAt(result.lastIndex)
    }
    return result
}
