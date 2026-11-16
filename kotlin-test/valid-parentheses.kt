package validparentheses

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidParenthesesTest {
    @Test
    fun singlePairAndEmptyString() {
        assertTrue(Solution().isValid("()"))
        assertTrue(Solution().isValid(""))
    }

    @Test
    fun sequentialPairs() {
        assertTrue(Solution().isValid("()[]{}"))
    }

    @Test
    fun nestedPairs() {
        assertTrue(Solution().isValid("{[]}"))
    }

    @Test
    fun mismatchedPair() {
        assertFalse(Solution().isValid("(]"))
    }

    @Test
    fun crossedPairs() {
        assertFalse(Solution().isValid("([)]"))
    }

    @Test
    fun unmatchedBrackets() {
        assertFalse(Solution().isValid("["))
        assertFalse(Solution().isValid("]"))
    }
}
