package evenoddtree

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EvenOddTreeTest {
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
        assertTrue(
            solution.isEvenOddTree(
                treeOf(1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2)
            )
        )
    }

    @Test
    fun testExample2() {
        assertFalse(solution.isEvenOddTree(treeOf(5, 4, 2, 3, 3, 7)))
    }

    @Test
    fun testExample3() {
        assertFalse(solution.isEvenOddTree(treeOf(5, 9, 1, 3, 5, 7)))
    }

    @Test
    fun testSingleNode() {
        assertTrue(solution.isEvenOddTree(treeOf(1)))
        assertFalse(solution.isEvenOddTree(treeOf(2)))
    }

    @Test
    fun testTwoLevels() {
        assertTrue(solution.isEvenOddTree(treeOf(1, 4, 2)))
        assertFalse(solution.isEvenOddTree(treeOf(1, 2, 4)))
    }
}
