package heightofbinarytreeaftersubtreeremovalqueries

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HeightOfBinaryTreeAfterSubtreeRemovalQueriesTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        val root = treeOf(5, 8, 9, 2, 1, 3, 7, 4, 6)
        assertArrayEquals(intArrayOf(3, 2, 3, 2), solution.treeQueries(root, intArrayOf(3, 2, 4, 8)))
    }

    @Test
    fun skewedTree() {
        val root = treeOf(1, null, 5, null, 3, null, 2)
        assertArrayEquals(intArrayOf(1, 0, 2), solution.treeQueries(root, intArrayOf(3, 5, 2)))
    }

    @Test
    fun siblingsHaveHeightsTied() {
        val root = treeOf(1, 2, 3)
        assertArrayEquals(intArrayOf(1, 1), solution.treeQueries(root, intArrayOf(2, 3)))
    }

    @Test
    fun noQueries() {
        assertArrayEquals(IntArray(0), solution.treeQueries(treeOf(1, 2, 3), IntArray(0)))
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
