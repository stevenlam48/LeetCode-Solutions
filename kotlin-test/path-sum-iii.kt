package pathsumiii

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PathSumIIITest {
    private val solution = Solution()

    @Test
    fun countsPathsWithPositiveAndNegativeValues() {
        val root = treeOf(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1)
        assertEquals(3, solution.pathSum(root, 8))
    }

    @Test
    fun countsPathsInSecondExampleTree() {
        val root = treeOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1)
        assertEquals(3, solution.pathSum(root, 22))
    }

    @Test
    fun countsZeroSumPathsCorrectly() {
        assertEquals(3, solution.pathSum(treeOf(0, 0), 0))
    }

    @Test
    fun handlesEmptyTree() {
        assertEquals(0, solution.pathSum(null, 8))
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
            queue.add(node.left)
        }
        ++i
        if (i < values.size && values[i] != null) {
            node.right = TreeNode(values[i]!!)
            queue.add(node.right)
        }
        ++i
    }
    return root
}
