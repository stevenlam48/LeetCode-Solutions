package addonerowtotree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddOneRowToTreeTest {
    private val solution = Solution()

    @Test
    fun addRowAtDepthTwo() {
        val root = treeOf(4, 2, 6, 3, 1, 5)
        val actual = solution.addOneRow(root, 1, 2)
        assertEquals(listOf(4, 1, 1, 2, null, null, 6, 3, 1, 5), levelOrder(actual))
    }

    @Test
    fun addNewRoot() {
        val actual = solution.addOneRow(treeOf(4, 2, null, 3, 1), 1, 1)
        assertEquals(listOf(1, 4, null, 2, null, 3, 1), levelOrder(actual))
    }

    @Test
    fun addToEmptyTree() {
        val actual = solution.addOneRow(null, 5, 1)
        assertEquals(listOf(5), levelOrder(actual))
    }

    @Test
    fun depthZeroAttachesOldTreeOnRight() {
        val actual = solution.addOneRow(treeOf(2), 1, 0)
        assertEquals(listOf(1, null, 2), levelOrder(actual))
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
        i++
        if (i < values.size && values[i] != null) {
            node.right = TreeNode(values[i]!!)
            queue.add(node.right!!)
        }
        i++
    }
    return root
}

private fun levelOrder(root: TreeNode?): List<Int?> {
    if (root == null) return emptyList()
    val result = mutableListOf<Int?>(root.`val`)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        result.add(node.left?.`val`)
        node.left?.let(queue::add)
        result.add(node.right?.`val`)
        node.right?.let(queue::add)
    }
    while (result.isNotEmpty() && result.last() == null) result.removeAt(result.lastIndex)
    return result
}
