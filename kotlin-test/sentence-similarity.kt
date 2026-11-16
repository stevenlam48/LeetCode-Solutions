package sentencesimilarity

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SentenceSimilarityTest {
    @Test
    fun exampleSimilarPairs() {
        assertTrue(
            Solution().areSentencesSimilar(
                listOf("great", "acting", "skills"),
                listOf("fine", "drama", "talent"),
                listOf(listOf("great", "fine"), listOf("drama", "acting"), listOf("skills", "talent")),
            ),
        )
    }

    @Test
    fun identicalSentencesWithoutPairs() {
        assertTrue(Solution().areSentencesSimilar(listOf("great"), listOf("great"), emptyList()))
    }

    @Test
    fun directPair() {
        assertTrue(
            Solution().areSentencesSimilar(listOf("great"), listOf("fine"), listOf(listOf("great", "fine"))),
        )
    }

    @Test
    fun pairIsSymmetric() {
        assertTrue(
            Solution().areSentencesSimilar(listOf("great"), listOf("fine"), listOf(listOf("fine", "great"))),
        )
    }

    @Test
    fun missingPairIsNotSimilar() {
        assertFalse(Solution().areSentencesSimilar(listOf("great"), listOf("fine"), emptyList()))
    }

    @Test
    fun differentLengthsAreNotSimilar() {
        assertFalse(Solution().areSentencesSimilar(listOf("a"), listOf("a", "b"), emptyList()))
    }
}
