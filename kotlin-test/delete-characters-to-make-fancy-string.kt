package deletecharacterstomakefancystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeleteCharactersToMakeFancyStringTest {
    private val solution = Solution()

    @Test
    fun removesThirdRepeatedCharacter() {
        assertEquals("leetcode", solution.makeFancyString("leeetcode"))
    }

    @Test
    fun handlesSeparateRuns() {
        assertEquals("aabaa", solution.makeFancyString("aaabaaaa"))
    }

    @Test
    fun alreadyFancy() {
        assertEquals("aab", solution.makeFancyString("aab"))
    }

    @Test
    fun emptyAndLongRun() {
        assertEquals("", solution.makeFancyString(""))
        assertEquals("aa", solution.makeFancyString("aaaaaa"))
    }
}
