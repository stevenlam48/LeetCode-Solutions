package topkfrequentwords

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TopKFrequentWordsTest {
    @Test
    fun exampleK2() {
        val words = listOf("i", "love", "leetcode", "i", "love", "coding")
        assertEquals(listOf("i", "love"), Solution().topKFrequent(words, 2))
    }

    @Test
    fun exampleK3() {
        val words = listOf("i", "love", "leetcode", "i", "love", "coding")
        assertEquals(listOf("i", "love", "coding"), Solution().topKFrequent(words, 3))
    }

    @Test
    fun tieBreaksLexicographically() {
        val words = listOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is")
        assertEquals(listOf("the", "is", "sunny", "day"), Solution().topKFrequent(words, 4))
    }

    @Test
    fun singleWord() {
        assertEquals(listOf("a"), Solution().topKFrequent(listOf("a"), 1))
    }
}
