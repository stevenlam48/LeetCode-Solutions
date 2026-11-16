package closestbinarysearchtreevalue

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClosestBinarySearchTreeValueTest {
    @Test
    fun findsClosestValueInLeetCodeExample() {
        assertEquals(4, Solution().closestValue(treeOf(4, 2, 5, 1, 3), 3.714285714))
    }

    @Test
    fun keepsFirstVisitedValueOnEqualDistance() {
        assertEquals(4, Solution().closestValue(treeOf(4, 2, 5, 1, 3), 3.5))
    }

    @Test
    fun stopsAtExactMatch() {
        assertEquals(2, Solution().closestValue(treeOf(4, 2, 5, 1, 3), 2.0))
    }

    @Test
    fun handlesNegativeSingleNodeTree() {
        assertEquals(-8, Solution().closestValue(treeOf(-8), -3.25))
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
        index++
        if (index < values.size && values[index] != null) {
            node.right = TreeNode(values[index]!!)
            queue.add(node.right!!)
        }
        index++
    }
    return root
}
