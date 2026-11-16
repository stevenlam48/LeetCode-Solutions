package minimumtimetoreachtargetwithlimitedpower

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumTimeToReachTargetWithLimitedPowerTest {
    @Test
    fun spendsPowerAlongPath() {
        val edges = arrayOf(intArrayOf(0, 1, 4), intArrayOf(1, 2, 3))
        val result = Solution().minTimeMaxPower(3, edges, 5, intArrayOf(1, 1, 1), 0, 2)
        assertArrayEquals(longArrayOf(7, 3), result)
    }

    @Test
    fun equalTimePrefersMorePower() {
        val edges = arrayOf(intArrayOf(0, 1, 2), intArrayOf(0, 2, 5), intArrayOf(1, 2, 3))
        val result = Solution().minTimeMaxPower(3, edges, 4, intArrayOf(1, 3, 1), 0, 2)
        assertArrayEquals(longArrayOf(5, 3), result)
    }

    @Test
    fun insufficientInitialPower() {
        val result = Solution().minTimeMaxPower(2, arrayOf(intArrayOf(0, 1, 5)), 0, intArrayOf(1, 0), 0, 1)
        assertArrayEquals(longArrayOf(-1, -1), result)
    }

    @Test
    fun sourceIsTarget() {
        val result = Solution().minTimeMaxPower(1, emptyArray(), 6, intArrayOf(2), 0, 0)
        assertArrayEquals(longArrayOf(0, 6), result)
    }
}
