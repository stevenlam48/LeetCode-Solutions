package findthemaximumlengthofagoodsubsequencei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMaximumLengthOfAGoodSubsequenceITest {
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
    fun equalValues() {
        assertEquals(4, Solution().maximumLength(intArrayOf(1, 1, 1, 1), 2))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, Solution().maximumLength(intArrayOf(), 2))
    }
}
