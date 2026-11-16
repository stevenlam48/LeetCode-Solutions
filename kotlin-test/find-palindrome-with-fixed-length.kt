package findpalindromewithfixedlength

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindPalindromeWithFixedLengthTest {
    private val solution = Solution()

    @Test
    fun exampleOddLength() {
        assertArrayEquals(
            longArrayOf(101, 111, 121, 131, 141, 999),
            solution.kthPalindrome(intArrayOf(1, 2, 3, 4, 5, 90), 3)
        )
    }

    @Test
    fun evenLength() {
        assertArrayEquals(
            longArrayOf(1001, 1111, 1991, 9999),
            solution.kthPalindrome(intArrayOf(1, 2, 10, 90), 4)
        )
    }

    @Test
    fun twoDigitsAndOutOfRange() {
        assertArrayEquals(longArrayOf(11, 99, -1), solution.kthPalindrome(intArrayOf(1, 9, 10), 2))
    }

    @Test
    fun noQueries() {
        assertArrayEquals(longArrayOf(), solution.kthPalindrome(intArrayOf(), 5))
    }
}
