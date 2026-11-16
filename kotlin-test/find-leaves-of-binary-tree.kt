package findleavesofbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindLeavesOfBinaryTreeTest {
    private fun assertLevels(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun groupsNodesByLeafRemovalRound() {
        assertLevels(
            arrayOf(intArrayOf(4, 5, 3), intArrayOf(2), intArrayOf(1)),
            Solution().findLeaves(treeOf(1, 2, 3, 4, 5))
        )
    }

    @Test
    fun handlesSkewedTree() {
        assertLevels(
            arrayOf(intArrayOf(3), intArrayOf(2), intArrayOf(1)),
            Solution().findLeaves(treeOf(1, 2, null, 3))
        )
    }

    @Test
    fun handlesEmptyAndSingleNodeTrees() {
        assertLevels(arrayOf(), Solution().findLeaves(null))
        assertLevels(arrayOf(intArrayOf(1)), Solution().findLeaves(treeOf(1)))
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
