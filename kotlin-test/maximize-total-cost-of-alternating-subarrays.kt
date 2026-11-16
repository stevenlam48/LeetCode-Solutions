package maximizetotalcostofalternatingsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeTotalCostOfAlternatingSubarraysTest {
    @Test
    fun exampleOne() {
        assertEquals(10L, Solution().maximumTotalCost(intArrayOf(1, -2, 3, 4)))
    }

    @Test
    fun allNegative() {
        assertEquals(-1L, Solution().maximumTotalCost(intArrayOf(-1, -1, -1)))
    }

    @Test
    fun twoElements() {
        assertEquals(3L, Solution().maximumTotalCost(intArrayOf(2, 1)))
    }

    @Test
    fun singleElement() {
        assertEquals(0L, Solution().maximumTotalCost(intArrayOf(0)))
    }
}
