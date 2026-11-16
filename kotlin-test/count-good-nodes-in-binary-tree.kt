package countgoodnodesinbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountGoodNodesInBinaryTreeTest {
    private val solution = Solution()

    @Test
    fun countsFirstExample() {
        assertEquals(4, solution.goodNodes(treeOf(3, 1, 4, 3, null, 1, 5)))
    }

    @Test
    fun countsSecondExampleWithEqualValues() {
        assertEquals(3, solution.goodNodes(treeOf(3, 3, null, 4, 2)))
    }

    @Test
    fun singleNodeIsGood() {
        assertEquals(1, solution.goodNodes(treeOf(1)))
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
            queue.add(node.left!!)
        }
        ++i
        if (i < values.size && values[i] != null) {
            node.right = TreeNode(values[i]!!)
            queue.add(node.right!!)
        }
        ++i
    }
    return root
}
