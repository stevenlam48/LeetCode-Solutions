package findlargestvalueineachtreerow

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindLargestValueInEachTreeRowTest {
    @Test
    fun findsMaximumAtEveryDepth() {
        val root = treeOf(1, 3, 2, 5, 3, null, 9)

        assertArrayEquals(intArrayOf(1, 3, 9), Solution().largestValues(root))
    }

    @Test
    fun handlesNegativeValuesAndSparseRows() {
        val root = treeOf(-5, -10, -3, null, -20, null, null, null, -1)

        assertArrayEquals(intArrayOf(-5, -3, -20, -1), Solution().largestValues(root))
    }

    @Test
    fun handlesEmptyAndSingleNodeTrees() {
        assertArrayEquals(intArrayOf(), Solution().largestValues(null))
        assertArrayEquals(intArrayOf(2), Solution().largestValues(treeOf(2)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val nodes = Array<TreeNode?>(values.size) { index ->
        values[index]?.let { TreeNode(it) }
    }
    nodes[0] = root
    var child = 1
    for (parent in nodes.indices) {
        val node = nodes[parent] ?: continue
        if (child < values.size) {
            node.left = nodes[child++]
        }
        if (child < values.size) {
            node.right = nodes[child++]
        }
    }
    return root
}
