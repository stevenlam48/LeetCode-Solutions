package wordBreakIIOld

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WordBreakIITest {
    @Test
    fun examples() {
        assertEquals(
            setOf("cats and dog", "cat sand dog"),
            Solution().wordBreak("catsanddog", setOf("cat", "cats", "and", "sand", "dog")).toSet()
        )
        assertEquals(
            setOf("pine apple pen apple", "pine applepen apple", "pineapple pen apple"),
            Solution().wordBreak("pineapplepenapple", setOf("apple", "pen", "applepen", "pine", "pineapple")).toSet()
        )
    }

    @Test
    fun noSegmentation() {
        assertTrue(Solution().wordBreak("catsandog", setOf("cats", "dog", "sand", "and", "cat")).isEmpty())
    }

    @Test
    fun emptyDictionary() {
        assertTrue(Solution().wordBreak("abc", emptySet()).isEmpty())
    }

    @Test
    fun repeatedWords() {
        val result = Solution().wordBreak("aaaa", setOf("a", "aa", "aaa"))
        assertEquals(
            setOf("a a a a", "a a aa", "a aa a", "a aaa", "aa a a", "aa aa", "aaa a"),
            result.toSet()
        )
        assertEquals(7, result.size)
    }
}
