package adjacentincreasingsubarraysdetectioni

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AdjacentIncreasingSubarraysDetectionITest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertTrue(solution.hasIncreasingSubarrays(intArrayOf(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3))
    }

    @Test
    fun secondExample() {
        assertFalse(solution.hasIncreasingSubarrays(intArrayOf(1, 2, 3, 4, 4, 4, 4, 5, 6, 7), 5))
    }

    @Test
    fun oneLongRunCanSupplyBothSubarrays() {
        assertTrue(solution.hasIncreasingSubarrays(intArrayOf(1, 2, 3, 4), 2))
    }

    @Test
    fun equalValuesCanSeparateValidRuns() {
        assertTrue(solution.hasIncreasingSubarrays(intArrayOf(1, 2, 2, 3), 2))
    }

    @Test
    fun lengthOneSubarrays() {
        assertTrue(solution.hasIncreasingSubarrays(intArrayOf(2, 1), 1))
    }
}
