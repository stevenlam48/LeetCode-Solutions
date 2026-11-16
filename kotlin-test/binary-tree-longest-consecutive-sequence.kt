package binarytreelongestconsecutivesequence

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeLongestConsecutiveSequenceTest {
    @Test
    fun rightLeaningSequence() {
        val root = treeOf(1, null, 3, 2, 4, null, null, null, 5)
        assertEquals(3, Solution().longestConsecutive(root))
    }

    @Test
    fun brokenChildSequence() {
        assertEquals(2, Solution().longestConsecutive(treeOf(2, null, 3, 2, null, 1)))
    }

    @Test
    fun decreasingValues() {
        assertEquals(1, Solution().longestConsecutive(treeOf(3, 2, 1)))
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
