package encodestringwithshortestlength

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EncodeStringWithShortestLengthTest {
    private val solution = Solution()

    @Test
    fun nonRepeatingStringIsUnchanged() {
        assertEquals("abc", solution.encode("abc"))
    }

    @Test
    fun repeatedSingleCharacterUsesRepetitionCount() {
        assertEquals("aaa", solution.encode("aaa"))
        assertEquals("5[a]", solution.encode("aaaaa"))
        assertEquals("a9[a]", solution.encode("aaaaaaaaaa"))
    }

    @Test
    fun repeatedSubstringUsesShortestInnerEncoding() {
        assertEquals("3[ab]", solution.encode("ababab"))
        assertEquals("2[2[abbb]c]", solution.encode("abbbabbbcabbbabbbc"))
    }

    @Test
    fun combinesRepeatedSubstringWithSuffix() {
        assertEquals("2[aabc]d", solution.encode("aabcaabcd"))
    }
}
