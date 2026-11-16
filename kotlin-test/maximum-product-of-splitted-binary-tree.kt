package maximumproductofsplittedbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfSplittedBinaryTreeTest {
    @Test
    fun example1() {
        assertEquals(110, Solution().maxProduct(treeOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun example2() {
        assertEquals(90, Solution().maxProduct(treeOf(1, null, 2, 3, 4, null, null, 5, 6)))
    }

    @Test
    fun singleNode() {
        assertEquals(0, Solution().maxProduct(treeOf(1)))
    }

    @Test
    fun twoNodes() {
        assertEquals(2, Solution().maxProduct(treeOf(1, 2)))
    }

    @Test
    fun largeValues() {
        assertEquals(200000000, Solution().maxProduct(treeOf(10000, 10000, 10000)))
    }
}

private fun treeOf(vararg v: Int?): TreeNode? {
    if (v.isEmpty() || v[0] == null) {
        return null
    }
    val root = TreeNode(v[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    var i = 1
    while (queue.isNotEmpty() && i < v.size) {
        val node = queue.removeFirst()
        if (i < v.size) {
            val left = v[i++]
            if (left != null) {
                node.left = TreeNode(left)
                queue.addLast(node.left!!)
            }
        }
        if (i < v.size) {
            val right = v[i++]
            if (right != null) {
                node.right = TreeNode(right)
                queue.addLast(node.right!!)
            }
        }
    }
    return root
}
