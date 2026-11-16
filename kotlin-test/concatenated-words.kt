package concatenatedwords

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConcatenatedWordsTest {
    @Test
    fun findsAllWordsMadeFromAtLeastTwoWords() {
        val words = listOf("cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat")
        assertEquals(listOf("catsdogcats", "dogcatsdog", "ratcatdogcat"), Solution().findAllConcatenatedWordsInADict(words))
    }

    @Test
    fun doesNotUseWholeWordAsItsOwnPiece() {
        assertEquals(emptyList<String>(), Solution().findAllConcatenatedWordsInADict(listOf("cat", "dog", "bird")))
    }

    @Test
    fun allowsRepeatedUseOfDictionaryWords() {
        assertEquals(listOf("aa", "aaaa"), Solution().findAllConcatenatedWordsInADict(listOf("a", "aa", "aaaa")))
    }

    @Test
    fun handlesEmptyDictionary() {
        assertEquals(emptyList<String>(), Solution().findAllConcatenatedWordsInADict(emptyList()))
    }
}
