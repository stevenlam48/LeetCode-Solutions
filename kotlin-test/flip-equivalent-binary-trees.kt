package flipequivalentbinarytrees

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FlipEquivalentBinaryTreesTest {
    private val solution = Solution()

    @Test
    fun recognizesTreesEquivalentAfterSeveralFlips() {
        val root1 = treeOf(1, 2, 3, 4, 5, 6, null, null, null, 7, 8)
        val root2 = treeOf(1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7)

        assertTrue(solution.flipEquiv(root1, root2))
    }

    @Test
    fun rejectsTreesWithDifferentValues() {
        val root1 = treeOf(1, 2, 3)
        val root2 = treeOf(1, 2, 4)

        assertFalse(solution.flipEquiv(root1, root2))
    }

    @Test
    fun rejectsTreesWithDifferentStructures() {
        val root1 = treeOf(1, 2, 2)
        val root2 = treeOf(1, 2, null, 2)

        assertFalse(solution.flipEquiv(root1, root2))
    }

    @Test
    fun handlesNullAndSingleNodeTrees() {
        assertTrue(solution.flipEquiv(null, null))
        assertFalse(solution.flipEquiv(null, treeOf(1)))
        assertTrue(solution.flipEquiv(treeOf(1), treeOf(1)))
        assertFalse(solution.flipEquiv(treeOf(1), treeOf(2)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty()) {
        return null
    }
    val rootValue = values[0] ?: return null
    val root = TreeNode(rootValue)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.removeFirst()
        values[i]?.let {
            val child = TreeNode(it)
            node.left = child
            queue.add(child)
        }
        i++
        if (i < values.size) {
            values[i]?.let {
                val child = TreeNode(it)
                node.right = child
                queue.add(child)
            }
            i++
        }
    }
    return root
}
