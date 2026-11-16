package countcompletetreenodes

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCompleteTreeNodesTest {
    @Test
    fun perfectLastLevel() {
        assertEquals(6, Solution().countNodes(treeOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun partialLastLevel() {
        assertEquals(5, Solution().countNodes(treeOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun emptyAndSingleNode() {
        assertEquals(0, Solution().countNodes(null))
        assertEquals(1, Solution().countNodes(treeOf(1)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val nodes = values.map { it?.let(::TreeNode) }
    for (i in nodes.indices) {
        val left = 2 * i + 1
        val right = left + 1
        if (left < nodes.size) {
            nodes[i]?.left = nodes[left]
        }
        if (right < nodes.size) {
            nodes[i]?.right = nodes[right]
        }
    }
    return nodes[0]
}
