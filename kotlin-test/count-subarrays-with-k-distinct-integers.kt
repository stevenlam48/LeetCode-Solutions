package countsubarrayswithkdistinctintegers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSubarraysWithKDistinctIntegersTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(1L, solution.countSubarrays(intArrayOf(1, 2, 1, 2, 3), 2, 2))
    }

    @Test
    fun allSame() {
        assertEquals(3L, solution.countSubarrays(intArrayOf(1, 1, 1), 1, 2))
    }

    @Test
    fun allDistinct() {
        assertEquals(1L, solution.countSubarrays(intArrayOf(1, 2, 3), 3, 1))
    }

    @Test
    fun noMatch() {
        assertEquals(0L, solution.countSubarrays(intArrayOf(1, 2, 3), 2, 2))
    }
}
