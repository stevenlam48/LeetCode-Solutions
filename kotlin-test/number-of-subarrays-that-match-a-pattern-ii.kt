package numberofsubarraysthatmatchapatternii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubarraysThatMatchAPatternIITest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(4, solution.countMatchingSubarrays(intArrayOf(1, 2, 3, 4, 5, 6), intArrayOf(1, 1)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(1, solution.countMatchingSubarrays(intArrayOf(1, 4, 4, 1, 3, 5, 1), intArrayOf(1, 0, -1)))
    }

    @Test
    fun equalAndOverlappingPatterns() {
        assertEquals(2, solution.countMatchingSubarrays(intArrayOf(1, 1, 2, 2, 1), intArrayOf(0)))
        assertEquals(2, solution.countMatchingSubarrays(intArrayOf(1, 2, 1, 2, 1), intArrayOf(1, -1)))
    }
}
