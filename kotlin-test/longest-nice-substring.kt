package longestnicesubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestNiceSubstringTest {
    @Test
    fun example1() {
        assertEquals("aAa", Solution().longestNiceSubstring("YazaAay"))
    }

    @Test
    fun example2() {
        assertEquals("Bb", Solution().longestNiceSubstring("Bb"))
    }

    @Test
    fun example3() {
        assertEquals("", Solution().longestNiceSubstring("c"))
    }

    @Test
    fun wholeStringNice() {
        assertEquals("aAbB", Solution().longestNiceSubstring("aAbB"))
    }

    @Test
    fun noNicePair() {
        assertEquals("", Solution().longestNiceSubstring("abc"))
    }

    @Test
    fun nestedNice() {
        assertEquals("dD", Solution().longestNiceSubstring("dDzeE"))
    }
}
