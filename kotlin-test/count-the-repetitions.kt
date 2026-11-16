package counttherepetitions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheRepetitionsTest {
    private val solution = Solution()

    @Test
    fun `leetcode example`() {
        assertEquals(2, solution.getMaxRepetitions("acb", 4, "ab", 2))
    }

    @Test
    fun `single exact match`() {
        assertEquals(1, solution.getMaxRepetitions("acb", 1, "acb", 1))
    }

    @Test
    fun `repeated characters`() {
        assertEquals(4, solution.getMaxRepetitions("aaa", 3, "aa", 1))
    }

    @Test
    fun `no matching characters`() {
        assertEquals(0, solution.getMaxRepetitions("abc", 5, "d", 1))
    }

    @Test
    fun `second repetition count reduces the result`() {
        assertEquals(2, solution.getMaxRepetitions("ab", 4, "ab", 2))
    }

    @Test
    fun `zero first repetition count`() {
        assertEquals(0, solution.getMaxRepetitions("abc", 0, "a", 1))
    }
}
