package wordbreakii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordBreakIiTest {
    @Test
    fun twoSegmentations() {
        assertEquals(
            listOf("cat sand dog", "cats and dog"),
            Solution().wordBreak("catsanddog", setOf("cat", "cats", "and", "sand", "dog"))
        )
    }

    @Test
    fun manySegmentations() {
        assertEquals(
            listOf("pine apple pen apple", "pine applepen apple", "pineapple pen apple"),
            Solution().wordBreak("pineapplepenapple", setOf("apple", "pen", "applepen", "pine", "pineapple"))
        )
    }

    @Test
    fun noSegmentation() {
        assertEquals(
            emptyList<String>(),
            Solution().wordBreak("catsandog", setOf("cats", "dog", "sand", "and", "cat"))
        )
    }

    @Test
    fun repeatedWords() {
        assertEquals(
            listOf("a a a a", "a a aa", "a aa a", "a aaa", "aa a a", "aa aa", "aaa a"),
            Solution().wordBreak("aaaa", setOf("a", "aa", "aaa"))
        )
    }
}
