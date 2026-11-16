package largestbstsubtree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestBstSubtreeTest {
    @Test
    fun subtreeWithinInvalidTree() {
        assertEquals(3, Solution().largestBSTSubtree(treeOf(10, 5, 15, 1, 8, null, 7)))
    }

    @Test
    fun entireTreeIsBst() {
        assertEquals(7, Solution().largestBSTSubtree(treeOf(10, 5, 15, 1, 8, 12, 20)))
    }

    @Test
    fun emptyAndSingleNode() {
        assertEquals(0, Solution().largestBSTSubtree(null))
        assertEquals(1, Solution().largestBSTSubtree(treeOf(4)))
    }

    @Test
    fun onlySmallSubtreeIsValid() {
        assertEquals(3, Solution().largestBSTSubtree(treeOf(5, 4, 6, null, null, 3, 7)))
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
        if (i < values.size && values[i] != null) {
            node.left = TreeNode(values[i]!!)
            queue.add(node.left!!)
        }
        ++i
        if (i < values.size && values[i] != null) {
            node.right = TreeNode(values[i]!!)
            queue.add(node.right!!)
        }
        ++i
    }
    return root
}
