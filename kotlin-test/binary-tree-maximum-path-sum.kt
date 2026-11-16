package binarytreemaximumpathsum

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeMaximumPathSumTest {
    @Test
    fun standardExampleWithNegativeRoot() {
        assertEquals(6, Solution().maxPathSum(treeOf(1, 2, 3)))
    }

    @Test
    fun pathTurnsAtInternalNode() {
        val root = treeOf(-10, 9, 20, null, null, 15, 7)
        assertEquals(42, Solution().maxPathSum(root))
    }

    @Test
    fun allValuesAreNegative() {
        assertEquals(-1, Solution().maxPathSum(treeOf(-3, -1, -2)))
    }

    @Test
    fun singleNegativeNode() {
        assertEquals(-5, Solution().maxPathSum(treeOf(-5)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.removeFirst()
        values[i++]?.let {
            val child = TreeNode(it)
            node.left = child
            queue.add(child)
        }
        if (i < values.size) {
            values[i++]?.let {
                val child = TreeNode(it)
                node.right = child
                queue.add(child)
            }
        }
    }
    return root
}
