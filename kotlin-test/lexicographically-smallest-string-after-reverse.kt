package lexicographicallysmalleststringafterreverse

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestStringAfterReverseTest {
    @Test
    fun findsBestPrefixOrSuffixReversal() {
        assertEquals("acdb", Solution().lexSmallest("dcab"))
        assertEquals("aacb", Solution().lexSmallest("abca"))
    }

    @Test
    fun findsFullStringReversalAsBest() {
        assertEquals("abz", Solution().lexSmallest("zba"))
        assertEquals("abc", Solution().lexSmallest("cba"))
    }

    @Test
    fun handlesSingleCharacter() {
        assertEquals("z", Solution().lexSmallest("z"))
    }

    @Test
    fun handlesRepeatedCharacters() {
        assertEquals("aaaa", Solution().lexSmallest("aaaa"))
        assertEquals("aaab", Solution().lexSmallest("baaa"))
    }
}
