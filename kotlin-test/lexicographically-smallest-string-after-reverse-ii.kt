package lexicographicallysmalleststringafterreverseii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestStringAfterReverseIiTest {
    @Test
    fun findsBestPrefixOrSuffixReversal() {
        assertEquals("acdb", Solution().lexSmallest("dcab"))
        assertEquals("aacb", Solution().lexSmallest("abca"))
    }

    @Test
    fun findsBestFullStringReversal() {
        assertEquals("abz", Solution().lexSmallest("zba"))
        assertEquals("abc", Solution().lexSmallest("cba"))
    }

    @Test
    fun handlesSingleCharacter() {
        assertEquals("z", Solution().lexSmallest("z"))
    }

    @Test
    fun handlesDuplicateMinimumCharacters() {
        assertEquals("aaaa", Solution().lexSmallest("aaaa"))
        assertEquals("aaab", Solution().lexSmallest("baaa"))
    }
}
