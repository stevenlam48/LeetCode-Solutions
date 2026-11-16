package kdivisibleelementssubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KDivisibleElementsSubarraysTest {
    @Test
    fun leetCodeExampleOne() {
        assertEquals(11, Solution().countDistinct(intArrayOf(2, 3, 3, 2, 2), 2, 2))
    }

    @Test
    fun leetCodeExampleTwo() {
        assertEquals(10, Solution().countDistinct(intArrayOf(1, 2, 3, 4), 4, 1))
    }

    @Test
    fun singleDivisibleElementWithinLimit() {
        assertEquals(1, Solution().countDistinct(intArrayOf(2), 1, 2))
    }

    @Test
    fun singleDivisibleElementExceedsLimit() {
        assertEquals(0, Solution().countDistinct(intArrayOf(2), 0, 2))
    }

    @Test
    fun allSubarraysDistinct() {
        assertEquals(6, Solution().countDistinct(intArrayOf(1, 2, 3), 1, 2))
    }
}
