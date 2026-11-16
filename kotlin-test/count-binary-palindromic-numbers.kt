package countbinarypalindromicnumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountBinaryPalindromicNumbersTest {
    @Test
    fun zeroAndOne() {
        assertEquals(1, Solution().countBinaryPalindromes(0))
        assertEquals(2, Solution().countBinaryPalindromes(1))
    }

    @Test
    fun inclusiveUpperBound() {
        assertEquals(4, Solution().countBinaryPalindromes(5))
        assertEquals(4, Solution().countBinaryPalindromes(6))
        assertEquals(6, Solution().countBinaryPalindromes(9))
    }

    @Test
    fun skipsNonPalindromes() {
        assertEquals(2, Solution().countBinaryPalindromes(2))
    }
}
