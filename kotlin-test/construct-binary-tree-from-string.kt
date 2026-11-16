package constructbinarytreefromstring

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ConstructBinaryTreeFromStringTest {
    private fun levelOrder(root: TreeNode?): List<Int?> {
        val result = mutableListOf<Int?>()
        if (root == null) return result
        val queue = ArrayDeque<TreeNode?>()
        queue.addLast(root)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (node == null) {
                result.add(null)
            } else {
                result.add(node.`val`)
                queue.addLast(node.left)
                queue.addLast(node.right)
            }
        }
        while (result.isNotEmpty() && result.last() == null) {
            result.removeAt(result.size - 1)
        }
        return result
    }

    @Test
    fun testExample() {
        val result = Solution().str2tree("4(2(3)(1))(6(5))")
        assertEquals(listOf(4, 2, 6, 3, 1, 5), levelOrder(result))
    }

    @Test
    fun testEmpty() {
        assertNull(Solution().str2tree(""))
    }

    @Test
    fun testNegativeNumbers() {
        val result = Solution().str2tree("-4(2(3)(1))(6(5))")
        assertEquals(listOf(-4, 2, 6, 3, 1, 5), levelOrder(result))
    }

    @Test
    fun testNoChildren() {
        val result = Solution().str2tree("1")
        assertEquals(listOf(1), levelOrder(result))
    }

    @Test
    fun testRightChildOnly() {
        val result = Solution().str2tree("1(2)")
        assertEquals(listOf(1, 2), levelOrder(result))
    }
}
