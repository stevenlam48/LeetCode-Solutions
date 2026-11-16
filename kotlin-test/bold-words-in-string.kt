package boldwordsinstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BoldWordsInStringTest {
    @Test
    fun example1() {
        assertEquals("a<b>abc</b>d", Solution().boldWords(listOf("ab", "bc"), "aabcd"))
    }

    @Test
    fun singleWord() {
        assertEquals("<b>ab</b>c", Solution().boldWords(listOf("ab"), "abc"))
    }

    @Test
    fun noMatch() {
        assertEquals("abc", Solution().boldWords(listOf("xyz"), "abc"))
    }

    @Test
    fun wholeString() {
        assertEquals("<b>aaa</b>", Solution().boldWords(listOf("a"), "aaa"))
    }

    @Test
    fun overlappingWords() {
        assertEquals("<b>abc</b>", Solution().boldWords(listOf("ab", "bc"), "abc"))
    }
}
