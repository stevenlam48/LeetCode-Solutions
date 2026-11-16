package binarytreelevelordertraversal

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeLevelOrderTraversalTest {
    @Test
    fun standardExample() {
        val root = treeOf(3, 9, 20, null, null, 15, 7)
        assertEquals(listOf(listOf(3), listOf(9, 20), listOf(15, 7)), Solution().levelOrder(root))
    }

    @Test
    fun skewedTree() {
        assertEquals(listOf(listOf(1), listOf(2), listOf(3)), Solution().levelOrder(treeOf(1, null, 2, null, 3)))
    }

    @Test
    fun singleNode() {
        assertEquals(listOf(listOf(1)), Solution().levelOrder(treeOf(1)))
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<List<Int>>(), Solution().levelOrder(null))
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
