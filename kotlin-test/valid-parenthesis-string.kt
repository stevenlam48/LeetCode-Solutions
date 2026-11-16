package validparenthesisstring

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidParenthesisStringTest {
    @Test
    fun simpleBalanced() {
        assertTrue(Solution().checkValidString("()"))
        assertTrue(Solution().checkValidString("(())"))
    }

    @Test
    fun wildcardCanBeEmpty() {
        assertTrue(Solution().checkValidString("(*)"))
    }

    @Test
    fun wildcardCanBeClosing() {
        assertTrue(Solution().checkValidString("(*))"))
    }

    @Test
    fun unmatchedOpening() {
        assertFalse(Solution().checkValidString("("))
        assertFalse(Solution().checkValidString("(*("))
    }

    @Test
    fun earlyClosingBreaks() {
        assertFalse(Solution().checkValidString(")**("))
    }

    @Test
    fun emptyString() {
        assertTrue(Solution().checkValidString(""))
    }
}
