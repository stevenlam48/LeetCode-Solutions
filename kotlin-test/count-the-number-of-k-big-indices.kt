package countthenumberofkbigindices
// Time:  O(nlogk)
// Space: O(n)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheNumberOfKBigIndicesTest {
    @Test
    fun example() {
        assertEquals(3, Solution().kBigIndices(intArrayOf(2, 3, 6, 1, 5, 4), 1))
    }

    @Test
    fun insufficientSmallerValues() {
        assertEquals(0, Solution().kBigIndices(intArrayOf(1, 2, 3, 4), 2))
    }

    @Test
    fun duplicatesAroundLargerValue() {
        assertEquals(1, Solution().kBigIndices(intArrayOf(2, 2, 3, 2, 2), 2))
    }

    @Test
    fun strictComparisonWithDuplicates() {
        assertEquals(0, Solution().kBigIndices(intArrayOf(1, 2, 2, 2, 3), 1))
    }
}
