package countsubarrayswithfixedbounds

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSubarraysWithFixedBoundsTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(2L, solution.countSubarrays(intArrayOf(1, 3, 5, 2, 7, 5), 1, 5))
    }

    @Test
    fun example2() {
        assertEquals(10L, solution.countSubarrays(intArrayOf(1, 1, 1, 1), 1, 1))
    }

    @Test
    fun narrowRange() {
        assertEquals(1L, solution.countSubarrays(intArrayOf(1, 2, 3), 2, 3))
    }

    @Test
    fun fullRange() {
        assertEquals(1L, solution.countSubarrays(intArrayOf(1, 2, 3), 1, 3))
    }
}
