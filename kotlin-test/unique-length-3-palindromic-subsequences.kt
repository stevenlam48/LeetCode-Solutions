package uniquelength3palindromicsubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniqueLength3PalindromicSubsequencesTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().countPalindromicSubsequence("aabca"))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().countPalindromicSubsequence("adc"))
    }

    @Test
    fun example3() {
        assertEquals(4, Solution().countPalindromicSubsequence("bbcbaba"))
    }

    @Test
    fun allSame() {
        assertEquals(1, Solution().countPalindromicSubsequence("aaaa"))
    }

    @Test
    fun tooShort() {
        assertEquals(0, Solution().countPalindromicSubsequence("ab"))
    }
}
