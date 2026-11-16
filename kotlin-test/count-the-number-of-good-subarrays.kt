package countthenumberofgoodsubarrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfGoodSubarraysTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1L, solution.countGood(intArrayOf(1, 1, 1, 1, 1), 10))
    }

    @Test
    fun testExample2() {
        assertEquals(4L, solution.countGood(intArrayOf(3, 1, 4, 3, 2, 2, 4), 2))
    }

    @Test
    fun testNoGoodSubarray() {
        assertEquals(0L, solution.countGood(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0L, solution.countGood(intArrayOf(1), 1))
    }

    @Test
    fun testAllSame() {
        assertEquals(6L, solution.countGood(intArrayOf(2, 2, 2, 2), 1))
    }
}
