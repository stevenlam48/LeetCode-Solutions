package shorteststringthatcontainsthreestrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestStringThatContainsThreeStringsTest {
    @Test
    fun overlapsMutuallyOverlappingStrings() {
        assertEquals("abcab", Solution().minimumString("abc", "bca", "cab"))
    }

    @Test
    fun picksContainingString() {
        assertEquals("aba", Solution().minimumString("ab", "ba", "aba"))
    }

    @Test
    fun concatenatesDisjointStrings() {
        assertEquals("abc", Solution().minimumString("a", "b", "c"))
        assertEquals("abcdefghi", Solution().minimumString("abc", "def", "ghi"))
    }

    @Test
    fun overlappingOnlyOnOneSide() {
        assertEquals("abcde", Solution().minimumString("abc", "cde", "abcde"))
    }

    @Test
    fun breaksTiesLexicographically() {
        assertEquals("ab", Solution().minimumString("a", "b", "ab"))
        assertEquals("ba", Solution().minimumString("b", "ba", "a"))
    }
}
