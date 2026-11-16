package countthenumberofbeautifulsubarrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfBeautifulSubarraysTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2L, solution.beautifulSubarrays(intArrayOf(4, 3, 1, 2, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals(2L, solution.beautifulSubarrays(intArrayOf(4, 3, 1, 2, 4, 1)))
    }

    @Test
    fun testSingleNonZero() {
        assertEquals(0L, solution.beautifulSubarrays(intArrayOf(1)))
    }

    @Test
    fun testSingleZero() {
        assertEquals(1L, solution.beautifulSubarrays(intArrayOf(0)))
    }

    @Test
    fun testEqualPair() {
        assertEquals(1L, solution.beautifulSubarrays(intArrayOf(1, 1)))
    }
}
