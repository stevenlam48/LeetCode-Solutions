package countnodesequaltoaverageofsubtree

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountNodesEqualToAverageOfSubtreeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(5, solution.averageOfSubtree(treeOf(4, 8, 5, 0, 1, null, 6)))
    }

    @Test
    fun testSingleNode() {
        assertEquals(1, solution.averageOfSubtree(treeOf(1)))
        assertEquals(1, solution.averageOfSubtree(treeOf(0)))
    }

    @Test
    fun testLeavesMatch() {
        assertEquals(2, solution.averageOfSubtree(treeOf(1, 2, 3)))
    }
}

private fun treeOf(vararg v: Int?): TreeNode? {
    if (v.isEmpty() || v[0] == null) {
        return null
    }
    val root = TreeNode(v[0]!!)
    val q = ArrayDeque<TreeNode>()
    q.addLast(root)
    var i = 1
    while (q.isNotEmpty() && i < v.size) {
        val node = q.removeFirst()
        if (i < v.size) {
            val l = v[i++]
            if (l != null) {
                node.left = TreeNode(l)
                q.addLast(node.left!!)
            }
        }
        if (i < v.size) {
            val r = v[i++]
            if (r != null) {
                node.right = TreeNode(r)
                q.addLast(node.right!!)
            }
        }
    }
    return root
}
