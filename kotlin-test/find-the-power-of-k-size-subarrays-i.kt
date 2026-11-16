package findthepowerofksizesubarraysi

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindThePowerOfKSizeSubarraysITest {
    private val solution = Solution()

    @Test
    fun findsMixedValidAndInvalidSubarrays() {
        assertArrayEquals(
            intArrayOf(3, 4, -1, -1, 5),
            solution.resultsArray(intArrayOf(1, 2, 3, 4, 3, 4, 5), 3),
        )
    }

    @Test
    fun duplicateValuesAreNotConsecutive() {
        assertArrayEquals(
            intArrayOf(-1, -1),
            solution.resultsArray(intArrayOf(2, 2, 2, 2, 2), 4),
        )
    }

    @Test
    fun findsAscendingPairsInAlternatingValues() {
        assertArrayEquals(
            intArrayOf(-1, 3, -1, 3, -1),
            solution.resultsArray(intArrayOf(3, 2, 3, 2, 3, 2), 2),
        )
    }

    @Test
    fun sizeOneSubarraysAlwaysHavePowerEqualToTheirElement() {
        assertArrayEquals(
            intArrayOf(7, -2, 0),
            solution.resultsArray(intArrayOf(7, -2, 0), 1),
        )
    }

    @Test
    fun supportsNegativeConsecutiveValues() {
        assertArrayEquals(
            intArrayOf(0, 1),
            solution.resultsArray(intArrayOf(-2, -1, 0, 1), 3),
        )
    }
}
