package houserobberiii

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HouseRobberIiiTest {
    @Test
    fun firstStandardExample() {
        assertEquals(7, Solution().rob(treeOf(3, 2, 3, null, 3, null, 1)))
    }

    @Test
    fun secondStandardExample() {
        assertEquals(9, Solution().rob(treeOf(3, 4, 5, 1, 3, null, 1)))
    }

    @Test
    fun rootAndGrandchildrenCanBeCombined() {
        assertEquals(210, Solution().rob(treeOf(10, 1, 1, 100, null, null, 100)))
    }

    @Test
    fun emptyAndSingleNode() {
        assertEquals(0, Solution().rob(null))
        assertEquals(5, Solution().rob(treeOf(5)))
    }

    @Test
    fun negativeValuesCanBeSkipped() {
        assertEquals(0, Solution().rob(treeOf(-1, -2, -3)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    var i = 1
    while (i < values.size) {
        val node = queue.removeFirst()
        if (i < values.size && values[i] != null) {
            node.left = TreeNode(values[i]!!)
            queue.addLast(node.left!!)
        }
        ++i
        if (i < values.size && values[i] != null) {
            node.right = TreeNode(values[i]!!)
            queue.addLast(node.right!!)
        }
        ++i
    }
    return root
}
