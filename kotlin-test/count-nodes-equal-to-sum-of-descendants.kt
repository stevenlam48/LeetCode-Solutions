package countnodesequaltosumofdescendants

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountNodesEqualToSumOfDescendantsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.equalToDescendants(treeOf(10, 3, 4, 2, 1)))
    }

    @Test
    fun testSingleZero() {
        assertEquals(1, solution.equalToDescendants(treeOf(0)))
    }

    @Test
    fun testRootEqualsChildrenSum() {
        assertEquals(1, solution.equalToDescendants(treeOf(5, 2, 3)))
    }

    @Test
    fun testNoMatches() {
        assertEquals(0, solution.equalToDescendants(treeOf(1, 2, 3)))
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
