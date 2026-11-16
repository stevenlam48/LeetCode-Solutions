package maximumscoreusingexactlykpairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreUsingExactlyKPairsTest {
    @Test
    fun example1() {
        assertEquals(16L, Solution().maxScore(intArrayOf(1, 3, 2), intArrayOf(4, 1, 2), 2))
    }

    @Test
    fun singlePair() {
        assertEquals(12L, Solution().maxScore(intArrayOf(1, 3, 2), intArrayOf(4, 1, 2), 1))
    }

    @Test
    fun allPairs() {
        assertEquals(11L, Solution().maxScore(intArrayOf(1, 3, 2), intArrayOf(4, 1, 2), 3))
    }

    @Test
    fun negativeValues() {
        assertEquals(-3L, Solution().maxScore(intArrayOf(-1, -2), intArrayOf(3, 4), 1))
        assertEquals(-11L, Solution().maxScore(intArrayOf(-1, -2), intArrayOf(3, 4), 2))
    }

    @Test
    fun unequalLengths() {
        assertEquals(23L, Solution().maxScore(intArrayOf(2, 5), intArrayOf(1, 4, 3), 2))
    }
}
