package repeatedsubstringpattern

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RepeatedSubstringPatternTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertTrue(solution.repeatedSubstringPattern("abab"))
    }

    @Test
    fun secondExample() {
        assertFalse(solution.repeatedSubstringPattern("aba"))
    }

    @Test
    fun patternCanRepeatMoreThanTwice() {
        assertTrue(solution.repeatedSubstringPattern("abcabcabcabc"))
    }

    @Test
    fun singleCharacterCannotFormRepeatedSubstring() {
        assertFalse(solution.repeatedSubstringPattern("a"))
    }
}
