package extracharactersinastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExtraCharactersInAStringTest {
    private val solution = Solution()

    @Test
    fun `minimizes leftovers using dictionary words`() {
        assertEquals(1, solution.minExtraChar("leetscode", listOf("leet", "code", "leetcode")))
    }

    @Test
    fun `counts an unmatched prefix`() {
        assertEquals(3, solution.minExtraChar("sayhelloworld", listOf("hello", "world")))
    }

    @Test
    fun `handles an empty string`() {
        assertEquals(0, solution.minExtraChar("", listOf("a", "bc")))
    }

    @Test
    fun `counts every character when no word matches`() {
        assertEquals(3, solution.minExtraChar("xyz", listOf("xyzz", "zz")))
    }

    @Test
    fun `combines overlapping dictionary options`() {
        assertEquals(0, solution.minExtraChar("aaaa", listOf("a", "aa")))
    }
}
