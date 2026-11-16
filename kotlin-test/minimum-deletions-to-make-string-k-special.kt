package minimumdeletionstomakestringkspecial
// Time:  O(n + 26)
// Space: O(n + 26)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDeletionsToMakeStringKSpecialTest {
    private val solution = Solution()

    @Test
    fun leetCodeExamples() {
        assertEquals(3, solution.minimumDeletions("aabcaba", 0))
        assertEquals(0, solution.minimumDeletions("dabbd", 3))
    }

    @Test
    fun singleFrequencyIsAlwaysSpecial() {
        assertEquals(0, solution.minimumDeletions("aaaa", 0))
        assertEquals(0, solution.minimumDeletions("a", 0))
    }

    @Test
    fun discardSmallFrequencyAndTrimLargeFrequency() {
        assertEquals(3, solution.minimumDeletions("aaaaabbc", 0))
    }
}
