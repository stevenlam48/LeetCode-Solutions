package countstrictlyincreasingsubarrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountStrictlyIncreasingSubarraysTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(10L, solution.countSubarrays(intArrayOf(1, 3, 5, 4, 4, 6)))
    }

    @Test
    fun example2() {
        assertEquals(15L, solution.countSubarrays(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun singleElement() {
        assertEquals(1L, solution.countSubarrays(intArrayOf(1)))
    }

    @Test
    fun decreasing() {
        assertEquals(2L, solution.countSubarrays(intArrayOf(2, 1)))
    }

    @Test
    fun allEqual() {
        assertEquals(3L, solution.countSubarrays(intArrayOf(1, 1, 1)))
    }
}
