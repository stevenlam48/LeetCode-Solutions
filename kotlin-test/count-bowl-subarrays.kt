package countbowlsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountBowlSubarraysTest {
    @Test
    fun example() {
        assertEquals(2L, Solution().bowlSubarrays(intArrayOf(2, 5, 3, 1, 4)))
    }

    @Test
    fun monotonicArrays() {
        assertEquals(0L, Solution().bowlSubarrays(intArrayOf(5, 4, 3)))
        assertEquals(0L, Solution().bowlSubarrays(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleBowl() {
        assertEquals(1L, Solution().bowlSubarrays(intArrayOf(2, 4, 1, 3)))
    }

    @Test
    fun empty() {
        assertEquals(0L, Solution().bowlSubarrays(intArrayOf()))
    }
}
