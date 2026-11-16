package longestzigzagpathinabinarytree

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestZigzagPathInABinaryTreeTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        val root = treeOf(
            1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1
        )
        assertEquals(3, solution.longestZigZag(root))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(2, solution.longestZigZag(treeOf(1, 1, 1, 1, 1, null, 1)))
    }

    @Test
    fun testSingleNode() {
        assertEquals(0, solution.longestZigZag(treeOf(1)))
    }

    @Test
    fun testTwoNodes() {
        assertEquals(1, solution.longestZigZag(treeOf(1, 1)))
    }

    @Test
    fun testRightOnlyChain() {
        assertEquals(1, solution.longestZigZag(treeOf(1, null, 1)))
    }

    @Test
    fun testSingleZigZag() {
        assertEquals(2, solution.longestZigZag(treeOf(1, 1, null, null, 1)))
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
