package checkifastringcanbreakanotherstring

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfAStringCanBreakAnotherStringTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.checkIfCanBreak("abc", "xya"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.checkIfCanBreak("abe", "acd"))
    }

    @Test
    fun testExample3() {
        assertFalse(solution.checkIfCanBreak("leetcode", "practice"))
    }

    @Test
    fun testIdentical() {
        assertTrue(solution.checkIfCanBreak("abc", "abc"))
    }

    @Test
    fun testSingleCharacter() {
        assertTrue(solution.checkIfCanBreak("a", "b"))
        assertTrue(solution.checkIfCanBreak("b", "a"))
    }

    @Test
    fun testDuplicates() {
        assertTrue(solution.checkIfCanBreak("aab", "abb"))
        assertFalse(solution.checkIfCanBreak("abb", "aac"))
    }
}
