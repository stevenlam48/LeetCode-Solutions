package countunivaluesubtrees

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    var i = 1
    while (i < values.size) {
        val node = queue.removeFirst()
        if (values[i] != null) {
            val left = TreeNode(values[i]!!)
            node.left = left
            queue.addLast(left)
        }
        ++i
        if (i < values.size && values[i] != null) {
            val right = TreeNode(values[i]!!)
            node.right = right
            queue.addLast(right)
        }
        ++i
    }
    return root
}

class CountUnivalueSubtreesTest {
    @Test
    fun `mixed tree`() {
        val root = treeOf(5, 1, 5, 5, 5, null, 5)

        assertEquals(4, Solution().countUnivalSubtrees(root))
    }

    @Test
    fun `all nodes share one value`() {
        val root = treeOf(5, 5, 5, 5, 5, null, 5)

        assertEquals(6, Solution().countUnivalSubtrees(root))
    }

    @Test
    fun `only leaves are univalue subtrees`() {
        val root = treeOf(1, 1, 1, 2, 2, null, 2)

        assertEquals(3, Solution().countUnivalSubtrees(root))
    }

    @Test
    fun `single node`() {
        assertEquals(1, Solution().countUnivalSubtrees(treeOf(-3)))
    }

    @Test
    fun `empty tree`() {
        assertEquals(0, Solution().countUnivalSubtrees(null))
    }
}
