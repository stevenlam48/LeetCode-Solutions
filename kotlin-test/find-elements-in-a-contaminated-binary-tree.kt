package findelementsinacontaminatedbinarytree

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindElementsInAContaminatedBinaryTreeTest {
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

    @Test
    fun rightChildOnly() {
        val findElements = FindElements(treeOf(-1, null, -1))
        assertFalse(findElements.find(1))
        assertTrue(findElements.find(2))
    }

    @Test
    fun fullTree() {
        val findElements = FindElements(treeOf(-1, -1, -1, -1, -1))
        assertTrue(findElements.find(0))
        assertTrue(findElements.find(1))
        assertTrue(findElements.find(2))
        assertTrue(findElements.find(3))
        assertTrue(findElements.find(4))
        assertFalse(findElements.find(5))
    }

    @Test
    fun singleNode() {
        val findElements = FindElements(treeOf(-1))
        assertTrue(findElements.find(0))
        assertFalse(findElements.find(1))
    }

    @Test
    fun leftChain() {
        val findElements = FindElements(treeOf(-1, -1, null, -1))
        assertTrue(findElements.find(0))
        assertTrue(findElements.find(1))
        assertTrue(findElements.find(3))
        assertFalse(findElements.find(2))
    }
}
