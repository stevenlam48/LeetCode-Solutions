package minimumlinestorepresentalinechart

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumLinesToRepresentALineChartTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.minimumLines(
            arrayOf(intArrayOf(1, 7), intArrayOf(2, 6), intArrayOf(3, 5), intArrayOf(4, 4), intArrayOf(5, 4), intArrayOf(6, 3), intArrayOf(7, 2), intArrayOf(8, 1))
        ))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.minimumLines(
            arrayOf(intArrayOf(3, 4), intArrayOf(1, 2), intArrayOf(7, 8), intArrayOf(2, 3))
        ))
    }

    @Test
    fun testSinglePoint() {
        assertEquals(0, solution.minimumLines(arrayOf(intArrayOf(1, 1))))
    }

    @Test
    fun testTwoPoints() {
        assertEquals(1, solution.minimumLines(arrayOf(intArrayOf(5, 5), intArrayOf(1, 1))))
    }

    @Test
    fun testVerticalSlope() {
        assertEquals(1, solution.minimumLines(
            arrayOf(intArrayOf(1, 1), intArrayOf(2, 3), intArrayOf(3, 5), intArrayOf(4, 7))
        ))
    }

    @Test
    fun testSlopeChangesEverySegment() {
        assertEquals(3, solution.minimumLines(
            arrayOf(intArrayOf(1, 1), intArrayOf(2, 4), intArrayOf(3, 2), intArrayOf(4, 9))
        ))
    }
}
