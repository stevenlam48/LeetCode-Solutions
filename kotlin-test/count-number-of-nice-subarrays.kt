package countnumberofnicesubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfNiceSubarraysTest {
    @Test
    fun threeOddNumbersExample() {
        assertEquals(2, Solution().numberOfSubarrays(intArrayOf(1, 1, 2, 1, 1), 3))
    }

    @Test
    fun noOddNumbersCannotFormPositiveKSubarray() {
        assertEquals(0, Solution().numberOfSubarrays(intArrayOf(2, 4, 6), 1))
    }

    @Test
    fun evenPrefixesAndSuffixesMultiplyChoices() {
        assertEquals(16, Solution().numberOfSubarrays(intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2), 2))
    }

    @Test
    fun overlappingOddPairsAreCounted() {
        assertEquals(2, Solution().numberOfSubarrays(intArrayOf(1, 3, 5), 2))
    }

    @Test
    fun zeroOddsCountsEveryNonEmptySubarray() {
        assertEquals(6, Solution().numberOfSubarrays(intArrayOf(2, 4, 2), 0))
    }
}
