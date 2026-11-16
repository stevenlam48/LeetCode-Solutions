package maximumlevelsumofabinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumLevelSumOfABinaryTreeTest {
    private val solution = Solution()

    @Test
    fun `finds the level with the greatest sum`() {
        assertEquals(2, solution.maxLevelSum(treeOf(1, 7, 0, 7, -8, null, null)))
    }

    @Test
    fun `handles negative level sums`() {
        assertEquals(3, solution.maxLevelSum(treeOf(-100, -200, -300, -20, -5, -10, null)))
    }

    @Test
    fun `returns the smallest level on a tie`() {
        assertEquals(1, solution.maxLevelSum(treeOf(2, 1, 1)))
    }

    @Test
    fun `handles a single negative node`() {
        assertEquals(1, solution.maxLevelSum(treeOf(-1)))
    }

    private fun treeOf(vararg values: Int?): TreeNode? {
        if (values.isEmpty() || values[0] == null) {
            return null
        }
        val nodes = Array<TreeNode?>(values.size) { index -> values[index]?.let { TreeNode(it) } }
        var child = 1
        for (i in nodes.indices) {
            val node = nodes[i] ?: continue
            if (child < nodes.size) {
                node.left = nodes[child++]
            }
            if (child < nodes.size) {
                node.right = nodes[child++]
            }
        }
        return nodes[0]
    }
}
