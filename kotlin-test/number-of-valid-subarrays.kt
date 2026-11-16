package numberofvalidsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfValidSubarraysTest {
    @Test
    fun example1() {
        assertEquals(11, Solution().validSubarrays(intArrayOf(1, 4, 2, 5, 3)))
    }

    @Test
    fun decreasing() {
        assertEquals(3, Solution().validSubarrays(intArrayOf(3, 2, 1)))
    }

    @Test
    fun increasing() {
        assertEquals(6, Solution().validSubarrays(intArrayOf(1, 2, 3)))
    }

    @Test
    fun single() {
        assertEquals(1, Solution().validSubarrays(intArrayOf(1)))
    }

    @Test
    fun allEqual() {
        assertEquals(6, Solution().validSubarrays(intArrayOf(2, 2, 2)))
    }
}
