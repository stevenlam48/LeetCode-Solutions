package intervallistintersections

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IntervalListIntersectionsTest {
    private val solution = Solution()

    private fun interval(start: Int, end: Int) = Interval(start, end)

    private fun pairs(intervals: List<Interval>) = intervals.map { it.start to it.end }

    @Test
    fun testExample1() {
        val a = arrayOf(interval(0, 2), interval(5, 10), interval(13, 23), interval(24, 25))
        val b = arrayOf(interval(1, 5), interval(8, 12), interval(15, 24), interval(25, 26))
        assertEquals(
            listOf(1 to 2, 5 to 5, 8 to 10, 15 to 23, 24 to 24, 25 to 25),
            pairs(solution.intervalIntersection(a, b))
        )
    }

    @Test
    fun testNoOverlap() {
        val a = arrayOf(interval(1, 2), interval(5, 6))
        val b = arrayOf(interval(3, 4), interval(7, 8))
        assertTrue(solution.intervalIntersection(a, b).isEmpty())
    }

    @Test
    fun testTouchingEndpoints() {
        val a = arrayOf(interval(1, 3))
        val b = arrayOf(interval(3, 5))
        assertEquals(listOf(3 to 3), pairs(solution.intervalIntersection(a, b)))
    }

    @Test
    fun testEmptyInput() {
        assertTrue(solution.intervalIntersection(emptyArray(), arrayOf(interval(1, 2))).isEmpty())
        assertTrue(solution.intervalIntersection(arrayOf(interval(1, 2)), emptyArray()).isEmpty())
    }

    @Test
    fun testContainedInterval() {
        val a = arrayOf(interval(1, 10))
        val b = arrayOf(interval(3, 4), interval(6, 7))
        assertEquals(listOf(3 to 4, 6 to 7), pairs(solution.intervalIntersection(a, b)))
    }
}
