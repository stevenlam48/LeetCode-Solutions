package kconcatenationmaximumsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KConcatenationMaximumSumTest {
    @Test
    fun `positive total repeats middle arrays`() {
        assertEquals(9, Solution().kConcatenationMaxSum(intArrayOf(1, 2), 3))
    }

    @Test
    fun `negative total limits repetition benefit`() {
        assertEquals(2, Solution().kConcatenationMaxSum(intArrayOf(1, -2, 1), 5))
    }

    @Test
    fun `all negative values give empty subarray sum`() {
        assertEquals(0, Solution().kConcatenationMaxSum(intArrayOf(-1, -2), 3))
    }

    @Test
    fun `best subarray can cross concatenation boundary`() {
        assertEquals(6, Solution().kConcatenationMaxSum(intArrayOf(2, -1, 2), 2))
    }

    @Test
    fun `large sum is reduced modulo`() {
        assertEquals(999999867, Solution().kConcatenationMaxSum(intArrayOf(100000, 100000), 100000))
    }
}
