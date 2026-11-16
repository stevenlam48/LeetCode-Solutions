package minimumdeletionstomakestringbalanced
// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDeletionsToMakeStringBalancedTest {
    private val solution = Solution()

    @Test
    fun leetCodeExamples() {
        assertEquals(2, solution.minimumDeletions("bbaaaaabb"))
        assertEquals(2, solution.minimumDeletions("aababbab"))
    }

    @Test
    fun alreadyBalancedStrings() {
        assertEquals(0, solution.minimumDeletions("aaabbb"))
        assertEquals(0, solution.minimumDeletions("bbbb"))
        assertEquals(0, solution.minimumDeletions("aaaa"))
    }

    @Test
    fun minimalAndEmptyInputs() {
        assertEquals(0, solution.minimumDeletions(""))
        assertEquals(1, solution.minimumDeletions("ba"))
    }
}
