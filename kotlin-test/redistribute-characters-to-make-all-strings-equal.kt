package redistributecharacterstomakeallstringsequal

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RedistributeCharactersToMakeAllStringsEqualTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.makeEqual(listOf("abc", "aabc", "bc")))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.makeEqual(listOf("ab", "a")))
    }

    @Test
    fun testSingleWord() {
        assertTrue(solution.makeEqual(listOf("abc")))
    }

    @Test
    fun testAlreadyEqual() {
        assertTrue(solution.makeEqual(listOf("ab", "ab")))
    }

    @Test
    fun testIndivisibleCount() {
        assertFalse(solution.makeEqual(listOf("a", "b")))
    }

    @Test
    fun testEmptyWords() {
        assertTrue(solution.makeEqual(listOf("", "", "")))
    }
}
