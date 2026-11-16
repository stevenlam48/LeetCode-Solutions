package diameterofbinarytree

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DiameterOfBinaryTreeTest {
    private val solution = Solution()

    @Test
    fun diameterPassesThroughRoot() {
        assertEquals(3, solution.diameterOfBinaryTree(treeOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun singleChildGivesOneEdge() {
        assertEquals(1, solution.diameterOfBinaryTree(treeOf(1, 2)))
    }

    @Test
    fun diameterCanBeEntirelyInSubtree() {
        assertEquals(4, solution.diameterOfBinaryTree(treeOf(1, 2, null, 3, null, 4, null, 5)))
    }

    @Test
    fun emptyAndSingleNodeTreesHaveZeroDiameter() {
        assertEquals(0, solution.diameterOfBinaryTree(null))
        assertEquals(0, solution.diameterOfBinaryTree(treeOf(1)))
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
    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.removeFirst()
        if (i < values.size && values[i] != null) {
            node.left = TreeNode(values[i]!!)
            queue.add(node.left)
        }
        ++i
        if (i < values.size && values[i] != null) {
            node.right = TreeNode(values[i]!!)
            queue.add(node.right)
        }
        ++i
    }
    return root
}
