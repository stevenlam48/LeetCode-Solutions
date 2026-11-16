package binarytreepreordertraversal

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreePreorderTraversalTest {
    @Test
    fun standardExample() {
        assertEquals(listOf(1, 2, 3), Solution().preorderTraversal(treeOf(1, null, 2, 3)))
    }

    @Test
    fun completeTree() {
        assertEquals(listOf(1, 2, 4, 5, 3, 6, 7), Solution().preorderTraversal(treeOf(1, 2, 3, 4, 5, 6, 7)))
    }

    @Test
    fun leftSkewedTree() {
        assertEquals(listOf(1, 2, 3), Solution().preorderTraversal(treeOf(1, 2, null, 3)))
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<Int>(), Solution().preorderTraversal(null))
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
