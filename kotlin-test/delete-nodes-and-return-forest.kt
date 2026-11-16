package deletenodesandreturnforest

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeleteNodesAndReturnForestTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        val root = treeOf(1, 2, 3, 4, 5, 6, 7)
        val forest = solution.delNodes(root, intArrayOf(3, 5)).map { levelOrder(it) }.toSet()
        assertEquals(setOf(listOf(1, 2, null, 4), listOf(6), listOf(7)), forest)
    }

    @Test
    fun deletingRootMakesChildrenRoots() {
        val root = treeOf(1, 2, 3)
        val forest = solution.delNodes(root, intArrayOf(1)).map { levelOrder(it) }.toSet()
        assertEquals(setOf(listOf(2), listOf(3)), forest)
    }

    @Test
    fun nothingDeleted() {
        val forest = solution.delNodes(treeOf(1, 2, 3), intArrayOf(4)).map { levelOrder(it) }
        assertEquals(listOf(listOf(1, 2, 3)), forest)
    }

    @Test
    fun emptyTreeAndDeleteEverything() {
        assertEquals(emptyList<TreeNode>(), solution.delNodes(null, intArrayOf(1)))
        assertEquals(emptyList<TreeNode>(), solution.delNodes(treeOf(1, 2), intArrayOf(1, 2)))
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

private fun levelOrder(root: TreeNode?): List<Int?> {
    if (root == null) return emptyList()
    val result = mutableListOf<Int?>()
    val queue = ArrayDeque<TreeNode?>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        result.add(node?.`val`)
        if (node != null) {
            queue.add(node.left)
            queue.add(node.right)
        }
    }
    while (result.isNotEmpty() && result.last() == null) result.removeAt(result.lastIndex)
    return result
}
