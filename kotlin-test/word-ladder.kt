package wordladder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordLadderTest {
    @Test
    fun examples() {
        assertEquals(
            5,
            Solution().ladderLength("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog"))
        )
        assertEquals(
            0,
            Solution().ladderLength("hit", "cog", listOf("hot", "dot", "dog", "lot", "log"))
        )
    }

    @Test
    fun directConnection() {
        assertEquals(2, Solution().ladderLength("a", "c", listOf("a", "b", "c")))
    }

    @Test
    fun disconnectedWords() {
        assertEquals(0, Solution().ladderLength("aaa", "ccc", listOf("aab", "abb", "bbb", "ccc")))
    }

    @Test
    fun multipleEqualPaths() {
        assertEquals(3, Solution().ladderLength("hot", "dog", listOf("hot", "dot", "dog", "hog", "log")))
    }
}
