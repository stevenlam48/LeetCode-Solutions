package wordswithintwoeditsofdictionary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordsWithinTwoEditsOfDictionaryTest {
    @Test
    fun upToTwoEdits() {
        assertEquals(
            listOf("abcd", "abef", "zbcd"),
            Solution().twoEditWords(listOf("abcd", "abef", "aerf", "zbcd"), listOf("abcd"))
        )
    }

    @Test
    fun secondExample() {
        assertEquals(
            listOf("word", "note", "wood"),
            Solution().twoEditWords(
                listOf("word", "note", "ants", "wood"),
                listOf("wood", "joke", "moat")
            )
        )
    }

    @Test
    fun exactMatch() {
        assertEquals(listOf("a", "abc"), Solution().twoEditWords(listOf("a", "abc"), listOf("a", "abc")))
    }

    @Test
    fun noQueriesOrDictionary() {
        assertEquals(emptyList<String>(), Solution().twoEditWords(emptyList(), listOf("abc")))
        assertEquals(emptyList<String>(), Solution().twoEditWords(listOf("abc"), emptyList()))
    }
}
