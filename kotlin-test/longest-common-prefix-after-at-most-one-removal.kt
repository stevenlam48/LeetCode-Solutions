package longestcommonprefixafteratmostoneremoval

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestCommonPrefixAfterAtMostOneRemovalTest {
    private val solution = Solution()

    @Test
    fun identicalStrings() {
        assertEquals(3, solution.longestCommonPrefix("aba", "aba"))
    }

    @Test
    fun removalInSource() {
        assertEquals(3, solution.longestCommonPrefix("abxc", "abc"))
    }

    @Test
    fun removalAtBeginning() {
        assertEquals(3, solution.longestCommonPrefix("xabc", "abc"))
    }

    @Test
    fun secondMismatchStopsPrefix() {
        assertEquals(0, solution.longestCommonPrefix("acb", "xyz"))
    }

    @Test
    fun emptyTarget() {
        assertEquals(0, solution.longestCommonPrefix("abc", ""))
    }
}
