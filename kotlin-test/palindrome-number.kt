package palindromenumber

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PalindromeNumberTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertTrue(solution.isPalindrome(121))
        assertFalse(solution.isPalindrome(-121))
        assertFalse(solution.isPalindrome(10))
    }

    @Test
    fun zeroAndSingleDigits() {
        assertTrue(solution.isPalindrome(0))
        assertTrue(solution.isPalindrome(9))
    }

    @Test
    fun evenAndOddLengthPalindromes() {
        assertTrue(solution.isPalindrome(1221))
        assertTrue(solution.isPalindrome(1_000_000_001))
    }

    @Test
    fun overflowWhileReversing() {
        assertFalse(solution.isPalindrome(1_234_567_899))
        assertFalse(solution.isPalindrome(Int.MIN_VALUE))
    }
}
