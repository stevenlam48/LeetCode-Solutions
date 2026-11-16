package firstmatchingcharacterfrombothends

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstMatchingCharacterFromBothEndsTest {
    @Test
    fun middleMatches() {
        assertEquals(1, Solution().firstMatchingIndex("abc"))
    }

    @Test
    fun noMatch() {
        assertEquals(-1, Solution().firstMatchingIndex("ab"))
    }

    @Test
    fun endsMatch() {
        assertEquals(0, Solution().firstMatchingIndex("aa"))
    }

    @Test
    fun evenLengthNoMatch() {
        assertEquals(-1, Solution().firstMatchingIndex("abcd"))
    }

    @Test
    fun endsMatchLonger() {
        assertEquals(0, Solution().firstMatchingIndex("abca"))
    }

    @Test
    fun innerMatch() {
        assertEquals(2, Solution().firstMatchingIndex("xyzzy"))
    }
}
