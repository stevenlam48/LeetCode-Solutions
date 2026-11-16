package minimumsplitintosubarrayswithgcdgreaterthanone

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumSplitIntoSubarraysWithGcdGreaterThanOneTest {
    @Test
    fun `splits the first sample into two subarrays`() {
        assertEquals(2, Solution().minimumSplits(intArrayOf(12, 6, 3, 14, 8)))
    }

    @Test
    fun `keeps an array with a common factor intact`() {
        assertEquals(1, Solution().minimumSplits(intArrayOf(2, 2, 2, 2, 2, 2)))
    }

    @Test
    fun `splits between coprime neighboring values`() {
        assertEquals(4, Solution().minimumSplits(intArrayOf(2, 3, 4, 5)))
    }

    @Test
    fun `merges later values after a split when possible`() {
        assertEquals(2, Solution().minimumSplits(intArrayOf(6, 10, 15)))
    }

    @Test
    fun `matches the singleton edge behavior`() {
        assertEquals(2, Solution().minimumSplits(intArrayOf(1)))
    }
}
