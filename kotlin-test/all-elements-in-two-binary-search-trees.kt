package allelementsintwobinarysearchtrees

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AllElementsInTwoBinarySearchTreesTest {
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
            if (i < v.size && v[i] != null) {
                node.left = TreeNode(v[i]!!)
                queue.addLast(node.left!!)
            }
            ++i
            if (i < v.size && v[i] != null) {
                node.right = TreeNode(v[i]!!)
                queue.addLast(node.right!!)
            }
            ++i
        }
        return root
    }

    @Test
    fun testExample1() {
        val root1 = treeOf(2, 1, 4)
        val root2 = treeOf(1, 0, 3)
        assertEquals(listOf(0, 1, 1, 2, 3, 4), Solution().getAllElements(root1, root2))
    }

    @Test
    fun testExample2() {
        val root1 = treeOf(1, null, 8)
        val root2 = treeOf(8, 1)
        assertEquals(listOf(1, 1, 8, 8), Solution().getAllElements(root1, root2))
    }

    @Test
    fun testOneEmpty() {
        assertEquals(listOf(1), Solution().getAllElements(null, treeOf(1)))
        assertEquals(listOf(1), Solution().getAllElements(treeOf(1), null))
    }

    @Test
    fun testBothEmpty() {
        assertEquals(emptyList<Int>(), Solution().getAllElements(null, null))
    }
}
