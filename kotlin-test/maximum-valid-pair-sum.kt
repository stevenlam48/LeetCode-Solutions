package maximumvalidpairsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumValidPairSumTest {
    @Test
    fun examples() {
        assertEquals(7, Solution().maxValidPairSum(intArrayOf(1, 5, 3, 2), 2))
        assertEquals(8, Solution().maxValidPairSum(intArrayOf(1, 5, 3, 2), 1))
    }

    @Test
    fun zeroDistance() {
        assertEquals(10, Solution().maxValidPairSum(intArrayOf(1, 5, 3), 0))
    }

    @Test
    fun negativePairsKeepInitialResult() {
        assertEquals(0, Solution().maxValidPairSum(intArrayOf(-5, -2, -9, -1), 2))
    }

    @Test
    fun noPairs() {
        assertEquals(0, Solution().maxValidPairSum(intArrayOf(1, 2), 2))
        assertEquals(0, Solution().maxValidPairSum(intArrayOf(), 0))
    }
}
