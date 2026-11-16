package countsubarrayswithmediank

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubarraysWithMedianKTest {
    private val solution = Solution()

    @Test
    fun `counts standard examples`() {
        assertEquals(3, solution.countSubarrays(intArrayOf(3, 2, 1, 4, 5), 4))
        assertEquals(5, solution.countSubarrays(intArrayOf(1, 2, 3, 4, 5), 3))
    }

    @Test
    fun `handles a single element`() {
        assertEquals(1, solution.countSubarrays(intArrayOf(1), 1))
    }

    @Test
    fun `counts lower medians in even length subarrays`() {
        assertEquals(1, solution.countSubarrays(intArrayOf(2, 3, 1), 3))
    }

    @Test
    fun `skips subarrays with a different median`() {
        assertEquals(2, solution.countSubarrays(intArrayOf(1, 4, 2, 5, 3), 4))
    }
}
