package splitbst

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SplitBstTest {
    @Test
    fun `splits the standard tree at a non root value`() {
        val result = Solution().splitBST(treeOf(4, 2, 6, 1, 3, 5, 7), 2)

        assertEquals(listOf(2, 1), levelOrder(result[0]))
        assertEquals(listOf(4, 3, 6, null, null, 5, 7), levelOrder(result[1]))
    }

    @Test
    fun `splits below the root on the right side`() {
        val result = Solution().splitBST(treeOf(4, 2, 6, 1, 3, 5, 7), 5)

        assertEquals(listOf(4, 2, 5, 1, 3), levelOrder(result[0]))
        assertEquals(listOf(6, null, 7), levelOrder(result[1]))
    }

    @Test
    fun `returns two null roots for an empty tree`() {
        val result = Solution().splitBST(null, 2)

        assertEquals(2, result.size)
        assertNull(result[0])
        assertNull(result[1])
    }

    @Test
    fun `puts the whole tree in the first result when all values are smaller`() {
        val result = Solution().splitBST(treeOf(2, 1, 3), 3)

        assertEquals(listOf(2, 1, 3), levelOrder(result[0]))
        assertNull(result[1])
    }

    @Test
    fun `puts the whole tree in the second result when all values are larger`() {
        val result = Solution().splitBST(treeOf(2, 1, 3), 0)

        assertNull(result[0])
        assertEquals(listOf(2, 1, 3), levelOrder(result[1]))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.removeFirst()
        values[i]?.let {
            val child = TreeNode(it)
            node.left = child
            queue.add(child)
        }
        i++
        if (i < values.size) {
            values[i]?.let {
                val child = TreeNode(it)
                node.right = child
                queue.add(child)
            }
            i++
        }
    }
    return root
}

private fun levelOrder(root: TreeNode?): List<Int?> {
    if (root == null) {
        return emptyList()
    }
    val result = mutableListOf<Int?>()
    val queue = ArrayDeque<TreeNode?>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        if (node == null) {
            result.add(null)
        } else {
            result.add(node.`val`)
            queue.add(node.left)
            queue.add(node.right)
        }
    }
    while (result.lastOrNull() == null) {
        result.removeAt(result.lastIndex)
    }
    return result
}
