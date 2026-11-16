package nextspecialpalindromenumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NextSpecialPalindromeNumberTest {
    @Test
    fun `finds first special palindromes`() {
        assertEquals(22L, Solution().specialPalindrome(1L))
        assertEquals(212L, Solution().specialPalindrome(22L))
    }

    @Test
    fun `skips to three digit special palindromes`() {
        assertEquals(333L, Solution().specialPalindrome(212L))
        assertEquals(4444L, Solution().specialPalindrome(333L))
    }

    @Test
    fun `combines even and odd frequency digits`() {
        assertEquals(4444L, Solution().specialPalindrome(1000L))
        assertEquals(23332L, Solution().specialPalindrome(4444L))
        assertEquals(32323L, Solution().specialPalindrome(23332L))
    }

    @Test
    fun `handles zero`() {
        assertEquals(1L, Solution().specialPalindrome(0L))
    }
}
