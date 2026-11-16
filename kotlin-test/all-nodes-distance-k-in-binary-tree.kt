package allnodesdistancekinbinarytree

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AllNodesDistanceKInBinaryTreeTest {
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

    private fun TreeNode.find(target: Int): TreeNode? {
        if (`val` == target) {
            return this
        }
        return left?.find(target) ?: right?.find(target)
    }

    @Test
    fun testExample1() {
        val root = treeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        assertEquals(listOf(7, 4, 1).sorted(), Solution().distanceK(root, root!!.find(5)!!, 2).sorted())
    }

    @Test
    fun testZeroDistance() {
        val root = treeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        assertEquals(listOf(5), Solution().distanceK(root, root!!.find(5)!!, 0))
    }

    @Test
    fun testDistanceThree() {
        val root = treeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        assertEquals(listOf(0, 8).sorted(), Solution().distanceK(root, root!!.find(5)!!, 3).sorted())
    }

    @Test
    fun testSingleNode() {
        val root = TreeNode(1)
        assertEquals(listOf(1), Solution().distanceK(root, root, 0))
        assertEquals(emptyList<Int>(), Solution().distanceK(root, root, 1))
    }
}
