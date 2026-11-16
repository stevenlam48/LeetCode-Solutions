package operationsontree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OperationsOnTreeTest {
    @Test
    fun testExample() {
        val tree = LockingTree(intArrayOf(-1, 0, 0, 1, 1, 2, 2))
        assertTrue(tree.lock(2, 2))
        assertFalse(tree.unlock(2, 3))
        assertTrue(tree.unlock(2, 2))
        assertTrue(tree.lock(4, 5))
        assertTrue(tree.upgrade(0, 1))
        assertFalse(tree.lock(0, 1))
    }

    @Test
    fun testUpgradeFailsWithLockedAncestor() {
        val tree = LockingTree(intArrayOf(-1, 0, 0, 1, 1, 2, 2))
        assertTrue(tree.lock(0, 1))
        assertTrue(tree.lock(4, 2))
        assertFalse(tree.upgrade(4, 3))
    }

    @Test
    fun testUpgradeFailsWithoutLockedDescendant() {
        val tree = LockingTree(intArrayOf(-1, 0, 0, 1, 1, 2, 2))
        assertFalse(tree.upgrade(0, 1))
    }

    @Test
    fun testUpgradeUnlocksDescendants() {
        val tree = LockingTree(intArrayOf(-1, 0, 0, 1, 1, 2, 2))
        assertTrue(tree.lock(3, 1))
        assertTrue(tree.lock(4, 2))
        assertTrue(tree.upgrade(1, 3))
        assertFalse(tree.unlock(3, 1))
        assertFalse(tree.unlock(4, 2))
        assertFalse(tree.unlock(1, 1))
        assertTrue(tree.unlock(1, 3))
    }
}
