package sumofnodeswithevenvaluedgrandparent

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfNodesWithEvenValuedGrandparentTest {
    private val solution = Solution()

    @Test
    fun exampleTree() {
        val root = treeOf(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5)
        assertEquals(18, solution.sumEvenGrandparent(root))
    }

    @Test
    fun emptyTree() {
        assertEquals(0, solution.sumEvenGrandparent(null))
    }

    @Test
    fun evenRootWithOnlyChildren() {
        assertEquals(0, solution.sumEvenGrandparent(treeOf(2, 4, 6)))
    }

    @Test
    fun grandchildInChain() {
        assertEquals(3, solution.sumEvenGrandparent(treeOf(2, 1, null, 3)))
    }

    @Test
    fun oddValuedTree() {
        assertEquals(0, solution.sumEvenGrandparent(treeOf(1, 3, 5, 7, 9)))
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
