package pathSum

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

private fun treeOf(vararg v: Int?): TreeNode? {
    if (v.isEmpty() || v[0] == null) {
        return null
    }
    val root = TreeNode(v[0]!!)
    val q = ArrayDeque<TreeNode>()
    q.add(root)
    var i = 1
    while (i < v.size) {
        val node = q.removeFirst()
        if (i < v.size) {
            val l = v[i++]
            if (l != null) {
                node.left = TreeNode(l)
                q.add(node.left!!)
            }
        }
        if (i < v.size) {
            val r = v[i++]
            if (r != null) {
                node.right = TreeNode(r)
                q.add(node.right!!)
            }
        }
    }
    return root
}

class PathSumTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val root = treeOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1)
        val expected = listOf(listOf(5, 4, 11, 2), listOf(5, 8, 4, 5))
        assertEquals(expected, solution.pathSum(root, 22))
    }

    @Test
    fun testNoPath() {
        val root = treeOf(1, 2, 3)
        assertEquals(emptyList<List<Int>>(), solution.pathSum(root, 5))
    }

    @Test
    fun testEmptyTree() {
        assertEquals(emptyList<List<Int>>(), solution.pathSum(null, 0))
    }

    @Test
    fun testSingleNode() {
        assertEquals(listOf(listOf(1)), solution.pathSum(treeOf(1), 1))
    }

    @Test
    fun testNegativeValues() {
        val root = treeOf(-2, null, -3)
        assertEquals(listOf(listOf(-2, -3)), solution.pathSum(root, -5))
    }
}
