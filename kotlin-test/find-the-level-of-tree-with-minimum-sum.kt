package findtheleveloftreewithminimumsum

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheLevelOfTreeWithMinimumSumTest {
    @Test
    fun example() {
        assertEquals(2, Solution().minimumLevel(treeOf(50, 6, 2, 30, 80, 7, 85)))
    }

    @Test
    fun deepestLevelHasMinimumSum() {
        assertEquals(3, Solution().minimumLevel(treeOf(1, 2, 3, 4, null, null, -10)))
    }

    @Test
    fun tiesUseShallowestLevel() {
        assertEquals(1, Solution().minimumLevel(treeOf(5, 2, 3)))
    }

    @Test
    fun singleNode() {
        assertEquals(1, Solution().minimumLevel(treeOf(-7)))
    }

    @Test
    fun negativeMiddleLevel() {
        assertEquals(2, Solution().minimumLevel(treeOf(10, -20, 5, 100, 100)))
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
