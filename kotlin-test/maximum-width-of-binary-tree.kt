package maximumwidthofbinarytree

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumWidthOfBinaryTreeTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(4, solution.widthOfBinaryTree(treeOf(1, 3, 2, 5, 3, null, 9)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(7, solution.widthOfBinaryTree(treeOf(1, 3, 2, 5, null, null, 9, 6, null, 7)))
    }

    @Test
    fun exampleThree() {
        assertEquals(2, solution.widthOfBinaryTree(treeOf(1, 3, 2, 5)))
    }

    @Test
    fun singleNode() {
        assertEquals(1, solution.widthOfBinaryTree(treeOf(1)))
    }

    @Test
    fun emptyTree() {
        assertEquals(0, solution.widthOfBinaryTree(null))
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
