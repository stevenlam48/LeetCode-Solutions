package insertdeletegetrandomo1duplicatesallowed

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class InsertDeleteGetrandomO1DuplicatesAllowedTest {
    @Test
    fun reportsWhetherValueWasAlreadyPresent() {
        val collection = RandomizedCollection()
        assertTrue(collection.insert(1))
        assertFalse(collection.insert(1))
        assertTrue(collection.insert(2))
    }

    @Test
    fun removesOneDuplicateAtATime() {
        val collection = RandomizedCollection()
        collection.insert(1)
        collection.insert(1)
        assertTrue(collection.remove(1))
        assertEquals(1, collection.getRandom())
        assertTrue(collection.remove(1))
        assertFalse(collection.remove(1))
    }

    @Test
    fun maintainsIndicesWhenRemovingDuplicateBeforeLastValue() {
        val collection = RandomizedCollection()
        collection.insert(1)
        collection.insert(1)
        collection.insert(2)
        assertTrue(collection.remove(1))
        repeat(10) {
            assertTrue(collection.getRandom() in setOf(1, 2))
        }
        assertTrue(collection.remove(2))
        assertEquals(1, collection.getRandom())
    }

    @Test
    fun mirrorsLeetCodeOperationSequence() {
        val collection = RandomizedCollection()
        assertTrue(collection.insert(1))
        assertFalse(collection.insert(1))
        assertTrue(collection.insert(2))
        assertTrue(collection.getRandom() in setOf(1, 2))
        assertTrue(collection.remove(1))
        assertTrue(collection.getRandom() in setOf(1, 2))
    }
}
