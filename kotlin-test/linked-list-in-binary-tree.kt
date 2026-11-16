package linkedlistinbinarytree

import common.ListNode
import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LinkedListInBinaryTreeTest {
    @Test
    fun downwardPathWithPrefixBeforeMatch() {
        val head = listOf(4, 2, 8)
        val root = exampleTree()
        assertTrue(Solution().isSubPath(head, root))
    }

    @Test
    fun pathStartingAtTreeRoot() {
        val head = listOf(1, 4, 2, 6)
        val root = exampleTree()
        assertTrue(Solution().isSubPath(head, root))
    }

    @Test
    fun partialMatchIsNotSubPath() {
        val head = listOf(1, 4, 2, 6, 8)
        val root = exampleTree()
        assertFalse(Solution().isSubPath(head, root))
    }

    @Test
    fun emptyListMatchesEmptyTree() {
        assertTrue(Solution().isSubPath(null, null))
    }

    @Test
    fun nonemptyListDoesNotMatchEmptyTree() {
        assertFalse(Solution().isSubPath(listOf(1), null))
    }
}

private fun listOf(vararg values: Int): ListNode? {
    val dummy = ListNode(0)
    var tail = dummy
    for (value in values) {
        tail.next = ListNode(value)
        tail = tail.next!!
    }
    return dummy.next
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
        values[i]?.let {
            node.left = TreeNode(it)
            queue.add(node.left!!)
        }
        ++i
        if (i < values.size) {
            values[i]?.let {
                node.right = TreeNode(it)
                queue.add(node.right!!)
            }
            ++i
        }
    }
    return root
}

private fun exampleTree(): TreeNode? = treeOf(
    1, 4, 4, null, 2, 2, null, 1, null, 6, 8,
    null, null, null, null, 1, 3
)
