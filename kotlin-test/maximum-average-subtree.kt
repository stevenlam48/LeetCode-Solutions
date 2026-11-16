package maximumaveragesubtree

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAverageSubtreeTest {
    @Test
    fun example() {
        assertEquals(6.0, Solution().maximumAverageSubtree(treeOf(5, 6, 1)), 1e-9)
    }

    @Test
    fun singleZero() {
        assertEquals(0.0, Solution().maximumAverageSubtree(treeOf(0)), 1e-9)
    }

    @Test
    fun singlePositive() {
        assertEquals(5.0, Solution().maximumAverageSubtree(treeOf(5)), 1e-9)
    }

    @Test
    fun deeperTree() {
        assertEquals(3.0, Solution().maximumAverageSubtree(treeOf(1, 2, 3)), 1e-9)
    }

    @Test
    fun allNegativeStaysAtZero() {
        assertEquals(0.0, Solution().maximumAverageSubtree(treeOf(-1)), 1e-9)
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var index = 1
    while (index < values.size) {
        val curr = queue.removeFirst()
        values[index]?.let {
            curr.left = TreeNode(it)
            queue.add(curr.left!!)
        }
        index++
        if (index < values.size) {
            values[index]?.let {
                curr.right = TreeNode(it)
                queue.add(curr.right!!)
            }
            index++
        }
    }
    return root
}
