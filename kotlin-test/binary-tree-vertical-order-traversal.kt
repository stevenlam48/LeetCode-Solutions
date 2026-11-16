package binarytreeverticalordertraversal

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeVerticalOrderTraversalTest {
    @Test
    fun standardExample() {
        val root = treeOf(3, 9, 20, null, null, 15, 7)
        assertEquals(listOf(listOf(9), listOf(3, 15), listOf(20), listOf(7)), Solution().verticalOrder(root))
    }

    @Test
    fun preservesBreadthFirstOrderWithinColumns() {
        val root = treeOf(3, 9, 8, 4, 0, 1, 7)
        assertEquals(listOf(listOf(4), listOf(9), listOf(3, 0, 1), listOf(8), listOf(7)), Solution().verticalOrder(root))
    }

    @Test
    fun singleNode() {
        assertEquals(listOf(listOf(1)), Solution().verticalOrder(treeOf(1)))
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<List<Int>>(), Solution().verticalOrder(null))
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
