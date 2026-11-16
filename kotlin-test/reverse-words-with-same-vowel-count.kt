package reversewordswithsamevowelcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseWordsWithSameVowelCountTest {
    @Test
    fun allWordsMatch() {
        assertEquals("cat dna god", Solution().reverseWords("cat and dog"))
    }

    @Test
    fun onlyMatchingWordsReverse() {
        assertEquals("book is ecin", Solution().reverseWords("book is nice"))
    }

    @Test
    fun singleWordNeverReverses() {
        assertEquals("book", Solution().reverseWords("book"))
    }

    @Test
    fun uppercaseLettersDoNotCountAsVowels() {
        assertEquals("Apple dna", Solution().reverseWords("Apple and"))
    }
}
