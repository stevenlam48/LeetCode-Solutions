package distributecoinsinbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistributeCoinsInBinaryTreeTest {
    private val solution = Solution()

    @Test
    fun excessCoinsAtRoot() {
        assertEquals(2, solution.distributeCoins(treeOf(3, 0, 0)))
    }

    @Test
    fun excessCoinsAtChild() {
        assertEquals(3, solution.distributeCoins(treeOf(0, 3, 0)))
    }

    @Test
    fun balancedTreeNeedsNoMoves() {
        assertEquals(0, solution.distributeCoins(treeOf(1, 1, 1)))
    }

    @Test
    fun movesAcrossRoot() {
        assertEquals(2, solution.distributeCoins(treeOf(1, 0, 2)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val nodes = values.map { it?.let(::TreeNode) }
    for (i in nodes.indices) {
        val node = nodes[i] ?: continue
        if (2 * i + 1 < nodes.size) {
            node.left = nodes[2 * i + 1]
        }
        if (2 * i + 2 < nodes.size) {
            node.right = nodes[2 * i + 2]
        }
    }
    return nodes[0]
}
