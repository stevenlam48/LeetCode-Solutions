package maximumproductofthelengthoftwopalindromicsubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfTheLengthOfTwoPalindromicSubsequencesTest {
    @Test
    fun example1() {
        assertEquals(4, Solution().maxProduct("abba"))
    }

    @Test
    fun allSame() {
        assertEquals(4, Solution().maxProduct("aaaa"))
    }

    @Test
    fun singleChar() {
        assertEquals(0, Solution().maxProduct("a"))
    }

    @Test
    fun twoDistinct() {
        assertEquals(1, Solution().maxProduct("ab"))
    }

    @Test
    fun threeChars() {
        assertEquals(2, Solution().maxProduct("aba"))
    }
}
