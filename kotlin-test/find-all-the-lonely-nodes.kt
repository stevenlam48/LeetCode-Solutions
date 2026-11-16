package findallthelonelynodes

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindAllTheLonelyNodesTest {
    @Test
    fun firstLeetCodeExample() {
        assertEquals(listOf(4), Solution().getLonelyNodes(treeOf(1, 2, 3, null, 4)))
    }

    @Test
    fun secondLeetCodeExample() {
        val root = treeOf(7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2)
        assertEquals(listOf(6, 2), Solution().getLonelyNodes(root))
    }

    @Test
    fun noLonelyNodes() {
        assertEquals(emptyList<Int>(), Solution().getLonelyNodes(treeOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<Int>(), Solution().getLonelyNodes(null))
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
