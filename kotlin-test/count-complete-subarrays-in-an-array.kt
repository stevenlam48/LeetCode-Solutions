package countcompletesubarraysinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCompleteSubarraysInAnArrayTest {
    @Test
    fun example() {
        assertEquals(4, Solution().countCompleteSubarrays(intArrayOf(1, 3, 1, 2, 2)))
    }

    @Test
    fun allValuesEqual() {
        assertEquals(10, Solution().countCompleteSubarrays(intArrayOf(5, 5, 5, 5)))
    }

    @Test
    fun completeSubarrays() {
        assertEquals(1, Solution().countCompleteSubarrays(intArrayOf(1, 2, 3)))
        assertEquals(3, Solution().countCompleteSubarrays(intArrayOf(1, 2, 1)))
    }

    @Test
    fun emptyAndSingleElement() {
        assertEquals(0, Solution().countCompleteSubarrays(intArrayOf()))
        assertEquals(1, Solution().countCompleteSubarrays(intArrayOf(1)))
    }
}
