package leafsimilartrees

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.ArrayDeque

class LeafSimilarTreesTest {
    private val solution = Solution()

    @Test
    fun returnsTrueForLeetCodeExample() {
        val root1 = treeOf(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4)
        val root2 = treeOf(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8)
        assertTrue(solution.leafSimilar(root1, root2))
    }

    @Test
    fun returnsFalseForDifferentLeafOrder() {
        assertFalse(solution.leafSimilar(treeOf(1, 2, 3), treeOf(1, 3, 2)))
    }

    @Test
    fun returnsTrueForIdenticalSingleLeaves() {
        assertTrue(solution.leafSimilar(treeOf(7), treeOf(7)))
    }

    @Test
    fun returnsFalseForDifferentSingleLeaves() {
        assertFalse(solution.leafSimilar(treeOf(7), treeOf(8)))
    }

    @Test
    fun returnsFalseForDifferentLeafCounts() {
        assertFalse(solution.leafSimilar(treeOf(1, 2), treeOf(1, 2, 3)))
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
    while (index < values.size && queue.isNotEmpty()) {
        val node = queue.removeFirst()
        values[index]?.let {
            val child = TreeNode(it)
            node.left = child
            queue.add(child)
        }
        ++index
        if (index < values.size) {
            values[index]?.let {
                val child = TreeNode(it)
                node.right = child
                queue.add(child)
            }
            ++index
        }
    }
    return root
}
