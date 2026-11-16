package printbinarytree

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrintBinaryTreeTest {
    @Test
    fun exampleOne() {
        val expected = listOf(listOf("", "1", ""), listOf("2", "", ""))
        assertEquals(expected, Solution().printTree(treeOf(1, 2)))
    }

    @Test
    fun exampleTwo() {
        val expected = listOf(
            listOf("", "", "", "1", "", "", ""),
            listOf("", "2", "", "", "", "3", ""),
            listOf("", "", "4", "", "", "", "")
        )
        assertEquals(expected, Solution().printTree(treeOf(1, 2, 3, null, 4)))
    }

    @Test
    fun singleNode() {
        assertEquals(listOf(listOf("1")), Solution().printTree(treeOf(1)))
    }

    @Test
    fun fullTwoLevels() {
        val expected = listOf(listOf("", "1", ""), listOf("2", "", "3"))
        assertEquals(expected, Solution().printTree(treeOf(1, 2, 3)))
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
