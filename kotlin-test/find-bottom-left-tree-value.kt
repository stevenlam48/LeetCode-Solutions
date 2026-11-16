package findbottomlefttreevalue

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindBottomLeftTreeValueTest {
    @Test
    fun balancedTree() {
        assertEquals(1, Solution().findBottomLeftValue(treeOf(2, 1, 3)))
    }

    @Test
    fun deepestNodeInRightSubtree() {
        val root = treeOf(1, 2, 3, 4, null, 5, 6, null, null, 7)
        assertEquals(7, Solution().findBottomLeftValue(root))
    }

    @Test
    fun singleNode() {
        assertEquals(-5, Solution().findBottomLeftValue(treeOf(-5)))
    }

    @Test
    fun rightOnlyChain() {
        assertEquals(2, Solution().findBottomLeftValue(treeOf(0, null, 1, null, 2)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeNode(values[0]!!)
    val nodes = Array<TreeNode?>(values.size) { null }
    nodes[0] = root
    var parent = 0
    var i = 1
    while (i < values.size) {
        while (nodes[parent] == null) ++parent
        values[i]?.let { value ->
            val node = TreeNode(value)
            nodes[parent]!!.left = node
            nodes[i] = node
        }
        if (i + 1 < values.size) {
            values[i + 1]?.let { value ->
                val node = TreeNode(value)
                nodes[parent]!!.right = node
                nodes[i + 1] = node
            }
        }
        ++parent
        i += 2
    }
    return root
}
