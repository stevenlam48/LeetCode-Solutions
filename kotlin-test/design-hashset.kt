package designhashset

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignHashSetTest {
    @Test
    fun addContainsAndRemove() {
        val set = MyHashSet()
        set.add(1)
        set.add(2)
        assertTrue(set.contains(1))
        assertFalse(set.contains(3))
        set.add(2)
        assertTrue(set.contains(2))
        set.remove(2)
        assertFalse(set.contains(2))
    }

    @Test
    fun duplicateAddsHaveNoAdditionalEffect() {
        val set = MyHashSet()
        repeat(3) { set.add(9) }
        set.remove(9)
        assertFalse(set.contains(9))
    }

    @Test
    fun collidingKeysRemainIndependent() {
        val set = MyHashSet()
        set.add(0)
        set.add(10000)
        set.add(20000)
        set.remove(10000)
        assertTrue(set.contains(0))
        assertFalse(set.contains(10000))
        assertTrue(set.contains(20000))
    }

    @Test
    fun removingMissingKeysIsSafe() {
        val set = MyHashSet()
        set.remove(1)
        set.add(1)
        set.remove(2)
        assertTrue(set.contains(1))
    }
}
