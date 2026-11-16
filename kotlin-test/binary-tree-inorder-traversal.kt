package binarytreeinordertraversal

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeInorderTraversalTest {
    @Test
    fun standardExample() {
        assertEquals(listOf(1, 3, 2), Solution().inorderTraversal(treeOf(1, null, 2, 3)))
    }

    @Test
    fun skewedAndDuplicateValues() {
        assertEquals(listOf(1, 2, 2, 3), Solution().inorderTraversal(treeOf(1, null, 2, null, 2, null, 3)))
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<Int>(), Solution().inorderTraversal(null))
    }

    @Test
    fun restoresTreeLinks() {
        val root = treeOf(1, null, 2, 3)
        Solution().inorderTraversal(root)
        assertEquals(listOf(1, null, 2, 3), levelOrder(root))
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
        values[i++]?.let {
            val child = TreeNode(it)
            node.left = child
            queue.add(child)
        }
        if (i < values.size) {
            values[i++]?.let {
                val child = TreeNode(it)
                node.right = child
                queue.add(child)
            }
        }
    }
    return root
}

private fun levelOrder(root: TreeNode?): List<Int?> {
    if (root == null) return emptyList()
    val result = mutableListOf<Int?>()
    val queue = mutableListOf<TreeNode?>()
    queue.add(root)
    var i = 0
    while (i < queue.size) {
        val node = queue[i++]
        result.add(node?.`val`)
        if (node != null) {
            queue.add(node.left)
            queue.add(node.right)
        }
    }
    while (result.lastOrNull() == null) result.removeAt(result.lastIndex)
    return result
}
