package secondminimumnodeinabinarytree

// Time:  O(n)
// Space: O(h)

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.ArrayDeque

class SecondMinimumNodeInABinaryTreeTest {
    @Test
    fun exampleWithSecondMinimum() {
        assertEquals(5, Solution().findSecondMinimumValue(treeOf(2, 2, 5, null, null, 5, 7)))
    }

    @Test
    fun allValuesEqual() {
        assertEquals(-1, Solution().findSecondMinimumValue(treeOf(2, 2, 2)))
    }

    @Test
    fun secondMinimumAtRoot() {
        assertEquals(8, Solution().findSecondMinimumValue(treeOf(5, 8, 5)))
    }

    @Test
    fun emptyTree() {
        assertEquals(-1, Solution().findSecondMinimumValue(null))
    }

    @Test
    fun skewedTree() {
        assertEquals(2, Solution().findSecondMinimumValue(treeOf(1, null, 2, null, 2, null, 7)))
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
        values[i++]?.let {
            node.left = TreeNode(it)
            queue.add(node.left!!)
        }
        if (i < values.size) {
            values[i++]?.let {
                node.right = TreeNode(it)
                queue.add(node.right!!)
            }
        }
    }
    return root
}
