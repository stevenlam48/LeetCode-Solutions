package synonymoussentences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SynonymousSentencesTest {
    @Test
    fun transitiveSynonyms() {
        val synonyms = listOf(listOf("happy", "joy"), listOf("joy", "cheerful"))
        assertEquals(
            listOf("I am cheerful", "I am happy", "I am joy"),
            Solution().generateSentences(synonyms, "I am happy")
        )
    }

    @Test
    fun independentGroupsAndWordOrder() {
        val synonyms = listOf(listOf("happy", "joy"), listOf("sad", "sorrow"))
        assertEquals(
            listOf("happy sad", "happy sorrow", "joy sad", "joy sorrow"),
            Solution().generateSentences(synonyms, "happy sad")
        )
    }

    @Test
    fun noSynonyms() {
        assertEquals(listOf("stay unchanged"), Solution().generateSentences(emptyList(), "stay unchanged"))
    }
}
