package heightofspecialbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HeightOfSpecialBinaryTreeTest {
    @Test
    fun singleNodeHasHeightZero() {
        assertEquals(0, Solution().heightOfTree(TreeNode(1)))
    }

    @Test
    fun standardExampleWithLinkedLeaves() {
        val root = TreeNode(1)
        val left = TreeNode(2)
        val right = TreeNode(3)
        val leaf = TreeNode(4)
        root.left = left
        root.right = right
        left.right = leaf
        leaf.right = right
        right.left = leaf

        assertEquals(2, Solution().heightOfTree(root))
    }

    @Test
    fun siblingLeafLinksAreNotCountedAsDepth() {
        val root = TreeNode(1)
        val left = TreeNode(2)
        val right = TreeNode(3)
        root.left = left
        root.right = right
        left.right = right
        right.left = left

        assertEquals(1, Solution().heightOfTree(root))
    }

    @Test
    fun skewedTree() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.left!!.left = TreeNode(3)
        root.left!!.left!!.left = TreeNode(4)

        assertEquals(3, Solution().heightOfTree(root))
    }

    @Test
    fun emptyTree() {
        assertEquals(-1, Solution().heightOfTree(null))
    }
}
