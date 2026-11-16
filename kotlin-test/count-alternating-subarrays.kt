package countalternatingsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountAlternatingSubarraysTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(5L, solution.countAlternatingSubarrays(intArrayOf(0, 1, 1, 1)))
    }

    @Test
    fun testAllAlternating() {
        assertEquals(10L, solution.countAlternatingSubarrays(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testSingle() {
        assertEquals(1L, solution.countAlternatingSubarrays(intArrayOf(1)))
    }
}
