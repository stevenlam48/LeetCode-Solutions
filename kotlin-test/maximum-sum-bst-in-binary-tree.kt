package maximumsumbstinbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumBstInBinaryTreeTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        val root = treeOf(
            1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6
        )
        assertEquals(20, solution.maxSumBST(root))
    }

    @Test
    fun secondExample() {
        assertEquals(2, solution.maxSumBST(treeOf(4, 3, null, 1, 2)))
    }

    @Test
    fun negativeValuesDoNotProduceNegativeAnswer() {
        assertEquals(0, solution.maxSumBST(treeOf(-4, null, -2, -5)))
    }

    @Test
    fun validSubtreeIsBelowInvalidRoot() {
        assertEquals(7, solution.maxSumBST(treeOf(5, 4, 8, 3, null, 6, 3)))
    }

    @Test
    fun emptyTree() {
        assertEquals(0, solution.maxSumBST(null))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val nodes = values.map { it?.let(::TreeNode) }
    val root = nodes[0]
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root!!)
    var i = 1
    while (queue.isNotEmpty() && i < nodes.size) {
        val node = queue.removeFirst()
        if (i < nodes.size) {
            node.left = nodes[i++]
            node.left?.let(queue::addLast)
        }
        if (i < nodes.size) {
            node.right = nodes[i++]
            node.right?.let(queue::addLast)
        }
    }
    return root
}
