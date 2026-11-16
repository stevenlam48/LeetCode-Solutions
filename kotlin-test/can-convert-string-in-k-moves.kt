package canconvertstringinkmoves

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CanConvertStringInKMovesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.canConvertString("input", "ouput", 9))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.canConvertString("abc", "bcd", 10))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.canConvertString("aab", "bbb", 27))
    }

    @Test
    fun testDifferentLengths() {
        assertFalse(solution.canConvertString("a", "ab", 100))
    }

    @Test
    fun testAlreadyEqual() {
        assertTrue(solution.canConvertString("abc", "abc", 0))
    }

    @Test
    fun testZeroMovesNeededButNotAllowed() {
        assertFalse(solution.canConvertString("a", "b", 0))
    }
}
