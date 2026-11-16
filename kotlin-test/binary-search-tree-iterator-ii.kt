package binarysearchtreeiteratorii

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BinarySearchTreeIteratorIiTest {
    @Test
    fun exampleSequence() {
        val it = BSTIterator(treeOf(7, 3, 15, null, null, 9, 20))
        assertEquals(3, it.next())
        assertEquals(7, it.next())
        assertEquals(3, it.prev())
        assertEquals(7, it.next())
        assertTrue(it.hasNext())
        assertEquals(9, it.next())
        assertEquals(15, it.next())
        assertEquals(20, it.next())
        assertFalse(it.hasNext())
        assertTrue(it.hasPrev())
        assertEquals(15, it.prev())
        assertEquals(9, it.prev())
    }

    @Test
    fun singleNode() {
        val it = BSTIterator(treeOf(1))
        assertFalse(it.hasPrev())
        assertTrue(it.hasNext())
        assertEquals(1, it.next())
        assertFalse(it.hasNext())
        assertFalse(it.hasPrev())
    }

    @Test
    fun walkForwardThenBack() {
        val it = BSTIterator(treeOf(2, 1, 3))
        assertEquals(1, it.next())
        assertEquals(2, it.next())
        assertEquals(3, it.next())
        assertFalse(it.hasNext())
        assertEquals(2, it.prev())
        assertEquals(1, it.prev())
        assertFalse(it.hasPrev())
        assertEquals(2, it.next())
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
