package findxsumofallklongsubarraysii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindXSumOfAllKLongSubarraysIiTest {
    @Test
    fun matchesFirstLeetCodeExample() {
        assertArrayEquals(
            longArrayOf(6, 10, 12),
            Solution().findXSum(intArrayOf(1, 1, 2, 2, 3, 4, 2, 3), 6, 2)
        )
    }

    @Test
    fun matchesSecondLeetCodeExample() {
        assertArrayEquals(
            longArrayOf(11, 15, 15, 15, 12),
            Solution().findXSum(intArrayOf(3, 8, 7, 8, 7, 5), 2, 2)
        )
    }

    @Test
    fun resolvesFrequencyTiesByLargerValue() {
        assertArrayEquals(longArrayOf(5), Solution().findXSum(intArrayOf(1, 3, 2), 3, 2))
        assertArrayEquals(longArrayOf(10, 10), Solution().findXSum(intArrayOf(5, 5, 5), 2, 1))
    }

    @Test
    fun handlesSingleElementWindowsAndNegativeValues() {
        assertArrayEquals(
            longArrayOf(-2, -2, 3),
            Solution().findXSum(intArrayOf(-2, -2, 3), 1, 1)
        )
    }
}
