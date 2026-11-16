package longestnondecreasingsubarrayfromtwoarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestNonDecreasingSubarrayFromTwoArraysTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maxNonDecreasingLength(intArrayOf(2, 3, 1), intArrayOf(1, 2, 1)))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().maxNonDecreasingLength(intArrayOf(1, 3, 2, 1), intArrayOf(2, 2, 3, 4)))
    }

    @Test
    fun example3() {
        assertEquals(2, Solution().maxNonDecreasingLength(intArrayOf(1, 1), intArrayOf(2, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().maxNonDecreasingLength(intArrayOf(5), intArrayOf(9)))
    }

    @Test
    fun alternatingChoice() {
        assertEquals(3, Solution().maxNonDecreasingLength(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1)))
    }
}
