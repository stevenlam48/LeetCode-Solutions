package countofinterestingsubarrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountOfInterestingSubarraysTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3L, solution.countInterestingSubarrays(intArrayOf(3, 2, 4), 2, 1))
    }

    @Test
    fun testExample2() {
        assertEquals(2L, solution.countInterestingSubarrays(intArrayOf(3, 1, 9, 6), 3, 0))
    }

    @Test
    fun testEmpty() {
        assertEquals(0L, solution.countInterestingSubarrays(intArrayOf(), 2, 1))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1L, solution.countInterestingSubarrays(intArrayOf(1), 1, 0))
        assertEquals(0L, solution.countInterestingSubarrays(intArrayOf(2), 3, 1))
    }

    @Test
    fun testAllMatch() {
        assertEquals(6L, solution.countInterestingSubarrays(intArrayOf(1, 1, 1), 1, 0))
    }
}
