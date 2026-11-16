package binarytreetilt

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeTiltTest {
    @Test
    fun twoLeaves() {
        assertEquals(1, Solution().findTilt(treeOf(1, 2, 3)))
    }

    @Test
    fun nestedTiltsAreAdded() {
        assertEquals(15, Solution().findTilt(treeOf(4, 2, 9, 3, 5, null, 7)))
    }

    @Test
    fun duplicateLeafValues() {
        val root = treeOf(21, 7, 14, 1, 1, 2, 2, 3, 3)
        assertEquals(9, Solution().findTilt(root))
    }

    @Test
    fun emptyTree() {
        assertEquals(0, Solution().findTilt(null))
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
