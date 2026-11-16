package minimumtimetomakearraysumatmostx

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToMakeArraySumAtMostXTest {
    @Test
    fun distinctGrowthRates() {
        assertEquals(3, Solution().minimumTime(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3), 4))
    }

    @Test
    fun equalGrowthRates() {
        assertEquals(-1, Solution().minimumTime(intArrayOf(1, 2, 3), intArrayOf(3, 3, 3), 4))
    }

    @Test
    fun zeroTargetIsImpossible() {
        assertEquals(-1, Solution().minimumTime(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3), 0))
    }

    @Test
    fun alreadyWithinLimit() {
        assertEquals(0, Solution().minimumTime(intArrayOf(2, 1), intArrayOf(5, 5), 3))
    }

    @Test
    fun singleElementReset() {
        assertEquals(1, Solution().minimumTime(intArrayOf(5), intArrayOf(0), 4))
    }
}
