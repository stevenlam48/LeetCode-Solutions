package countofsubstringscontainingeveryvowelandkconsonantsii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountOfSubstringsContainingEveryVowelAndKConsonantsIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1L, solution.countOfSubstrings("aeiou", 0))
    }

    @Test
    fun testExample2() {
        assertEquals(0L, solution.countOfSubstrings("aeioqq", 1))
    }

    @Test
    fun testExtraVowel() {
        assertEquals(3L, solution.countOfSubstrings("aeioua", 0))
    }

    @Test
    fun testSingleConsonant() {
        assertEquals(1L, solution.countOfSubstrings("aeiouq", 1))
        assertEquals(2L, solution.countOfSubstrings("qaeiouq", 1))
    }

    @Test
    fun testTooShort() {
        assertEquals(0L, solution.countOfSubstrings("a", 0))
        assertEquals(0L, solution.countOfSubstrings("", 0))
    }
}
