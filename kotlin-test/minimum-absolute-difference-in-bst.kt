package minimumabsolutedifferenceinbst

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAbsoluteDifferenceInBstTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().getMinimumDifference(treeOf(4, 2, 6, 1, 3)))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().getMinimumDifference(treeOf(1, 0, 48, null, null, 12, 49)))
    }

    @Test
    fun twoNodes() {
        assertEquals(1, Solution().getMinimumDifference(treeOf(1, null, 2)))
    }

    @Test
    fun threeNodes() {
        assertEquals(1, Solution().getMinimumDifference(treeOf(5, 4, 7)))
    }

    @Test
    fun largerTree() {
        assertEquals(9, Solution().getMinimumDifference(treeOf(236, 104, 701, null, 227, null, 911)))
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
