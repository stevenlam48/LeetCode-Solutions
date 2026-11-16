package convertsortedlisttobinarysearchtree

import common.ListNode
import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ConvertSortedListToBinarySearchTreeTest {
    private val solution = Solution()

    private fun linkedListOf(vararg v: Int): ListNode? {
        val dummy = ListNode(0)
        var curr = dummy
        for (x in v) {
            curr.next = ListNode(x)
            curr = curr.next!!
        }
        return dummy.next
    }

    private fun inorder(node: TreeNode?, out: MutableList<Int>) {
        if (node == null) return
        inorder(node.left, out)
        out.add(node.`val`)
        inorder(node.right, out)
    }

    private fun levelOrder(root: TreeNode?): List<Int?> {
        val result = mutableListOf<Int?>()
        if (root == null) return result
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (node == null) {
                result.add(null)
                continue
            }
            result.add(node.`val`)
            queue.add(node.left)
            queue.add(node.right)
        }
        while (result.isNotEmpty() && result.last() == null) {
            result.removeAt(result.size - 1)
        }
        return result
    }

    @Test
    fun testExample() {
        val root = solution.sortedListToBST(linkedListOf(-10, -3, 0, 5, 9))
        assertEquals(listOf(0, -3, 9, -10, null, 5), levelOrder(root))
        val values = mutableListOf<Int>()
        inorder(root, values)
        assertEquals(listOf(-10, -3, 0, 5, 9), values)
    }

    @Test
    fun testThree() {
        val root = solution.sortedListToBST(linkedListOf(1, 2, 3))
        assertEquals(listOf(2, 1, 3), levelOrder(root))
    }

    @Test
    fun testEmpty() {
        assertNull(solution.sortedListToBST(null))
    }

    @Test
    fun testSingle() {
        val root = solution.sortedListToBST(linkedListOf(1))
        assertEquals(listOf(1), levelOrder(root))
    }
}
