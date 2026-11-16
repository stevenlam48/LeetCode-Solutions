package balanceabinarysearchtree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val nodes = arrayOfNulls<TreeNode>(values.size)
    for (i in values.indices) {
        values[i]?.let { nodes[i] = TreeNode(it) }
    }
    for (i in values.indices) {
        val node = nodes[i] ?: continue
        val left = 2 * i + 1
        val right = left + 1
        if (left < nodes.size) {
            node.left = nodes[left]
        }
        if (right < nodes.size) {
            node.right = nodes[right]
        }
    }
    return nodes[0]
}

private fun levelOrder(root: TreeNode?): List<Int?> {
    if (root == null) {
        return emptyList()
    }
    val result = mutableListOf<Int?>()
    val queue = ArrayDeque<TreeNode?>()
    queue.addLast(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        result.add(node?.`val`)
        if (node != null) {
            queue.addLast(node.left)
            queue.addLast(node.right)
        }
    }
    while (result.lastOrNull() == null) {
        result.removeAt(result.lastIndex)
    }
    return result
}

class BalanceABinarySearchTreeTest {
    private val solution = Solution()

    @Test
    fun balancesThreeNodeRightChain() {
        val root = treeOf(1, null, 2, null, null, null, 3)
        assertEquals(listOf(2, 1, 3), levelOrder(solution.balanceBST(root)))
    }

    @Test
    fun balancesEvenNumberOfNodes() {
        val root = TreeNode(1)
        root.right = TreeNode(2)
        root.right!!.right = TreeNode(3)
        root.right!!.right!!.right = TreeNode(4)
        assertEquals(listOf(3, 2, 4, 1), levelOrder(solution.balanceBST(root)))
    }

    @Test
    fun emptyTree() {
        assertNull(solution.balanceBST(null))
    }

    @Test
    fun singleNodeAndAlreadyBalancedTree() {
        assertEquals(listOf(7), levelOrder(solution.balanceBST(TreeNode(7))))
        val root = treeOf(4, 2, 6, 1, 3, 5, 7)
        assertEquals(listOf(4, 2, 6, 1, 3, 5, 7), levelOrder(solution.balanceBST(root)))
    }
}
