package deleteleaveswithagivenvalue

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeleteLeavesWithAGivenValueTest {
    private val solution = Solution()

    @Test
    fun removesNewlyExposedTargetLeaves() {
        val root = treeOf(1, 2, 3, 2, null, 2, 4)
        assertEquals(listOf(1, null, 3, null, 4), levelOrder(solution.removeLeafNodes(root, 2)))
    }

    @Test
    fun canRemoveEntireTree() {
        assertEquals(emptyList<Int?>(), levelOrder(solution.removeLeafNodes(treeOf(2, 2, 2), 2)))
    }

    @Test
    fun targetAbsent() {
        val root = treeOf(1, 2, 3)
        assertEquals(listOf(1, 2, 3), levelOrder(solution.removeLeafNodes(root, 4)))
    }

    @Test
    fun emptyTree() {
        assertEquals(null, solution.removeLeafNodes(null, 1))
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
