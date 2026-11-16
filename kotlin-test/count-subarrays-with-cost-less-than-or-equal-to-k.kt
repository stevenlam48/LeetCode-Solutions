package countsubarrayswithcostlessthanorequaltok

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSubarraysWithCostLessThanOrEqualToKTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(5L, solution.countSubarrays(intArrayOf(1, 3, 2), 4L))
    }

    @Test
    fun example2() {
        assertEquals(4L, solution.countSubarrays(intArrayOf(2, 3, 1), 3L))
    }

    @Test
    fun singleElement() {
        assertEquals(1L, solution.countSubarrays(intArrayOf(1), 0L))
    }

    @Test
    fun zeroCost() {
        assertEquals(3L, solution.countSubarrays(intArrayOf(1, 2, 3), 0L))
    }
}
