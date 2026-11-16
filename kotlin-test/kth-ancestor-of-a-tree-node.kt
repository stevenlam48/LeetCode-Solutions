package kthancestorofatreenode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthAncestorOfATreeNodeTest {
    @Test
    fun example1() {
        val treeAncestor = TreeAncestor(7, intArrayOf(-1, 0, 0, 1, 1, 2, 2))
        assertEquals(1, treeAncestor.getKthAncestor(3, 1))
        assertEquals(0, treeAncestor.getKthAncestor(5, 2))
        assertEquals(-1, treeAncestor.getKthAncestor(6, 3))
    }

    @Test
    fun singleNode() {
        val treeAncestor = TreeAncestor(1, intArrayOf(-1))
        assertEquals(0, treeAncestor.getKthAncestor(0, 0))
        assertEquals(-1, treeAncestor.getKthAncestor(0, 1))
    }

    @Test
    fun chain() {
        val treeAncestor = TreeAncestor(5, intArrayOf(-1, 0, 1, 2, 3))
        assertEquals(0, treeAncestor.getKthAncestor(4, 4))
        assertEquals(-1, treeAncestor.getKthAncestor(4, 5))
        assertEquals(2, treeAncestor.getKthAncestor(4, 2))
    }

    @Test
    fun star() {
        val treeAncestor = TreeAncestor(4, intArrayOf(-1, 0, 0, 0))
        assertEquals(0, treeAncestor.getKthAncestor(3, 1))
        assertEquals(-1, treeAncestor.getKthAncestor(3, 2))
    }

    @Test
    fun zeroAncestor() {
        val treeAncestor = TreeAncestor(3, intArrayOf(-1, 0, 1))
        assertEquals(2, treeAncestor.getKthAncestor(2, 0))
    }
}
