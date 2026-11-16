package uniquesubstringsinwraparoundstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniqueSubstringsInWraparoundStringTest {
    @Test
    fun singleLetter() {
        assertEquals(1, Solution().findSubstringInWraproundString("a"))
    }

    @Test
    fun brokenSequence() {
        assertEquals(2, Solution().findSubstringInWraproundString("cac"))
    }

    @Test
    fun wrapsFromZToA() {
        assertEquals(6, Solution().findSubstringInWraproundString("zab"))
    }

    @Test
    fun repeatedLettersDoNotAddSubstrings() {
        assertEquals(1, Solution().findSubstringInWraproundString("aaaa"))
    }
}
