package countnodesthataregreatenough

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountNodesThatAreGreatEnoughTest {
    private val solution = Solution()

    @Test
    fun testExampleK2() {
        assertEquals(3, solution.countGreatEnoughNodes(treeOf(7, 6, 5, 4, 3, 2, 1), 2))
    }

    @Test
    fun testExampleK3() {
        assertEquals(1, solution.countGreatEnoughNodes(treeOf(7, 6, 5, 4, 3, 2, 1), 3))
    }

    @Test
    fun testSingleNode() {
        assertEquals(0, solution.countGreatEnoughNodes(treeOf(1), 1))
    }

    @Test
    fun testRootOnly() {
        assertEquals(1, solution.countGreatEnoughNodes(treeOf(3, 1, 2), 1))
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
