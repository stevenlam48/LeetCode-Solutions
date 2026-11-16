package countsubarrayswithloosebounds

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSubarraysWithLooseBoundsTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(11L, solution.countSubarrays(intArrayOf(1, 3, 5, 2, 7, 5), 1, 5))
    }

    @Test
    fun allInRange() {
        assertEquals(6L, solution.countSubarrays(intArrayOf(1, 2, 3), 1, 3))
    }

    @Test
    fun singleValueRange() {
        assertEquals(1L, solution.countSubarrays(intArrayOf(1, 2, 3), 2, 2))
    }

    @Test
    fun singleElement() {
        assertEquals(1L, solution.countSubarrays(intArrayOf(5), 1, 5))
    }
}
