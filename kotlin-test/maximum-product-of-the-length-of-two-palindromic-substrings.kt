package maximumproductofthelengthoftwopalindromicsubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfTheLengthOfTwoPalindromicSubstringsTest {
    @Test
    fun example1() {
        assertEquals(9L, Solution().maxProduct("ababbb"))
    }

    @Test
    fun example2() {
        assertEquals(9L, Solution().maxProduct("zaaaxbbby"))
    }

    @Test
    fun twoChars() {
        assertEquals(1L, Solution().maxProduct("ab"))
    }

    @Test
    fun sameChars() {
        assertEquals(1L, Solution().maxProduct("aa"))
    }

    @Test
    fun nestedPalindrome() {
        assertEquals(3L, Solution().maxProduct("abcba"))
    }
}
