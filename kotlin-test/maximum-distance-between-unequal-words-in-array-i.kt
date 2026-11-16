package maximumdistancebetweenunequalwordsinarrayi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumDistanceBetweenUnequalWordsInArrayITest {
    @Test
    fun differentEndpoints() {
        val words = listOf("leetcode", "leetcode", "codeforces", "code", "algorithm")
        assertEquals(5, Solution().maxDistance(words))
    }

    @Test
    fun allWordsEqual() {
        assertEquals(0, Solution().maxDistance(listOf("same", "same", "same")))
    }

    @Test
    fun unequalInteriorWord() {
        assertEquals(3, Solution().maxDistance(listOf("a", "a", "b", "a")))
    }

    @Test
    fun twoUnequalWords() {
        assertEquals(2, Solution().maxDistance(listOf("first", "second")))
    }
}
