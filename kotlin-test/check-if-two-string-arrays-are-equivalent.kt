package checkiftwostringarraysareequivalent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckIfTwoStringArraysAreEquivalentTest {
    private val solution = Solution()

    @Test
    fun testEquivalentSplit() {
        assertTrue(solution.arrayStringsAreEqual(arrayOf("ab", "c"), arrayOf("a", "bc")))
    }

    @Test
    fun testNotEquivalent() {
        assertFalse(solution.arrayStringsAreEqual(arrayOf("a", "cb"), arrayOf("ab", "c")))
    }

    @Test
    fun testSingleWords() {
        assertTrue(solution.arrayStringsAreEqual(arrayOf("abc"), arrayOf("abc")))
    }

    @Test
    fun testDifferentLengths() {
        assertFalse(solution.arrayStringsAreEqual(arrayOf("abc"), arrayOf("abcd")))
    }

    @Test
    fun testMultiplePieces() {
        assertTrue(solution.arrayStringsAreEqual(arrayOf("a", "b", "c"), arrayOf("ab", "c")))
    }
}
