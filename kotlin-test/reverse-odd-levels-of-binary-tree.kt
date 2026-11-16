package reverseoddlevelsofbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseOddLevelsOfBinaryTreeTest {
    @Test
    fun exampleOne() {
        val root = treeOf(2, 3, 5, 8, 13, 21, 34)
        assertEquals(listOf(2, 5, 3, 8, 13, 21, 34), levelOrder(Solution().reverseOddLevels(root)))
    }

    @Test
    fun exampleTwo() {
        val root = treeOf(7, 13, 11)
        assertEquals(listOf(7, 11, 13), levelOrder(Solution().reverseOddLevels(root)))
    }

    @Test
    fun twoOddLevels() {
        val root = treeOf(0, 1, 2, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2)
        assertEquals(listOf(0, 2, 1, 0, 0, 0, 0, 2, 2, 2, 2, 1, 1, 1, 1), levelOrder(Solution().reverseOddLevels(root)))
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<Int?>(), levelOrder(Solution().reverseOddLevels(null)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var index = 1
    while (queue.isNotEmpty() && index < values.size) {
        val node = queue.removeFirst()
        if (index < values.size) {
            values[index]?.let { node.left = TreeNode(it); queue.add(node.left!!) }
            ++index
        }
        if (index < values.size) {
            values[index]?.let { node.right = TreeNode(it); queue.add(node.right!!) }
            ++index
        }
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
