package flatten

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class FlattenTest {
    @Test
    fun example() {
        val root = treeOf(1, 2, 5, 3, 4, null, 6)
        Solution().flatten(root)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6), rightChain(root))
    }

    @Test
    fun emptyTree() {
        val root = treeOf()
        Solution().flatten(root)
        assertNull(root)
    }

    @Test
    fun singleNode() {
        val root = treeOf(0)
        Solution().flatten(root)
        assertArrayEquals(intArrayOf(0), rightChain(root))
    }

    @Test
    fun onlyLeftChild() {
        val root = treeOf(1, 2)
        Solution().flatten(root)
        assertArrayEquals(intArrayOf(1, 2), rightChain(root))
    }

    @Test
    fun onlyRightChild() {
        val root = treeOf(1, null, 2)
        Solution().flatten(root)
        assertArrayEquals(intArrayOf(1, 2), rightChain(root))
    }

    private fun rightChain(root: TreeNode?): IntArray {
        val result = mutableListOf<Int>()
        var curr = root
        while (curr != null) {
            result.add(curr.`val`)
            assertNull(curr.left)
            curr = curr.right
        }
        return result.toIntArray()
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
                val l = v[i++]
                if (l != null) {
                    node.left = TreeNode(l)
                    queue.addLast(node.left!!)
                }
            }
            if (i < v.size) {
                val r = v[i++]
                if (r != null) {
                    node.right = TreeNode(r)
                    queue.addLast(node.right!!)
                }
            }
        }
        return root
    }
}
