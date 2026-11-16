package nextpalindromeusingsamedigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NextPalindromeUsingSameDigitsTest {
    @Test
    fun `finds next palindrome from next left half permutation`() {
        assertEquals("2112", Solution().nextPalindrome("1221"))
        assertEquals("21312", Solution().nextPalindrome("12321"))
    }

    @Test
    fun `handles longer example`() {
        assertEquals("23414541432", Solution().nextPalindrome("23144534132"))
    }

    @Test
    fun `returns empty when no greater permutation exists`() {
        assertEquals("", Solution().nextPalindrome("11"))
        assertEquals("", Solution().nextPalindrome("221122"))
    }

    @Test
    fun `handles single digit`() {
        assertEquals("", Solution().nextPalindrome("1"))
    }
}
