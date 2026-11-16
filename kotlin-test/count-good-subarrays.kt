package countgoodsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountGoodSubarraysTest {
    private val solution = Solution()

    @Test
    fun countsIncreasingBitmaskValues() {
        assertEquals(5L, solution.countGoodSubarrays(intArrayOf(1, 2, 3)))
    }

    @Test
    fun equalValuesIncludeEverySubarray() {
        assertEquals(3L, solution.countGoodSubarrays(intArrayOf(1, 1)))
    }

    @Test
    fun handlesSingleElement() {
        assertEquals(1L, solution.countGoodSubarrays(intArrayOf(0)))
    }
}
