package maximumdistinctpathsuminabinarytree
// Time:  O(n^2)
// Space: O(n)

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDistinctPathSumInABinaryTreeTest {
    private val solution = Solution()

    @Test
    fun singleNegativeNode() {
        assertEquals(-7, solution.maxSum(treeOf(-7)))
    }

    @Test
    fun pathCanPassThroughRoot() {
        assertEquals(6, solution.maxSum(treeOf(1, 2, 3)))
    }

    @Test
    fun duplicateValuesLimitPath() {
        assertEquals(3, solution.maxSum(treeOf(1, 2, 2)))
    }

    @Test
    fun choosesLongerDistinctBranch() {
        assertEquals(11, solution.maxSum(treeOf(4, 2, 2, 5, null)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    var index = 1
    while (queue.isNotEmpty() && index < values.size) {
        val node = queue.removeFirst()
        if (index < values.size) {
            values[index]?.let {
                val child = TreeNode(it)
                node.left = child
                queue.addLast(child)
            }
            ++index
        }
        if (index < values.size) {
            values[index]?.let {
                val child = TreeNode(it)
                node.right = child
                queue.addLast(child)
            }
            ++index
        }
    }
    return root
}
