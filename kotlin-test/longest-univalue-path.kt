package longestunivaluepath

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestUnivaluePathTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(2, solution.longestUnivaluePath(treeOf(5, 4, 5, 1, 1, null, 5)))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(2, solution.longestUnivaluePath(treeOf(1, 4, 5, 4, 4, 5)))
    }

    @Test
    fun testEmptyTree() {
        assertEquals(0, solution.longestUnivaluePath(treeOf()))
    }

    @Test
    fun testSingleNode() {
        assertEquals(0, solution.longestUnivaluePath(treeOf(1)))
    }

    @Test
    fun testTwoEqualNodes() {
        assertEquals(1, solution.longestUnivaluePath(treeOf(1, 1)))
    }

    @Test
    fun testEqualRightChild() {
        assertEquals(1, solution.longestUnivaluePath(treeOf(1, null, 1)))
    }

    private fun treeOf(vararg v: Int?): TreeNode? {
        if (v.isEmpty() || v[0] == null) {
            return null
        }
        val root = TreeNode(v[0]!!)
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        var i = 1
        while (queue.isNotEmpty() && i < v.size) {
            val node = queue.removeFirst()
            if (i < v.size) {
                if (v[i] != null) {
                    node.left = TreeNode(v[i]!!)
                    queue.addLast(node.left!!)
                }
                ++i
            }
            if (i < v.size) {
                if (v[i] != null) {
                    node.right = TreeNode(v[i]!!)
                    queue.addLast(node.right!!)
                }
                ++i
            }
        }
        return root
    }
}
