package shortestuncommonsubstringinanarray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestUncommonSubstringInAnArrayTest {
    @Test
    fun findsShortestUncommonSubstrings() {
        assertEquals(
            listOf("ab", "", "ba", ""),
            Solution().shortestSubstrings(listOf("cab", "ad", "bad", "c"))
        )
    }

    @Test
    fun returnsEmptyWhenEverythingIsShared() {
        assertEquals(
            listOf("", "", "abcd"),
            Solution().shortestSubstrings(listOf("abc", "bcd", "abcd"))
        )
    }

    @Test
    fun handlesDuplicateStrings() {
        assertEquals(listOf("", ""), Solution().shortestSubstrings(listOf("a", "a")))
    }

    @Test
    fun handlesDisjointStrings() {
        assertEquals(listOf("a", "b"), Solution().shortestSubstrings(listOf("a", "b")))
    }

    @Test
    fun prefersShorterThenLexicographicallySmaller() {
        assertEquals(
            listOf("ba", "ab"),
            Solution().shortestSubstrings(listOf("ba", "ab"))
        )
    }
}
