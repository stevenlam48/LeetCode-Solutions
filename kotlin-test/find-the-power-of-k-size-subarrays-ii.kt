package findthepowerofksizesubarraysii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindThePowerOfKSizeSubarraysIiTest {
    private val solution = Solution()

    @Test
    fun findsMixedValidAndInvalidSubarrays() {
        assertArrayEquals(
            intArrayOf(3, 4, -1, -1, 5),
            solution.resultsArray(intArrayOf(1, 2, 3, 4, 3, 4, 5), 3),
        )
    }

    @Test
    fun entireArrayCanBeOneValidSubarray() {
        assertArrayEquals(
            intArrayOf(5),
            solution.resultsArray(intArrayOf(1, 2, 3, 4, 5), 5),
        )
    }

    @Test
    fun restartsWindowAfterNonconsecutiveValues() {
        assertArrayEquals(
            intArrayOf(2, -1, 5, 6, -1),
            solution.resultsArray(intArrayOf(1, 2, 4, 5, 6, 8), 2),
        )
    }

    @Test
    fun duplicateValuesAreNotConsecutive() {
        assertArrayEquals(
            intArrayOf(-1, -1, -1),
            solution.resultsArray(intArrayOf(2, 2, 2, 2, 2), 3),
        )
    }

    @Test
    fun sizeOneSubarraysAlwaysHavePowerEqualToTheirElement() {
        assertArrayEquals(
            intArrayOf(-3, 0, 8),
            solution.resultsArray(intArrayOf(-3, 0, 8), 1),
        )
    }
}
