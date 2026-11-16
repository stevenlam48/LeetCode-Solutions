package insertintoabinarysearchtree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InsertIntoABinarySearchTreeTest {
    @Test
    fun insertsIntoEmptyTree() {
        assertEquals(listOf(5), levelOrder(Solution().insertIntoBST(null, 5)))
    }

    @Test
    fun insertsIntoLeetCodeExample() {
        val root = treeOf(4, 2, 7, 1, 3)
        assertEquals(
            listOf(4, 2, 7, 1, 3, 5),
            levelOrder(Solution().insertIntoBST(root, 5))
        )
    }

    @Test
    fun insertsDuplicateIntoLeftSubtree() {
        val root = treeOf(4, 2, 7)
        assertEquals(listOf(4, 2, 7, 2), levelOrder(Solution().insertIntoBST(root, 2)))
    }

    @Test
    fun insertsNewMinimumAndMaximum() {
        val root = treeOf(4, 2, 7, 1, 3)
        Solution().insertIntoBST(root, 0)
        Solution().insertIntoBST(root, 8)
        assertEquals(listOf(4, 2, 7, 1, 3, null, 8, 0), levelOrder(root))
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
    while (result.lastOrNull() == null) result.removeAt(result.lastIndex)
    return result
}
