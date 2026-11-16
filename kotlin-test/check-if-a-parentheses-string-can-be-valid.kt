package checkifaparenthesesstringcanbevalid

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfAParenthesesStringCanBeValidTest {
    private val solution = Solution()

    @Test
    fun partiallyLockedExample() {
        assertTrue(solution.canBeValid("))()))", "010100"))
    }

    @Test
    fun fullyUnlockedPairs() {
        assertTrue(solution.canBeValid("()()", "0000"))
    }

    @Test
    fun oddLengthCannotBeValid() {
        assertFalse(solution.canBeValid(")", "0"))
    }

    @Test
    fun fullyLockedInvalidString() {
        assertFalse(solution.canBeValid("())(", "1111"))
    }

    @Test
    fun fullyLockedValidString() {
        assertTrue(solution.canBeValid("(())", "1111"))
    }
}
