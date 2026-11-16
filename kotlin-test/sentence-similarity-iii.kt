package sentencesimilarityiii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SentenceSimilarityIiiTest {
    @Test
    fun exampleMyHaley() {
        assertTrue(Solution().areSentencesSimilar("My name is Haley", "My Haley"))
    }

    @Test
    fun exampleOfWords() {
        assertFalse(Solution().areSentencesSimilar("of", "A lot of words"))
    }

    @Test
    fun prefixOnly() {
        assertTrue(Solution().areSentencesSimilar("Eating right now", "Eating"))
    }

    @Test
    fun differentSpelling() {
        assertFalse(Solution().areSentencesSimilar("Luky", "Lucccky"))
    }

    @Test
    fun identicalSentences() {
        assertTrue(Solution().areSentencesSimilar("a b c", "a b c"))
    }

    @Test
    fun middleWordRemoved() {
        assertTrue(Solution().areSentencesSimilar("a b c", "a c"))
    }

    @Test
    fun reorderedWordsAreNotSimilar() {
        assertFalse(Solution().areSentencesSimilar("a b", "b a"))
    }
}
