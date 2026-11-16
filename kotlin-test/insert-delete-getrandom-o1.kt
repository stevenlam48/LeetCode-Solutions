package insertdeletegetrandomo1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class InsertDeleteGetrandomO1Test {
    @Test
    fun insertsOnlyNewValues() {
        val set = RandomizedSet()
        assertTrue(set.insert(1))
        assertFalse(set.insert(1))
        assertTrue(set.insert(2))
    }

    @Test
    fun removesExistingValuesAndSwapsLastElement() {
        val set = RandomizedSet()
        set.insert(1)
        set.insert(2)
        set.insert(3)
        assertTrue(set.remove(1))
        assertFalse(set.remove(1))
        assertTrue(set.insert(4))
        repeat(20) {
            assertTrue(set.getRandom() in setOf(2, 3, 4))
        }
    }

    @Test
    fun returnsOnlyElement() {
        val set = RandomizedSet()
        set.insert(-7)
        assertEquals(-7, set.getRandom())
        assertTrue(set.remove(-7))
    }

    @Test
    fun mirrorsLeetCodeOperationSequence() {
        val set = RandomizedSet()
        assertTrue(set.insert(1))
        assertFalse(set.remove(2))
        assertTrue(set.insert(2))
        assertTrue(set.getRandom() in setOf(1, 2))
        assertTrue(set.remove(1))
        assertFalse(set.insert(2))
        assertEquals(2, set.getRandom())
    }
}
