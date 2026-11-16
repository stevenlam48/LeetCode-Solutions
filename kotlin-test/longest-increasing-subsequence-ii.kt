package longestincreasingsubsequenceii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestIncreasingSubsequenceIiTest {
    @Test
    fun example1() {
        assertEquals(5, Solution().lengthOfLIS(intArrayOf(4, 2, 1, 4, 3, 4, 5, 8, 7, 7), 3))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().lengthOfLIS(intArrayOf(7, 4, 5, 1, 8, 12, 4, 7), 5))
    }

    @Test
    fun example3() {
        assertEquals(1, Solution().lengthOfLIS(intArrayOf(1, 5), 1))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().lengthOfLIS(intArrayOf(42), 100))
    }

    @Test
    fun allEqual() {
        assertEquals(1, Solution().lengthOfLIS(intArrayOf(3, 3, 3, 3), 2))
    }

    @Test
    fun strictlyIncreasingWithinK() {
        assertEquals(4, Solution().lengthOfLIS(intArrayOf(1, 2, 3, 4), 1))
    }
}
