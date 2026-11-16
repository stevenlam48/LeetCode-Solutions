package boundaryofbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BoundaryOfBinaryTreeTest {
    @Test
    fun example1() {
        val root = treeOf(1, null, 2, 3, 4)
        assertEquals(listOf(1, 3, 4, 2), Solution().boundaryOfBinaryTree(root))
    }

    @Test
    fun singleNode() {
        assertEquals(listOf(1), Solution().boundaryOfBinaryTree(treeOf(1)))
    }

    @Test
    fun leftOnly() {
        assertEquals(listOf(1, 2), Solution().boundaryOfBinaryTree(treeOf(1, 2)))
    }

    @Test
    fun rightOnly() {
        assertEquals(listOf(1, 2), Solution().boundaryOfBinaryTree(treeOf(1, null, 2)))
    }

    @Test
    fun fullSmallTree() {
        assertEquals(listOf(1, 2, 3), Solution().boundaryOfBinaryTree(treeOf(1, 2, 3)))
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<Int>(), Solution().boundaryOfBinaryTree(null))
    }

    private fun treeOf(vararg v: Int?): TreeNode? {
        if (v.isEmpty() || v[0] == null) {
            return null
        }
        val root = TreeNode(v[0]!!)
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var i = 1
        while (queue.isNotEmpty() && i < v.size) {
            val node = queue.removeFirst()
            if (i < v.size) {
                val l = v[i++]
                if (l != null) {
                    node.left = TreeNode(l)
                    queue.add(node.left!!)
                }
            }
            if (i < v.size) {
                val r = v[i++]
                if (r != null) {
                    node.right = TreeNode(r)
                    queue.add(node.right!!)
                }
            }
        }
        return root
    }
}
