package checkcompletenessofabinarytree

import common.TreeNode
import java.util.LinkedList
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    var i = 1
    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.remove()
        if (i < values.size && values[i] != null) {
            val left = TreeNode(values[i]!!)
            node.left = left
            queue.add(left)
        }
        ++i
        if (i < values.size && values[i] != null) {
            val right = TreeNode(values[i]!!)
            node.right = right
            queue.add(right)
        }
        ++i
    }
    return root
}

class CheckCompletenessOfABinaryTreeTest {
    private val solution = Solution()

    @Test
    fun completeTree() {
        assertTrue(solution.isCompleteTree(treeOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun nodeAfterGap() {
        assertFalse(solution.isCompleteTree(treeOf(1, 2, 3, 4, 5, null, 7)))
    }

    @Test
    fun rightChildWithoutLeftChild() {
        assertFalse(solution.isCompleteTree(treeOf(1, null, 2)))
    }

    @Test
    fun emptyAndSingleNodeTrees() {
        assertTrue(solution.isCompleteTree(treeOf()))
        assertTrue(solution.isCompleteTree(treeOf(1)))
    }
}
