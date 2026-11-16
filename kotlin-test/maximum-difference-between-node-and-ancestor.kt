package maximumdifferencebetweennodeandancestor

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumDifferenceBetweenNodeAndAncestorTest {
    @Test
    fun exampleWithMultipleBranches() {
        val root = treeOf(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13)
        assertEquals(7, Solution().maxAncestorDiff(root))
    }

    @Test
    fun exampleWithSkewedTree() {
        val root = treeOf(1, null, 2, null, 0, 3)
        assertEquals(3, Solution().maxAncestorDiff(root))
    }

    @Test
    fun singleNode() {
        assertEquals(0, Solution().maxAncestorDiff(treeOf(5)))
    }

    @Test
    fun equalValues() {
        assertEquals(0, Solution().maxAncestorDiff(treeOf(5, 5, 5, 5, 5)))
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
        values[index]?.let {
            val child = TreeNode(it)
            node.left = child
            queue.addLast(child)
        }
        ++index
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
