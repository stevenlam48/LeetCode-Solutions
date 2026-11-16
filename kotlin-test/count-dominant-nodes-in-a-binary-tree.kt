package countdominantnodesinabinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountDominantNodesInABinaryTreeTest {
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
    fun singleNode() {
        assertEquals(1, Solution().countDominantNodes(treeOf(1)))
    }

    @Test
    fun childDominatesParent() {
        assertEquals(1, Solution().countDominantNodes(treeOf(1, 2)))
    }

    @Test
    fun rootDominatesChild() {
        assertEquals(2, Solution().countDominantNodes(treeOf(2, 1)))
    }

    @Test
    fun bothLeavesDominant() {
        assertEquals(2, Solution().countDominantNodes(treeOf(1, 2, 3)))
    }

    @Test
    fun largerTree() {
        assertEquals(3, Solution().countDominantNodes(treeOf(3, 1, 4, 3, null, 1, 5)))
    }

    @Test
    fun emptyTree() {
        assertEquals(0, Solution().countDominantNodes(null))
    }
}
