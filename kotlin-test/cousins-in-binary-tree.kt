package cousinsinbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CousinsInBinaryTreeTest {
    @Test
    fun `nodes at different depths are not cousins`() {
        assertFalse(Solution().isCousins(treeOf(1, 2, 3, 4), 4, 3))
    }

    @Test
    fun `same depth nodes with different parents are cousins`() {
        assertTrue(Solution().isCousins(treeOf(1, 2, 3, null, 4, null, 5), 5, 4))
    }

    @Test
    fun `siblings are not cousins`() {
        assertFalse(Solution().isCousins(treeOf(1, 2, 3, null, 4), 2, 3))
    }

    @Test
    fun `a missing value is not a cousin`() {
        assertFalse(Solution().isCousins(treeOf(1, 2), 2, 9))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val nodes = values.map { it?.let(::TreeNode) }
    for (i in nodes.indices) {
        val node = nodes[i] ?: continue
        val left = 2 * i + 1
        val right = left + 1
        if (left < nodes.size) {
            node.left = nodes[left]
        }
        if (right < nodes.size) {
            node.right = nodes[right]
        }
    }
    return nodes[0]
}
