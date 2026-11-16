package findthehighestaltitude

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheHighestAltitudeTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().largestAltitude(intArrayOf(-5, 1, 5, 0, -7)))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().largestAltitude(intArrayOf(-4, -3, -2, -1, 4, 3, 2)))
    }

    @Test
    fun singleZero() {
        assertEquals(0, Solution().largestAltitude(intArrayOf(0)))
    }

    @Test
    fun allPositive() {
        assertEquals(6, Solution().largestAltitude(intArrayOf(1, 2, 3)))
    }
}
