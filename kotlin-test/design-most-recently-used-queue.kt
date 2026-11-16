package designmostrecentlyusedqueue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignMostRecentlyUsedQueueTest {
    @Test
    fun testExample() {
        val q = MRUQueue(8)
        assertEquals(3, q.fetch(3))
        assertEquals(6, q.fetch(5))
        assertEquals(2, q.fetch(2))
    }

    @Test
    fun testSingleElement() {
        val q = MRUQueue(1)
        assertEquals(1, q.fetch(1))
        assertEquals(1, q.fetch(1))
    }

    @Test
    fun testRepeatedFetchOfSamePosition() {
        val q = MRUQueue(3)
        assertEquals(3, q.fetch(3))
        assertEquals(3, q.fetch(3))
        assertEquals(1, q.fetch(1))
        assertEquals(1, q.fetch(3))
    }

    @Test
    fun testManyFetches() {
        val n = 100
        val q = MRUQueue(n)
        for (i in 1..n) {
            assertEquals(i, q.fetch(1))
        }
        for (i in 1..n) {
            assertEquals(i, q.fetch(1))
        }
    }
}
