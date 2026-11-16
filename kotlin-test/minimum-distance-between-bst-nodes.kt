package minimumdistancebetweenbstnodes
// Time:  O(n)
// Space: O(h)

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDistanceBetweenBstNodesTest {
    private val solution = Solution()

    @Test
    fun leetCodeExamples() {
        assertEquals(1, solution.minDiffInBST(treeOf(4, 2, 6, 1, 3)))
        assertEquals(1, solution.minDiffInBST(treeOf(1, 0, 48, null, null, 12, 49)))
    }

    @Test
    fun closestValuesAreNotParentAndChild() {
        assertEquals(2, solution.minDiffInBST(treeOf(20, 10, 30, 5, 15, 25, 40, null, null, 12, 17)))
    }

    @Test
    fun twoNodeTree() {
        assertEquals(9, solution.minDiffInBST(treeOf(10, null, 19)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var index = 1
    while (queue.isNotEmpty() && index < values.size) {
        val node = queue.removeFirst()
        if (index < values.size && values[index] != null) {
            node.left = TreeNode(values[index]!!)
            queue.add(node.left!!)
        }
        ++index
        if (index < values.size && values[index] != null) {
            node.right = TreeNode(values[index]!!)
            queue.add(node.right!!)
        }
        ++index
    }
    return root
}
