package rangefrequencyqueries

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RangeFrequencyQueriesTest {
    @Test
    fun testExample() {
        val arr = intArrayOf(12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56)
        val query = RangeFreqQuery(arr)
        assertEquals(1, query.query(1, 2, 4))
        assertEquals(2, query.query(0, 11, 33))
    }

    @Test
    fun testMissingValue() {
        val query = RangeFreqQuery(intArrayOf(1, 2, 3))
        assertEquals(0, query.query(0, 2, 4))
    }

    @Test
    fun testSingleElementRange() {
        val query = RangeFreqQuery(intArrayOf(1, 1, 1))
        assertEquals(1, query.query(1, 1, 1))
        assertEquals(3, query.query(0, 2, 1))
    }

    @Test
    fun testAllDistinct() {
        val query = RangeFreqQuery(intArrayOf(5, 6, 7, 8))
        assertEquals(1, query.query(0, 3, 5))
        assertEquals(1, query.query(0, 3, 8))
        assertEquals(0, query.query(1, 2, 5))
    }
}
