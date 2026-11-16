package countdifferentpalindromicsubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountDifferentPalindromicSubsequencesTest {
    @Test
    fun example() {
        assertEquals(6, Solution().countPalindromicSubsequences("bccb"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().countPalindromicSubsequences("a"))
    }

    @Test
    fun twoDistinctCharacters() {
        assertEquals(2, Solution().countPalindromicSubsequences("ab"))
    }

    @Test
    fun repeatedCharacter() {
        assertEquals(3, Solution().countPalindromicSubsequences("aaa"))
        assertEquals(2, Solution().countPalindromicSubsequences("aa"))
    }

    @Test
    fun allSameLonger() {
        assertEquals(4, Solution().countPalindromicSubsequences("aaaa"))
    }
}
