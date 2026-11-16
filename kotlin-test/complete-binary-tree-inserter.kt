package completebinarytreeinserter

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CompleteBinaryTreeInserterTest {
    @Test
    fun insertsIntoExistingIncompleteTree() {
        val inserter = CBTInserter(treeOf(1, 2)!!)
        assertEquals(1, inserter.insert(3))
        assertEquals(2, inserter.insert(4))
        assertEquals(listOf(1, 2, 3, 4), levelOrder(inserter.getRoot()))
    }

    @Test
    fun fillsNextLevelInBreadthFirstOrder() {
        val inserter = CBTInserter(treeOf(1, 2, 3, 4, 5, 6)!!)
        assertEquals(3, inserter.insert(7))
        assertEquals(4, inserter.insert(8))
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8), levelOrder(inserter.getRoot()))
    }

    @Test
    fun growsSingleNodeTree() {
        val inserter = CBTInserter(TreeNode(10))
        assertEquals(10, inserter.insert(20))
        assertEquals(10, inserter.insert(30))
        assertEquals(20, inserter.insert(40))
        assertEquals(listOf(10, 20, 30, 40), levelOrder(inserter.getRoot()))
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
            queue.add(node.left)
        }
        ++i
        if (i < values.size && values[i] != null) {
            node.right = TreeNode(values[i]!!)
            queue.add(node.right)
        }
        ++i
    }
    return root
}

private fun levelOrder(root: TreeNode?): List<Int?> {
    if (root == null) return emptyList()
    val result = mutableListOf<Int?>()
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        result.add(node.`val`)
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
    }
    return result
}
