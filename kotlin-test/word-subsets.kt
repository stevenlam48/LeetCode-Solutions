package wordsubsets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordSubsetsTest {
    @Test
    fun firstExample() {
        assertEquals(
            listOf("facebook", "google", "leetcode"),
            Solution().wordSubsets(
                listOf("amazon", "apple", "facebook", "google", "leetcode"),
                listOf("e", "o")
            )
        )
    }

    @Test
    fun secondExample() {
        assertEquals(
            listOf("apple", "google", "leetcode"),
            Solution().wordSubsets(
                listOf("amazon", "apple", "facebook", "google", "leetcode"),
                listOf("l", "e")
            )
        )
    }

    @Test
    fun repeatedRequiredLetters() {
        assertEquals(
            listOf("warrior"),
            Solution().wordSubsets(listOf("amazon", "apple", "facebook", "google", "leetcode", "warrior", "worldwide"), listOf("rr", "wr"))
        )
    }

    @Test
    fun emptySecondList() {
        val words = listOf("a", "bbb", "")
        assertEquals(words, Solution().wordSubsets(words, emptyList()))
    }
}
