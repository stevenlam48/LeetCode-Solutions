package minimumflipsinbinarytreetogetresult

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumFlipsInBinaryTreeToGetResultTest {
    @Test
    fun leafZeroToTrue() {
        assertEquals(1, Solution().minimumFlips(treeOf(0), true))
    }

    @Test
    fun leafOneAlreadyTrue() {
        assertEquals(0, Solution().minimumFlips(treeOf(1), true))
    }

    @Test
    fun orOfTwoZerosToTrue() {
        assertEquals(1, Solution().minimumFlips(treeOf(2, 0, 0), true))
    }

    @Test
    fun andWithZeroToTrue() {
        assertEquals(1, Solution().minimumFlips(treeOf(3, 1, 0), true))
    }

    @Test
    fun xorOfTwoOnesToTrue() {
        assertEquals(1, Solution().minimumFlips(treeOf(4, 1, 1), true))
    }

    @Test
    fun notWithLeftChildToFalse() {
        assertEquals(0, Solution().minimumFlips(treeOf(5, 1), false))
    }

    @Test
    fun notWithRightChildToTrue() {
        assertEquals(0, Solution().minimumFlips(treeOf(5, null, 0), true))
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
            if (v[i] != null) {
                node.left = TreeNode(v[i]!!)
                q.addLast(node.left!!)
            }
            ++i
        }
        if (i < v.size) {
            if (v[i] != null) {
                node.right = TreeNode(v[i]!!)
                q.addLast(node.right!!)
            }
            ++i
        }
    }
    return root
}
