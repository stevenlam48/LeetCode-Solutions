package deletenodeinabst

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeleteNodeInABstTest {
    private val solution = Solution()

    @Test
    fun deletesNodeWithTwoChildren() {
        val root = treeOf(5, 3, 6, 2, 4, null, 7)
        assertEquals(listOf(5, 4, 6, 2, null, null, 7), levelOrder(solution.deleteNode(root, 3)))
    }

    @Test
    fun deletesRootUsingSuccessor() {
        val root = treeOf(5, 3, 6, 2, 4, null, 7)
        assertEquals(listOf(6, 3, 7, 2, 4), levelOrder(solution.deleteNode(root, 5)))
    }

    @Test
    fun deletesLeafAndSingleChild() {
        val root = treeOf(5, 3, 6, null, 4, null, 7)
        val withoutLeaf = solution.deleteNode(root, 7)
        assertEquals(listOf(5, 3, 6, null, 4), levelOrder(withoutLeaf))
        assertEquals(listOf(5, 4, 6), levelOrder(solution.deleteNode(withoutLeaf, 3)))
    }

    @Test
    fun missingKeyAndEmptyTree() {
        assertEquals(listOf(2, 1, 3), levelOrder(solution.deleteNode(treeOf(2, 1, 3), 9)))
        assertEquals(emptyList<Int?>(), levelOrder(solution.deleteNode(null, 1)))
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
