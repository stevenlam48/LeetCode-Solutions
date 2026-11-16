package correctabinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class CorrectABinaryTreeTest {
    private val solution = Solution()

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
    fun testSimpleInvalidRight() {
        val root = TreeNode(1)
        val left = TreeNode(2)
        val right = TreeNode(3)
        root.left = left
        root.right = right
        left.right = right

        val result = solution.correctBinaryTree(root)
        assertSame(root, result)
        assertNull(root.left)
        assertSame(right, root.right)
        assertEquals(listOf(1, null, 3), levelOrder(root))
    }

    @Test
    fun testDeeperInvalidRight() {
        val root = TreeNode(1)
        val n2 = TreeNode(2)
        val n3 = TreeNode(3)
        val n4 = TreeNode(4)
        val n5 = TreeNode(5)
        val n6 = TreeNode(6)
        val n7 = TreeNode(7)
        root.left = n2
        root.right = n3
        n2.left = n4
        n2.right = n5
        n3.left = n6
        n3.right = n7
        n4.right = n5

        val result = solution.correctBinaryTree(root)
        assertSame(root, result)
        assertNull(n2.left)
        assertSame(n5, n2.right)
        assertEquals(listOf(1, 2, 3, null, 5, 6, 7), levelOrder(root))
    }
}
