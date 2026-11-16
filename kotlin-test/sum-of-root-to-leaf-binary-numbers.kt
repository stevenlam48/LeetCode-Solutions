package sumofroottoleafbinarynumbers

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfRootToLeafBinaryNumbersTest {
    private val solution = Solution()

    @Test
    fun exampleTree() {
        assertEquals(22, solution.sumRootToLeaf(treeOf(1, 0, 1, 0, 1, 0, 1)))
    }

    @Test
    fun emptyTree() {
        assertEquals(0, solution.sumRootToLeaf(null))
    }

    @Test
    fun singleNode() {
        assertEquals(1, solution.sumRootToLeaf(treeOf(1)))
    }

    @Test
    fun zeroValuedNodes() {
        assertEquals(1, solution.sumRootToLeaf(treeOf(0, 0, 1)))
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
