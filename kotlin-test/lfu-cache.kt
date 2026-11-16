package lfucache

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LfuCacheTest {
    @Test
    fun mirrorsLeetCodeOperationSequence() {
        val cache = LFUCache(2)
        cache.put(1, 1)
        cache.put(2, 2)
        assertEquals(1, cache.get(1))
        cache.put(3, 3)
        assertEquals(-1, cache.get(2))
        assertEquals(3, cache.get(3))
        cache.put(4, 4)
        assertEquals(-1, cache.get(1))
        assertEquals(3, cache.get(3))
        assertEquals(4, cache.get(4))
    }

    @Test
    fun evictsLeastRecentlyUsedAmongEqualMinimumFrequencies() {
        val cache = LFUCache(3)
        cache.put(1, 1)
        cache.put(2, 2)
        cache.put(3, 3)
        assertEquals(1, cache.get(1))
        cache.put(4, 4)
        assertEquals(-1, cache.get(2))
        assertEquals(1, cache.get(1))
        assertEquals(3, cache.get(3))
        assertEquals(4, cache.get(4))
    }

    @Test
    fun updatesValueWithoutAddingAnotherEntry() {
        val cache = LFUCache(2)
        cache.put(1, 1)
        cache.put(2, 2)
        cache.put(1, 10)
        assertEquals(10, cache.get(1))
        assertEquals(2, cache.get(2))
    }

    @Test
    fun handlesZeroCapacityAndSingleEntryReplacement() {
        val emptyCache = LFUCache(0)
        emptyCache.put(1, 1)
        assertEquals(-1, emptyCache.get(1))

        val cache = LFUCache(1)
        cache.put(1, 1)
        assertEquals(1, cache.get(1))
        cache.put(2, 2)
        assertEquals(-1, cache.get(1))
        assertEquals(2, cache.get(2))
    }
}
