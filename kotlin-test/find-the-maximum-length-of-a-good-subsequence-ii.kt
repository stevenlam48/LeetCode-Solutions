package findthemaximumlengthofagoodsubsequenceii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMaximumLengthOfAGoodSubsequenceIITest {
    @Test
    fun alternatingValuesWithOneBadAdjacentPair() {
        assertEquals(2, Solution().maximumLength(intArrayOf(1, 2, 3, 4, 5), 1))
    }

    @Test
    fun noBadPairsAllowed() {
        assertEquals(3, Solution().maximumLength(intArrayOf(1, 2, 1, 2, 1), 0))
    }

    @Test
    fun generousDifferenceBudget() {
        assertEquals(5, Solution().maximumLength(intArrayOf(1, 2, 3, 4, 5), 4))
    }

    @Test
    fun unequalPairsRequireBudget() {
        assertEquals(2, Solution().maximumLength(intArrayOf(1, 2, 1), 1))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().maximumLength(intArrayOf(9), 0))
    }
}
