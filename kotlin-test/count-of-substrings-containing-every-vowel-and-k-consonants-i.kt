package countofsubstringscontainingeveryvowelandkconsonantsi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountOfSubstringsContainingEveryVowelAndKConsonantsITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.countOfSubstrings("aeiou", 0))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.countOfSubstrings("aeioqq", 1))
    }

    @Test
    fun testExtraVowel() {
        assertEquals(3, solution.countOfSubstrings("aeioua", 0))
    }

    @Test
    fun testSingleConsonant() {
        assertEquals(1, solution.countOfSubstrings("aeiouq", 1))
        assertEquals(2, solution.countOfSubstrings("qaeiouq", 1))
    }

    @Test
    fun testTooShort() {
        assertEquals(0, solution.countOfSubstrings("a", 0))
        assertEquals(0, solution.countOfSubstrings("", 0))
    }
}
