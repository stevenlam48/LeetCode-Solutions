package longestwellperforminginterval

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestWellPerformingIntervalTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(3, solution.longestWPI(intArrayOf(9, 9, 6, 0, 6, 6, 9)))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(0, solution.longestWPI(intArrayOf(6, 6, 6)))
    }

    @Test
    fun testSingleTiringDay() {
        assertEquals(1, solution.longestWPI(intArrayOf(9)))
    }

    @Test
    fun testSingleNonTiringDay() {
        assertEquals(0, solution.longestWPI(intArrayOf(8)))
    }

    @Test
    fun testEmptyArray() {
        assertEquals(0, solution.longestWPI(intArrayOf()))
    }

    @Test
    fun testWholeArrayWellPerforming() {
        assertEquals(5, solution.longestWPI(intArrayOf(9, 10, 9, 9, 12)))
    }
}
