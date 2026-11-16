package medianofabinarysearchtreelevel

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MedianOfABinarySearchTreeLevelTest {
    @Test
    fun rootLevel() {
        assertEquals(3, Solution().levelMedian(treeOf(3, 9, 20, null, null, 15, 7)!!, 0))
    }

    @Test
    fun evenSizedLevelUsesUpperMedian() {
        assertEquals(20, Solution().levelMedian(treeOf(3, 9, 20, null, null, 15, 7)!!, 1))
        assertEquals(7, Solution().levelMedian(treeOf(3, 9, 20, null, null, 15, 7)!!, 2))
    }

    @Test
    fun oddSizedLevel() {
        assertEquals(7, Solution().levelMedian(treeOf(10, 5, 20, 1, 7, 15)!!, 2))
    }

    @Test
    fun missingLevel() {
        assertEquals(-1, Solution().levelMedian(treeOf(1)!!, 2))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (i < values.size && queue.isNotEmpty()) {
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
