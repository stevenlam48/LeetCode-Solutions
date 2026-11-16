package sortfeaturesbypopularity

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortFeaturesByPopularityTest {
    @Test
    fun featuresSortedByResponseFrequency() {
        val features = arrayOf("alpha", "beta", "gamma")
        val responses = listOf("beta alpha alpha", "gamma beta beta", "gamma")
        assertArrayEquals(
            arrayOf("beta", "gamma", "alpha"),
            Solution().sortFeatures(features, responses)
        )
    }

    @Test
    fun duplicateWordsCountOncePerResponse() {
        val features = arrayOf("cooler", "lock", "touch")
        val responses = listOf("i like cooler cooler lock", "cool touch")
        assertArrayEquals(features, Solution().sortFeatures(features, responses))
    }

    @Test
    fun tiesRetainOriginalFeatureOrder() {
        val features = arrayOf("a", "aa", "b", "c")
        val responses = listOf("a", "a aa", "a aa", "b bb", "b c")
        assertArrayEquals(arrayOf("a", "aa", "b", "c"), Solution().sortFeatures(features, responses))
    }

    @Test
    fun noResponsesKeepsOriginalOrder() {
        val features = arrayOf("one", "two", "three")
        assertArrayEquals(features, Solution().sortFeatures(features, emptyList()))
    }

    @Test
    fun emptyFeatures() {
        assertArrayEquals(arrayOf<String>(), Solution().sortFeatures(arrayOf(), listOf("one two")))
    }
}
