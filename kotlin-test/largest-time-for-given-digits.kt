package largesttimeforgivendigits

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestTimeForGivenDigitsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("23:41", solution.largestTimeFromDigits(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testImpossible() {
        assertEquals("", solution.largestTimeFromDigits(intArrayOf(5, 5, 5, 5)))
    }

    @Test
    fun testAllZeros() {
        assertEquals("00:00", solution.largestTimeFromDigits(intArrayOf(0, 0, 0, 0)))
    }

    @Test
    fun testLateTime() {
        assertEquals("23:59", solution.largestTimeFromDigits(intArrayOf(2, 3, 5, 9)))
    }

    @Test
    fun testLeadingZeroHour() {
        assertEquals("04:00", solution.largestTimeFromDigits(intArrayOf(0, 4, 0, 0)))
    }
}
