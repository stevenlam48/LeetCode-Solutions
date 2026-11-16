package sametree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SameTreeTest {
    @Test
    fun leetCodeExampleIdentical() {
        assertTrue(Solution().isSameTree(treeOf(1, 2, 3), treeOf(1, 2, 3)))
    }

    @Test
    fun leetCodeExampleDifferentShape() {
        assertFalse(Solution().isSameTree(treeOf(1, 2), treeOf(1, null, 2)))
    }

    @Test
    fun leetCodeExampleSwappedChildren() {
        assertFalse(Solution().isSameTree(treeOf(1, 2, 1), treeOf(1, 1, 2)))
    }

    @Test
    fun bothEmpty() {
        assertTrue(Solution().isSameTree(null, null))
    }

    @Test
    fun oneEmpty() {
        assertFalse(Solution().isSameTree(null, treeOf(1)))
        assertFalse(Solution().isSameTree(treeOf(1), null))
    }

    @Test
    fun differentValues() {
        assertFalse(Solution().isSameTree(treeOf(1, 2, 3), treeOf(1, 2, 4)))
    }
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
        val left = v[i++]
        if (left != null) {
            node.left = TreeNode(left)
            queue.addLast(node.left!!)
        }
        if (i < v.size) {
            val right = v[i++]
            if (right != null) {
                node.right = TreeNode(right)
                queue.addLast(node.right!!)
            }
        }
    }
    return root
}
