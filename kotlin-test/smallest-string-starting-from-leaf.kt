package smalleststringstartingfromleaf

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = mutableListOf(root)
    var index = 1
    while (queue.isNotEmpty() && index < values.size) {
        val node = queue.removeAt(0)
        if (index < values.size) {
            values[index]?.let {
                node.left = TreeNode(it)
                queue.add(node.left!!)
            }
            ++index
        }
        if (index < values.size) {
            values[index]?.let {
                node.right = TreeNode(it)
                queue.add(node.right!!)
            }
            ++index
        }
    }
    return root
}

class SmallestStringStartingFromLeafTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals("dba", solution.smallestFromLeaf(treeOf(0, 1, 2, 3, 4, 3, 4)))
        assertEquals("adz", solution.smallestFromLeaf(treeOf(25, 1, 3, 1, 3, 0, 2)))
    }

    @Test
    fun singleNode() {
        assertEquals("z", solution.smallestFromLeaf(treeOf(25)))
    }

    @Test
    fun unequalDepths() {
        assertEquals("ca", solution.smallestFromLeaf(treeOf(0, 2, 1, null, null, 2)))
    }
}
