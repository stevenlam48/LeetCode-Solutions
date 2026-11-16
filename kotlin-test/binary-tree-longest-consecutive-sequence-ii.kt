package binarytreelongestconsecutivesequenceii

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeLongestConsecutiveSequenceIiTest {
    @Test
    fun increasingRootToLeafPath() {
        assertEquals(2, Solution().longestConsecutive(treeOf(1, 2, 3)))
    }

    @Test
    fun pathCanChangeDirectionAtRoot() {
        assertEquals(3, Solution().longestConsecutive(treeOf(2, 1, 3)))
    }

    @Test
    fun pathCanChangeDirectionAtInternalNode() {
        val root = treeOf(2, 1, 3, null, null, 4)
        assertEquals(4, Solution().longestConsecutive(root))
    }

    @Test
    fun emptyTree() {
        assertEquals(0, Solution().longestConsecutive(null))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.removeFirst()
        values[i++]?.let {
            val child = TreeNode(it)
            node.left = child
            queue.add(child)
        }
        if (i < values.size) {
            values[i++]?.let {
                val child = TreeNode(it)
                node.right = child
                queue.add(child)
            }
        }
    }
    return root
}
