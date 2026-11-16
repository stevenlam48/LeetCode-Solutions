package sumNumbers

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SumNumbersTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(25, solution.sumNumbers(treeOf(1, 2, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(1026, solution.sumNumbers(treeOf(4, 9, 0, 5, 1)))
    }

    @Test
    fun testEmptyTree() {
        assertEquals(0, solution.sumNumbers(null))
    }

    @Test
    fun testSingleNode() {
        assertEquals(7, solution.sumNumbers(treeOf(7)))
    }

    @Test
    fun testLeftChain() {
        assertEquals(123, solution.sumNumbers(treeOf(1, 2, null, 3)))
    }

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
}
