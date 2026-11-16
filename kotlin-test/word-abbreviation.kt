package wordabbreviation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordAbbreviationTest {
    @Test
    fun example() {
        val dict = listOf("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion")
        assertEquals(
            listOf("l2e", "god", "internal", "me", "i6t", "interval", "inte4n", "f2e", "intr4n"),
            Solution().wordsAbbreviation(dict)
        )
    }

    @Test
    fun identicalWords() {
        assertEquals(listOf("a3a", "a3a"), Solution().wordsAbbreviation(listOf("abcda", "abcda")))
    }

    @Test
    fun shortWordsStayUnchanged() {
        assertEquals(listOf("a", "god", "me"), Solution().wordsAbbreviation(listOf("a", "god", "me")))
    }

    @Test
    fun emptyDictionary() {
        assertEquals(emptyList<String>(), Solution().wordsAbbreviation(emptyList()))
    }
}
