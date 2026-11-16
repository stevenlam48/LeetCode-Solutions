package subrectanglequeries

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubrectangleQueriesTest {
    @Test
    fun testExample1() {
        val q = SubrectangleQueries(
            arrayOf(
                intArrayOf(1, 2, 1),
                intArrayOf(4, 3, 4),
                intArrayOf(3, 2, 1),
                intArrayOf(1, 1, 1)
            )
        )
        assertEquals(1, q.getValue(0, 2))
        q.updateSubrectangle(0, 0, 3, 2, 5)
        assertEquals(5, q.getValue(0, 2))
        assertEquals(5, q.getValue(3, 1))
        q.updateSubrectangle(3, 0, 3, 2, 10)
        assertEquals(5, q.getValue(0, 2))
        assertEquals(10, q.getValue(3, 1))
    }

    @Test
    fun testExample2() {
        val q = SubrectangleQueries(
            arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(2, 2, 2),
                intArrayOf(3, 3, 3)
            )
        )
        assertEquals(1, q.getValue(0, 0))
        q.updateSubrectangle(0, 0, 2, 2, 100)
        assertEquals(100, q.getValue(0, 0))
        assertEquals(100, q.getValue(2, 2))
        q.updateSubrectangle(1, 1, 2, 2, 20)
        assertEquals(100, q.getValue(0, 0))
        assertEquals(20, q.getValue(2, 2))
    }

    @Test
    fun testNoUpdates() {
        val q = SubrectangleQueries(arrayOf(intArrayOf(7, 8), intArrayOf(9, 10)))
        assertEquals(7, q.getValue(0, 0))
        assertEquals(10, q.getValue(1, 1))
    }

    @Test
    fun testOverlappingUpdates() {
        val q = SubrectangleQueries(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)))
        q.updateSubrectangle(0, 0, 1, 1, 1)
        q.updateSubrectangle(0, 0, 0, 0, 2)
        assertEquals(2, q.getValue(0, 0))
        assertEquals(1, q.getValue(1, 1))
        assertEquals(1, q.getValue(0, 1))
    }
}
