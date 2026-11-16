package checkasciipalindromic

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckAsciiPalindromicTest {
    private val solution = Solution()

    @Test
    fun reversedBytePair() {
        assertTrue(solution.isPalindromic("\u0040\u0002"))
    }

    @Test
    fun regularTextIsNotNecessarilyPalindromic() {
        assertFalse(solution.isPalindromic("aa"))
        assertFalse(solution.isPalindromic("abcd"))
    }

    @Test
    fun symmetricMiddleCharacter() {
        assertTrue(solution.isPalindromic("\u0040\u0018\u0002"))
    }

    @Test
    fun emptyInput() {
        assertTrue(solution.isPalindromic(""))
    }
}
