package binarytreepostordertraversal

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreePostorderTraversalTest {
    @Test
    fun standardExample() {
        assertEquals(listOf(3, 2, 1), Solution().postorderTraversal(treeOf(1, null, 2, 3)))
    }

    @Test
    fun completeTree() {
        val root = treeOf(1, 2, 3, 4, 5, 6, 7)
        assertEquals(listOf(4, 5, 2, 6, 7, 3, 1), Solution().postorderTraversal(root))
    }

    @Test
    fun leftSkewedTree() {
        assertEquals(listOf(3, 2, 1), Solution().postorderTraversal(treeOf(1, 2, null, 3)))
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<Int>(), Solution().postorderTraversal(null))
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
