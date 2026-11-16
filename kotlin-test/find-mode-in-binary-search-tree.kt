package findmodeinbinarysearchtree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindModeInBinarySearchTreeTest {
    private val solution = Solution()

    @Test
    fun repeatedMode() {
        assertArrayEquals(intArrayOf(2), solution.findMode(treeOf(1, null, 2, 2)))
    }

    @Test
    fun multipleModes() {
        assertArrayEquals(intArrayOf(1, 2), solution.findMode(treeOf(1, null, 2)))
    }

    @Test
    fun negativeAndDuplicateValues() {
        assertArrayEquals(intArrayOf(-1), solution.findMode(treeOf(0, -1, 0, -1, -1)))
    }

    @Test
    fun emptyAndSingleNodeTrees() {
        assertArrayEquals(intArrayOf(), solution.findMode(null))
        assertArrayEquals(intArrayOf(5), solution.findMode(treeOf(5)))
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
