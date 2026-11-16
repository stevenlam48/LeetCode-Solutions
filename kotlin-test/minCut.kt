package minCut

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinCutTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().minCut("aab"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(0, Solution().minCut("a"))
    }

    @Test
    fun twoDistinctCharacters() {
        assertEquals(1, Solution().minCut("ab"))
    }

    @Test
    fun palindromicString() {
        assertEquals(0, Solution().minCut("abcba"))
    }

    @Test
    fun twoPalindromicBlocks() {
        assertEquals(1, Solution().minCut("aabb"))
    }
}
