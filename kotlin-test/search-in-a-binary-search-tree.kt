package searchinabinarysearchtree

// Time:  O(h)
// Space: O(1)

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import java.util.ArrayDeque

class SearchInABinarySearchTreeTest {
    @Test
    fun findsSubtree() {
        val root = treeOf(4, 2, 7, 1, 3)
        val result = Solution().searchBST(root, 2)
        assertSame(root?.left, result)
        assertEquals(listOf(2, 1, 3), levelOrder(result))
    }

    @Test
    fun missingValue() {
        assertNull(Solution().searchBST(treeOf(4, 2, 7, 1, 3), 5))
    }

    @Test
    fun emptyTree() {
        assertNull(Solution().searchBST(null, 1))
    }

    @Test
    fun rootMatch() {
        val root = treeOf(4, 2, 7)
        assertSame(root, Solution().searchBST(root, 4))
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
        values[i++]?.let {
            node.left = TreeNode(it)
            queue.add(node.left!!)
        }
        if (i < values.size) {
            values[i++]?.let {
                node.right = TreeNode(it)
                queue.add(node.right!!)
            }
        }
    }
    return root
}

private fun levelOrder(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }
    val result = mutableListOf<Int>()
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        result.add(node.`val`)
        node.left?.let(queue::add)
        node.right?.let(queue::add)
    }
    return result
}
