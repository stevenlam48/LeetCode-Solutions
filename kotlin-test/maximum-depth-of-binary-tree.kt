package maximumdepthofbinarytree

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDepthOfBinaryTreeTest {
    @Test
    fun example() {
        assertEquals(3, Solution().maxDepth(treeOf(3, 9, 20, null, null, 15, 7)))
    }

    @Test
    fun emptyTree() {
        assertEquals(0, Solution().maxDepth(treeOf()))
    }

    @Test
    fun singleNode() {
        assertEquals(1, Solution().maxDepth(treeOf(1)))
    }

    @Test
    fun skewedTree() {
        assertEquals(3, Solution().maxDepth(treeOf(1, null, 2, null, 3)))
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
