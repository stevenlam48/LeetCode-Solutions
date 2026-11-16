package checkifalltheintegersinarangearecovered

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfAllTheIntegersInARangeAreCoveredTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val ranges = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6))
        assertTrue(solution.isCovered(ranges, 2, 5))
    }

    @Test
    fun testExample2() {
        val ranges = arrayOf(intArrayOf(1, 10), intArrayOf(10, 20))
        assertFalse(solution.isCovered(ranges, 21, 21))
    }

    @Test
    fun testFullRange() {
        val ranges = arrayOf(intArrayOf(1, 50))
        assertTrue(solution.isCovered(ranges, 1, 50))
    }

    @Test
    fun testSingleElement() {
        val ranges = arrayOf(intArrayOf(1, 1))
        assertTrue(solution.isCovered(ranges, 1, 1))
    }

    @Test
    fun testOverlappingRanges() {
        val ranges = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertTrue(solution.isCovered(ranges, 2, 3))
    }

    @Test
    fun testGap() {
        val ranges = arrayOf(intArrayOf(1, 2), intArrayOf(4, 5))
        assertFalse(solution.isCovered(ranges, 1, 5))
    }
}
