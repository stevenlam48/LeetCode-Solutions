package minimumtimedifference

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumTimeDifferenceTest {
    private val solution = Solution()

    @Test
    fun testMidnightWrapAround() {
        assertEquals(1, solution.findMinDifference(listOf("23:59", "00:00")))
    }

    @Test
    fun testDuplicates() {
        assertEquals(0, solution.findMinDifference(listOf("00:00", "23:59", "00:00")))
        assertEquals(0, solution.findMinDifference(listOf("12:00", "12:00")))
    }

    @Test
    fun testThreePoints() {
        assertEquals(147, solution.findMinDifference(listOf("05:31", "22:08", "00:35")))
        assertEquals(120, solution.findMinDifference(listOf("00:00", "04:00", "22:00")))
    }

    @Test
    fun testTwoPoints() {
        assertEquals(3, solution.findMinDifference(listOf("01:01", "01:04")))
    }
}
