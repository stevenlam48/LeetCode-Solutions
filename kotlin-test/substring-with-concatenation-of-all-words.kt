package substringwithconcatenationofallwords

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SubstringWithConcatenationOfAllWordsTest {
    @Test
    fun exampleOne() {
        assertArrayEquals(
            intArrayOf(0, 9),
            Solution().findSubstring("barfoothefoobarman", listOf("foo", "bar"))
        )
    }

    @Test
    fun duplicateWords() {
        assertArrayEquals(
            intArrayOf(0, 2, 1),
            Solution().findSubstring("aaaaaa", listOf("aa", "aa"))
        )
    }

    @Test
    fun noMatch() {
        assertArrayEquals(
            intArrayOf(),
            Solution().findSubstring("wordgoodgoodgoodbestword", listOf("word", "good", "best", "word"))
        )
    }

    @Test
    fun emptyWordsAndShortString() {
        assertArrayEquals(intArrayOf(), Solution().findSubstring("abc", emptyList()))
        assertArrayEquals(intArrayOf(), Solution().findSubstring("ab", listOf("abc")))
    }
}
