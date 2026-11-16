package longestpathwithdifferentadjacentcharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPathWithDifferentAdjacentCharactersTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().longestPath(intArrayOf(-1, 0, 0, 1, 1, 2), "abacbe"))
    }

    @Test
    fun singleNode() {
        assertEquals(1, Solution().longestPath(intArrayOf(-1), "a"))
    }

    @Test
    fun twoDifferent() {
        assertEquals(2, Solution().longestPath(intArrayOf(-1, 0), "ab"))
    }

    @Test
    fun twoSame() {
        assertEquals(1, Solution().longestPath(intArrayOf(-1, 0), "aa"))
    }

    @Test
    fun chainAllDifferent() {
        assertEquals(3, Solution().longestPath(intArrayOf(-1, 0, 1), "abc"))
    }

    @Test
    fun chainAlternating() {
        assertEquals(3, Solution().longestPath(intArrayOf(-1, 0, 1), "aba"))
    }
}
