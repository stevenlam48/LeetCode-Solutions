package verticalordertraversalofabinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VerticalOrderTraversalOfABinaryTreeTest {
    private val solution = Solution()

    @Test
    fun traversesStandardTree() {
        assertEquals(
            listOf(listOf(9), listOf(3, 15), listOf(20), listOf(7)),
            solution.verticalTraversal(treeOf(3, 9, 20, null, null, 15, 7))
        )
    }

    @Test
    fun sortsValuesSharingColumnAndRow() {
        assertEquals(
            listOf(listOf(4), listOf(2), listOf(1, 5, 6), listOf(3), listOf(7)),
            solution.verticalTraversal(treeOf(1, 2, 3, 4, 6, 5, 7))
        )
    }

    @Test
    fun handlesEmptyAndSingleTrees() {
        assertEquals(emptyList<List<Int>>(), solution.verticalTraversal(null))
        assertEquals(listOf(listOf(42)), solution.verticalTraversal(treeOf(42)))
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
