package averageoflevelsinbinarytree

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AverageOfLevelsInBinaryTreeTest {
    private val solution = Solution()

    @Test
    fun testExample() {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right!!.left = TreeNode(15)
        root.right!!.right = TreeNode(7)
        assertArrayEquals(doubleArrayOf(3.0, 14.5, 11.0), solution.averageOfLevels(root))
    }

    @Test
    fun testSingleNode() {
        assertArrayEquals(doubleArrayOf(5.0), solution.averageOfLevels(TreeNode(5)))
    }

    @Test
    fun testNegativeValues() {
        val root = TreeNode(-1)
        root.left = TreeNode(-2)
        root.right = TreeNode(-3)
        assertArrayEquals(doubleArrayOf(-1.0, -2.5), solution.averageOfLevels(root))
    }

    @Test
    fun testUnbalanced() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.left!!.left = TreeNode(3)
        assertArrayEquals(doubleArrayOf(1.0, 2.0, 3.0), solution.averageOfLevels(root))
    }
}
