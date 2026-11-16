package maximumfrequencyscoreofasubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumFrequencyScoreOfASubarrayTest {
    @Test
    fun example1() {
        assertEquals(5, Solution().maxFrequencyScore(intArrayOf(1, 1, 1, 2, 1, 2), 3))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().maxFrequencyScore(intArrayOf(1, 1, 1, 1, 1, 1), 4))
    }

    @Test
    fun singleElementWindow() {
        assertEquals(3, Solution().maxFrequencyScore(intArrayOf(3, 1, 2), 1))
    }

    @Test
    fun wholeArray() {
        assertEquals(16, Solution().maxFrequencyScore(intArrayOf(2, 2, 2, 2), 4))
    }

    @Test
    fun distinctValues() {
        assertEquals(6, Solution().maxFrequencyScore(intArrayOf(1, 2, 3), 3))
    }
}
