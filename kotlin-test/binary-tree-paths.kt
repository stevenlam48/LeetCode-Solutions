package binarytreepaths

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreePathsTest {
    @Test
    fun standardExample() {
        val root = treeOf(1, 2, 3, null, 5)
        assertEquals(listOf("1->2->5", "1->3"), Solution().binaryTreePaths(root))
    }

    @Test
    fun negativeValues() {
        val root = treeOf(-1, -2, null, -3)
        assertEquals(listOf("-1->-2->-3"), Solution().binaryTreePaths(root))
    }

    @Test
    fun singleNode() {
        assertEquals(listOf("1"), Solution().binaryTreePaths(treeOf(1)))
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<String>(), Solution().binaryTreePaths(null))
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
