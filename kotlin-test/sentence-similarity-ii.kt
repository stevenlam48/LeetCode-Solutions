package sentencesimilarityii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SentenceSimilarityIiTest {
    @Test
    fun exampleDirectPairs() {
        assertTrue(
            Solution().areSentencesSimilarTwo(
                listOf("great", "acting", "skills"),
                listOf("fine", "drama", "talent"),
                listOf(listOf("great", "fine"), listOf("drama", "acting"), listOf("skills", "talent")),
            ),
        )
    }

    @Test
    fun identicalSentencesWithoutPairs() {
        assertTrue(Solution().areSentencesSimilarTwo(listOf("great"), listOf("great"), emptyList()))
    }

    @Test
    fun transitiveSimilarity() {
        assertTrue(
            Solution().areSentencesSimilarTwo(
                listOf("a"),
                listOf("c"),
                listOf(listOf("a", "b"), listOf("b", "c")),
            ),
        )
    }

    @Test
    fun disconnectedWordsAreNotSimilar() {
        assertFalse(
            Solution().areSentencesSimilarTwo(
                listOf("a"),
                listOf("c"),
                listOf(listOf("a", "b")),
            ),
        )
    }

    @Test
    fun differentLengthsAreNotSimilar() {
        assertFalse(Solution().areSentencesSimilarTwo(listOf("a"), listOf("a", "b"), emptyList()))
    }
}
