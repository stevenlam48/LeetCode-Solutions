package checkifastringisanacronymofwords

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfAStringIsAnAcronymOfWordsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.isAcronym(listOf("alice", "bob", "charlie"), "abc"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.isAcronym(listOf("an", "apple"), "a"))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.isAcronym(listOf("never", "gonna", "give", "up", "on", "you"), "ngguoy"))
    }

    @Test
    fun testSingleWord() {
        assertTrue(solution.isAcronym(listOf("a"), "a"))
    }

    @Test
    fun testLengthMismatch() {
        assertFalse(solution.isAcronym(listOf("ab", "cd"), "abc"))
    }
}
