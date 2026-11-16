package mergebststocreatesinglebst

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class MergeBstsToCreateSingleBstTest {
    @Test
    fun exampleOne() {
        val trees = listOf(treeOf(2, 1)!!, treeOf(3, 2, 5)!!, treeOf(5, 4)!!)
        assertEquals(listOf(3, 2, 5, 1, null, 4), levelOrder(Solution().canMerge(trees)))
    }

    @Test
    fun invalidOrdering() {
        val trees = listOf(treeOf(5, 3, 8)!!, treeOf(3, 2, 6)!!)
        assertNull(Solution().canMerge(trees))
    }

    @Test
    fun noUniqueRoot() {
        assertNull(Solution().canMerge(listOf(treeOf(5, 4)!!, treeOf(3)!!)))
    }

    @Test
    fun singleTreeAndTwoTreeMerge() {
        assertEquals(listOf(1), levelOrder(Solution().canMerge(listOf(treeOf(1)!!))))
        val trees = listOf(treeOf(2, 1)!!, treeOf(3, 2)!!)
        assertEquals(listOf(3, 2, null, 1), levelOrder(Solution().canMerge(trees)))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (i < values.size && queue.isNotEmpty()) {
        val node = queue.removeFirst()
        values[i++]?.let {
            node.left = TreeNode(it)
            queue.add(node.left!!)
        }
        if (i < values.size) {
            values[i++]?.let {
                node.right = TreeNode(it)
                queue.add(node.right!!)
            }
        }
    }
    return root
}

private fun levelOrder(root: TreeNode?): List<Int?> {
    if (root == null) return emptyList()
    val result = mutableListOf<Int?>()
    val queue = ArrayDeque<TreeNode?>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        if (node == null) {
            result.add(null)
        } else {
            result.add(node.`val`)
            queue.add(node.left)
            queue.add(node.right)
        }
    }
    while (result.isNotEmpty() && result.last() == null) {
        result.removeAt(result.size - 1)
    }
    return result
}
