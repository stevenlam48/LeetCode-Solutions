package minimumnumberofoperationstosortabinarytreebylevel

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToSortABinaryTreeByLevelTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        val root = treeOf(1, 4, 3, 7, 6, 8, 5, null, null, null, null, 9, null, null, 10)
        assertEquals(3, solution.minimumOperations(root))
    }

    @Test
    fun secondExample() {
        val root = treeOf(1, 3, 2, 7, 6, 5, 4)
        assertEquals(3, solution.minimumOperations(root))
    }

    @Test
    fun alreadySorted() {
        val root = treeOf(1, 2, 3, 4, 5, 6)
        assertEquals(0, solution.minimumOperations(root))
    }

    @Test
    fun singleNode() {
        assertEquals(0, solution.minimumOperations(treeOf(1)))
    }

    @Test
    fun swapsRootChildren() {
        assertEquals(1, solution.minimumOperations(treeOf(2, 3, 1)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = java.util.ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (i < values.size) {
        val node = queue.removeFirst()
        values[i]?.let {
            val child = TreeNode(it)
            node.left = child
            queue.add(child)
        }
        ++i
        if (i < values.size) {
            values[i]?.let {
                val child = TreeNode(it)
                node.right = child
                queue.add(child)
            }
            ++i
        }
    }
    return root
}
