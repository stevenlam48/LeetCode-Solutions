package maximumstrengthofkdisjointsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumStrengthOfKDisjointSubarraysTest {
    @Test
    fun example1() {
        assertEquals(22L, Solution().maximumStrength(intArrayOf(1, 2, 3, -1, 2), 3))
    }

    @Test
    fun example2() {
        assertEquals(32L, Solution().maximumStrength(intArrayOf(12, -2, -2, -2, -2), 2))
    }

    @Test
    fun singleElement() {
        assertEquals(5L, Solution().maximumStrength(intArrayOf(5), 1))
    }

    @Test
    fun allNegative() {
        assertEquals(-1L, Solution().maximumStrength(intArrayOf(-1, -2, -3), 1))
    }

    @Test
    fun increasing() {
        assertEquals(15L, Solution().maximumStrength(intArrayOf(1, 2, 3, 4, 5), 2))
    }
}
