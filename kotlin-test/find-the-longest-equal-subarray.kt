package findthelongestequalsubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheLongestEqualSubarrayTest {
    @Test
    fun exampleOne() {
        assertEquals(3, Solution().longestEqualSubarray(intArrayOf(1, 3, 2, 3, 1, 3), 3))
    }

    @Test
    fun exampleTwo() {
        assertEquals(4, Solution().longestEqualSubarray(intArrayOf(1, 1, 2, 2, 1, 1), 2))
    }

    @Test
    fun noDeletionsAllowed() {
        assertEquals(3, Solution().longestEqualSubarray(intArrayOf(1, 2, 2, 2, 3, 3), 0))
    }

    @Test
    fun negativeAndDuplicateValues() {
        assertEquals(3, Solution().longestEqualSubarray(intArrayOf(-1, 0, -1, 0, -1), 2))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, Solution().longestEqualSubarray(intArrayOf(), 3))
    }
}
