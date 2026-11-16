package equaltreepartition

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EqualTreePartitionTest {
    private val solution = Solution()

    private fun treeOf(vararg v: Int?): TreeNode? {
        if (v.isEmpty() || v[0] == null) {
            return null
        }
        val root = TreeNode(v[0]!!)
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var i = 1
        while (queue.isNotEmpty() && i < v.size) {
            val node = queue.removeFirst()
            if (i < v.size) {
                val left = v[i++]
                if (left != null) {
                    node.left = TreeNode(left)
                    queue.add(node.left!!)
                }
            }
            if (i < v.size) {
                val right = v[i++]
                if (right != null) {
                    node.right = TreeNode(right)
                    queue.add(node.right!!)
                }
            }
        }
        return root
    }

    @Test
    fun testExample1() {
        assertTrue(solution.checkEqualTree(treeOf(5, 10, 10, null, null, 2, 3)))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.checkEqualTree(treeOf(1, 2, 10, null, null, 2, 20)))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.checkEqualTree(treeOf(1, 2, 3)))
    }

    @Test
    fun testZeroTotal() {
        assertFalse(solution.checkEqualTree(treeOf(0, -1, 1)))
        assertTrue(solution.checkEqualTree(treeOf(0, 0, 0)))
    }

    @Test
    fun testSingleNode() {
        assertFalse(solution.checkEqualTree(treeOf(1)))
        assertFalse(solution.checkEqualTree(treeOf(0)))
    }

    @Test
    fun testNegativeValues() {
        assertTrue(solution.checkEqualTree(treeOf(-2, -2, 0)))
    }
}
