package maximumstrengthofagroup

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumStrengthOfAGroupTest {
    @Test
    fun example1() {
        assertEquals(1350L, Solution().maxStrength(intArrayOf(3, -1, -5, 2, 5, -9)))
    }

    @Test
    fun allNegativeOddCount() {
        assertEquals(20L, Solution().maxStrength(intArrayOf(-4, -5, -4)))
    }

    @Test
    fun twoNegatives() {
        assertEquals(1L, Solution().maxStrength(intArrayOf(-1, -1)))
    }

    @Test
    fun singleZero() {
        assertEquals(0L, Solution().maxStrength(intArrayOf(0)))
    }

    @Test
    fun singleNegative() {
        assertEquals(-1L, Solution().maxStrength(intArrayOf(-1)))
    }

    @Test
    fun withZero() {
        assertEquals(1L, Solution().maxStrength(intArrayOf(1, 0)))
    }
}
