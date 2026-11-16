package binarysearchtreeiterator

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BinarySearchTreeIteratorTest {
    @Test
    fun exampleSequence() {
        val it = BSTIterator(treeOf(7, 3, 15, null, null, 9, 20))
        assertEquals(3, it.next())
        assertEquals(7, it.next())
        assertTrue(it.hasNext())
        assertEquals(9, it.next())
        assertTrue(it.hasNext())
        assertEquals(15, it.next())
        assertTrue(it.hasNext())
        assertEquals(20, it.next())
        assertFalse(it.hasNext())
    }

    @Test
    fun singleNode() {
        val it = BSTIterator(treeOf(1))
        assertTrue(it.hasNext())
        assertEquals(1, it.next())
        assertFalse(it.hasNext())
    }

    @Test
    fun emptyTree() {
        val it = BSTIterator(null)
        assertFalse(it.hasNext())
    }

    @Test
    fun leftSpine() {
        val it = BSTIterator(treeOf(3, 2, null, 1))
        assertEquals(1, it.next())
        assertEquals(2, it.next())
        assertEquals(3, it.next())
        assertFalse(it.hasNext())
    }
}

private fun treeOf(vararg v: Int?): TreeNode? {
    if (v.isEmpty() || v[0] == null) {
        return null
    }
    val root = TreeNode(v[0]!!)
    val q = ArrayDeque<TreeNode>()
    q.add(root)
    var i = 1
    while (i < v.size && q.isNotEmpty()) {
        val node = q.removeFirst()
        if (i < v.size) {
            val x = v[i++]
            if (x != null) {
                node.left = TreeNode(x)
                q.add(node.left!!)
            }
        }
        if (i < v.size) {
            val x = v[i++]
            if (x != null) {
                node.right = TreeNode(x)
                q.add(node.right!!)
            }
        }
    }
    return root
}
