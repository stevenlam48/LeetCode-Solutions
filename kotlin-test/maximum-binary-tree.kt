package maximumbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumBinaryTreeTest {
    @Test
    fun decreasing() {
        assertEquals(
            listOf(3, null, 2, null, 1, null, null),
            preorder(Solution().constructMaximumBinaryTree(intArrayOf(3, 2, 1)))
        )
    }

    @Test
    fun example() {
        assertEquals(
            listOf(6, 3, null, 2, null, 1, null, null, 5, 0, null, null, null),
            preorder(Solution().constructMaximumBinaryTree(intArrayOf(3, 2, 1, 6, 0, 5)))
        )
    }

    @Test
    fun singleElement() {
        assertEquals(
            listOf(1, null, null),
            preorder(Solution().constructMaximumBinaryTree(intArrayOf(1)))
        )
    }
}

private fun preorder(root: TreeNode?): List<Int?> {
    if (root == null) {
        return listOf(null)
    }
    return listOf(root.`val`) + preorder(root.left) + preorder(root.right)
}
