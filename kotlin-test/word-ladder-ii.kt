package wordladderii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WordLadderIiTest {
    @Test
    fun examples() {
        val result = Solution().findLadders(
            "hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")
        )
        assertEquals(
            setOf(
                listOf("hit", "hot", "dot", "dog", "cog"),
                listOf("hit", "hot", "lot", "log", "cog")
            ),
            result.toSet()
        )
        assertTrue(
            Solution().findLadders("hit", "cog", listOf("hot", "dot", "dog", "lot", "log")).isEmpty()
        )
    }

    @Test
    fun directConnection() {
        assertEquals(
            listOf(listOf("a", "c")),
            Solution().findLadders("a", "c", listOf("a", "b", "c"))
        )
    }

    @Test
    fun allShortestPathsOnly() {
        val result = Solution().findLadders("red", "tax", listOf("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"))
        assertEquals(
            setOf(
                listOf("red", "ted", "tad", "tax"),
                listOf("red", "ted", "tex", "tax"),
                listOf("red", "rex", "tex", "tax")
            ),
            result.toSet()
        )
    }

    @Test
    fun disconnectedWords() {
        assertTrue(Solution().findLadders("aaa", "ccc", listOf("aab", "abb", "bbb", "ccc")).isEmpty())
    }
}
