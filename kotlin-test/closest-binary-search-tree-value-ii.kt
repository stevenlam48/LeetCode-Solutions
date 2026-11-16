package closestbinarysearchtreevalueii

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ClosestBinarySearchTreeValueIiTest {
    @Test
    fun findsClosestValuesInLeetCodeExample() {
        val result = Solution().closestKValues(treeOf(4, 2, 5, 1, 3), 3.714285714, 2)
        assertArrayEquals(intArrayOf(4, 3), result)
    }

    @Test
    fun includesExactValueAndUsesReferenceTieOrdering() {
        val result = Solution().closestKValues(treeOf(4, 2, 5, 1, 3), 3.0, 2)
        assertArrayEquals(intArrayOf(3, 4), result)
    }

    @Test
    fun collectsSuccessorsFromATruncatedRightPath() {
        val result = Solution().closestKValues(treeOf(4, null, 5, null, 6), 10.0, 3)
        assertArrayEquals(intArrayOf(6, 5, 4), result)
    }

    @Test
    fun returnsEmptyForZeroK() {
        assertArrayEquals(intArrayOf(), Solution().closestKValues(treeOf(4, 2, 5), 4.0, 0))
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
