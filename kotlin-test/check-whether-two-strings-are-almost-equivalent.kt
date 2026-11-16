package checkwhethertwostringsarealmostequivalent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckWhetherTwoStringsAreAlmostEquivalentTest {
    private val solution = Solution()

    @Test
    fun testTooManyDifferences() {
        assertFalse(solution.checkAlmostEquivalent("aaaa", "bccb"))
    }

    @Test
    fun testWithinLimit() {
        assertTrue(solution.checkAlmostEquivalent("abcdeef", "abaaacc"))
    }

    @Test
    fun testAnotherValidPair() {
        assertTrue(solution.checkAlmostEquivalent("cccddabba", "babababab"))
    }

    @Test
    fun testIdentical() {
        assertTrue(solution.checkAlmostEquivalent("abc", "abc"))
    }

    @Test
    fun testExactlyThreeDifference() {
        assertTrue(solution.checkAlmostEquivalent("a", "aaaa"))
    }

    @Test
    fun testFourDifference() {
        assertFalse(solution.checkAlmostEquivalent("a", "aaaaa"))
    }
}
