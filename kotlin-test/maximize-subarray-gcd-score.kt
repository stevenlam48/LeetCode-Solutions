package maximizesubarraygcdscore

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MaximizeSubarrayGCDScoreTest {
    @Test
    fun twoElementSubarray() {
        assertEquals(8L, Solution().maxGCDScore(intArrayOf(2, 4), 1))
    }

    @Test
    fun insufficientUpgradesUsesOriginalGcd() {
        assertEquals(6L, Solution().maxGCDScore(intArrayOf(2, 2, 2), 1))
    }

    @Test
    fun upgradesEveryMinimumExponentElement() {
        assertEquals(12L, Solution().maxGCDScore(intArrayOf(2, 2, 2), 3))
    }

    @Test
    fun mixedPowersOfTwo() {
        assertEquals(36L, Solution().maxGCDScore(intArrayOf(6, 6, 12), 2))
    }

    @Test
    fun oddValuesCanUpgradeSingleElement() {
        assertEquals(10L, Solution().maxGCDScore(intArrayOf(3, 5), 1))
    }
}
