package maximizefixedpointsafterdeletions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeFixedPointsAfterDeletionsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.maxFixedPoints(intArrayOf(0, 2, 1)))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.maxFixedPoints(intArrayOf(3, 1, 2)))
    }

    @Test
    fun testExample3() {
        assertEquals(3, solution.maxFixedPoints(intArrayOf(1, 0, 1, 2)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.maxFixedPoints(intArrayOf(0)))
        assertEquals(0, solution.maxFixedPoints(intArrayOf(1)))
    }

    @Test
    fun testAllZeros() {
        assertEquals(1, solution.maxFixedPoints(intArrayOf(0, 0, 0)))
    }
}
