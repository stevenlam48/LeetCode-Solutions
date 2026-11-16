package findthescoreofallprefixesofanarray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheScoreOfAllPrefixesOfAnArrayTest {
    private val solution = Solution()

    @Test
    fun varyingRunningMaximum() {
        assertArrayEquals(
            longArrayOf(4, 10, 24, 36, 44, 54, 72),
            solution.findPrefixScore(intArrayOf(2, 3, 7, 5, 1, 3, 9))
        )
    }

    @Test
    fun powersOfTwoDoubleTheScore() {
        assertArrayEquals(
            longArrayOf(2, 4, 8, 16, 32, 64),
            solution.findPrefixScore(intArrayOf(1, 1, 2, 4, 8, 16))
        )
    }

    @Test
    fun decreasingValuesReuseTheInitialMaximum() {
        assertArrayEquals(
            longArrayOf(10, 18, 24),
            solution.findPrefixScore(intArrayOf(5, 3, 1))
        )
    }

    @Test
    fun negativeValuesKeepInitialZeroMaximum() {
        assertArrayEquals(
            longArrayOf(-3, -4),
            solution.findPrefixScore(intArrayOf(-3, -1))
        )
    }

    @Test
    fun emptyInputProducesEmptyOutput() {
        assertArrayEquals(longArrayOf(), solution.findPrefixScore(intArrayOf()))
    }
}
