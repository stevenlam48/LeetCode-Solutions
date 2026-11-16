package validatebinarysearchtree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidateBinarySearchTreeTest {
    private val solution = Solution()

    @Test
    fun acceptsValidTree() {
        assertTrue(solution.isValidBST(treeOf(2, 1, 3)))
    }

    @Test
    fun rejectsInvalidSubtree() {
        assertFalse(solution.isValidBST(treeOf(5, 1, 4, null, null, 3, 6)))
    }

    @Test
    fun handlesEmptySingleAndDuplicateValues() {
        assertTrue(solution.isValidBST(null))
        assertTrue(solution.isValidBST(treeOf(1)))
        assertFalse(solution.isValidBST(treeOf(2, 2, 2)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (i < values.size && queue.isNotEmpty()) {
        val node = queue.removeFirst()
        values[i++]?.let {
            val child = TreeNode(it)
            node.left = child
            queue.add(child)
        }
        if (i < values.size) {
            values[i++]?.let {
                val child = TreeNode(it)
                node.right = child
                queue.add(child)
            }
        }
    }
    return root
}
