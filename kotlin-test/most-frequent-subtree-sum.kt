package mostfrequentsubtreesum

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MostFrequentSubtreeSumTest {
    private val solution = Solution()

    @Test
    fun findsAllSumsWithMaximumFrequency() {
        val result = solution.findFrequentTreeSum(treeOf(5, 2, -3))
        assertEquals(3, result.size)
        assertEquals(setOf(2, -3, 4), result.toSet())
    }

    @Test
    fun findsSingleMostFrequentSum() {
        assertArrayEquals(intArrayOf(2), solution.findFrequentTreeSum(treeOf(5, 2, -5)))
    }

    @Test
    fun handlesEmptyTree() {
        assertTrue(solution.findFrequentTreeSum(null).isEmpty())
    }

    @Test
    fun handlesSingleNegativeNode() {
        assertArrayEquals(intArrayOf(-7), solution.findFrequentTreeSum(treeOf(-7)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = java.util.ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.remove()
        if (i < values.size && values[i] != null) {
            val left = TreeNode(values[i]!!)
            node.left = left
            queue.add(left)
        }
        i++
        if (i < values.size && values[i] != null) {
            val right = TreeNode(values[i]!!)
            node.right = right
            queue.add(right)
        }
        i++
    }
    return root
}
