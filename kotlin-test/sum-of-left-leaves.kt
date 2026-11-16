package sumofleftleaves

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfLeftLeavesTest {
    private val solution = Solution()

    @Test
    fun exampleTree() {
        assertEquals(24, solution.sumOfLeftLeaves(treeOf(3, 9, 20, null, null, 15, 7)))
    }

    @Test
    fun emptyTree() {
        assertEquals(0, solution.sumOfLeftLeaves(null))
    }

    @Test
    fun singleNodeIsNotALeftLeaf() {
        assertEquals(0, solution.sumOfLeftLeaves(treeOf(1)))
    }

    @Test
    fun leftLeafUnderRightChild() {
        assertEquals(3, solution.sumOfLeftLeaves(treeOf(1, null, 2, 3)))
    }

    @Test
    fun rightLeafIsExcluded() {
        assertEquals(4, solution.sumOfLeftLeaves(treeOf(1, 2, 3, 4, 5)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
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
