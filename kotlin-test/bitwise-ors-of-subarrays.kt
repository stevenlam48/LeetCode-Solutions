package bitwiseorsofsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BitwiseOrsOfSubarraysTest {
    @Test
    fun singleZero() {
        assertEquals(1, Solution().subarrayBitwiseORs(intArrayOf(0)))
    }

    @Test
    fun duplicates() {
        assertEquals(3, Solution().subarrayBitwiseORs(intArrayOf(1, 1, 2)))
    }

    @Test
    fun distinctPowersOfTwo() {
        assertEquals(6, Solution().subarrayBitwiseORs(intArrayOf(1, 2, 4)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().subarrayBitwiseORs(intArrayOf(1)))
    }
}
