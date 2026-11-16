package findclosestnumbertozero

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindClosestNumberToZeroTest {
    @Test
    fun standardExample() {
        assertEquals(1, Solution().findClosestNumber(intArrayOf(-4, -2, 1, 4, 8)))
    }

    @Test
    fun tieChoosesLargerValue() {
        assertEquals(1, Solution().findClosestNumber(intArrayOf(2, -1, 1)))
    }

    @Test
    fun negativeClosest() {
        assertEquals(-1, Solution().findClosestNumber(intArrayOf(2, -1, -2)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().findClosestNumber(intArrayOf(1)))
    }

    @Test
    fun tieBetweenOpposites() {
        assertEquals(5, Solution().findClosestNumber(intArrayOf(-5, 5)))
    }

    @Test
    fun zeroIsClosest() {
        assertEquals(0, Solution().findClosestNumber(intArrayOf(0, 5, -3)))
    }
}
