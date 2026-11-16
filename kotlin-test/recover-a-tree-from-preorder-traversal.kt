package recoveratreefrompreordertraversal

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RecoverATreeFromPreorderTraversalTest {
    private val solution = Solution()

    private fun levelOrder(root: TreeNode?): List<Int?> {
        val result = ArrayList<Int?>()
        if (root == null) {
            return result
        }
        val q = ArrayDeque<TreeNode?>()
        q.add(root)
        while (q.isNotEmpty()) {
            val node = q.removeFirst()
            if (node == null) {
                result.add(null)
                continue
            }
            result.add(node.`val`)
            q.add(node.left)
            q.add(node.right)
        }
        while (result.isNotEmpty() && result.last() == null) {
            result.removeAt(result.size - 1)
        }
        return result
    }

    @Test
    fun testExample1() {
        val root = solution.recoverFromPreorder("1-2--3--4-5--6--7")
        assertEquals(listOf(1, 2, 5, 3, 4, 6, 7), levelOrder(root))
    }

    @Test
    fun testExample2() {
        val root = solution.recoverFromPreorder("1-401--349---90--88")
        assertEquals(listOf(1, 401, null, 349, 88, 90), levelOrder(root))
    }

    @Test
    fun testSingleNode() {
        val root = solution.recoverFromPreorder("1")
        assertEquals(listOf(1), levelOrder(root))
    }

    @Test
    fun testLeftChain() {
        val root = solution.recoverFromPreorder("1-2--3---4")
        assertEquals(listOf(1, 2, null, 3, null, 4), levelOrder(root))
    }

    @Test
    fun testRightChild() {
        val root = solution.recoverFromPreorder("1-2--3-4")
        assertEquals(listOf(1, 2, 4, 3), levelOrder(root))
    }

    @Test
    fun testMultiDigitValues() {
        val root = solution.recoverFromPreorder("100-200--300")
        assertEquals(listOf(100, 200, null, 300), levelOrder(root))
    }
}
