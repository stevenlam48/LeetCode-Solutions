package lrucache

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LruCacheTest {
    @Test
    fun leetCodeOperationSequence() {
        val cache = LRUCache(2)
        cache.put(1, 1)
        cache.put(2, 2)
        assertEquals(1, cache.get(1))
        cache.put(3, 3)
        assertEquals(-1, cache.get(2))
        cache.put(4, 4)
        assertEquals(-1, cache.get(1))
        assertEquals(3, cache.get(3))
        assertEquals(4, cache.get(4))
    }

    @Test
    fun updatingExistingKeyRefreshesRecency() {
        val cache = LRUCache(2)
        cache.put(1, 1)
        cache.put(2, 2)
        cache.put(1, 10)
        cache.put(3, 3)
        assertEquals(-1, cache.get(2))
        assertEquals(10, cache.get(1))
        assertEquals(3, cache.get(3))
    }

    @Test
    fun getRefreshesRecency() {
        val cache = LRUCache(2)
        cache.put(1, 1)
        cache.put(2, 2)
        assertEquals(1, cache.get(1))
        cache.put(3, 3)
        assertEquals(-1, cache.get(2))
        assertEquals(1, cache.get(1))
    }

    @Test
    fun nonPositiveCapacityStoresNothing() {
        for (capacity in intArrayOf(0, -1)) {
            val cache = LRUCache(capacity)
            cache.put(1, 1)
            assertEquals(-1, cache.get(1))
        }
    }
}
