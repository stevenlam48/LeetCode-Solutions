package deepestleavessum

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeepestLeavesSumTest {
    private val solution = Solution()

    @Test
    fun sumsDeepestLeavesAcrossTree() {
        assertEquals(15, solution.deepestLeavesSum(treeOf(1, 2, 3, 4, 5, null, 6, 7, null, null, null, 8)))
    }

    @Test
    fun multipleDeepestLeaves() {
        assertEquals(19, solution.deepestLeavesSum(treeOf(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5)))
    }

    @Test
    fun singleNode() {
        assertEquals(-3, solution.deepestLeavesSum(treeOf(-3)))
    }

    @Test
    fun skewedTree() {
        assertEquals(4, solution.deepestLeavesSum(treeOf(1, null, 2, null, 3, null, 4)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (i < values.size && queue.isNotEmpty()) {
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
