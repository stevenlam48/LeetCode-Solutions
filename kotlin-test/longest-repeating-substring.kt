package longestrepeatingsubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestRepeatingSubstringTest {
    @Test
    fun noRepeat() {
        assertEquals(0, Solution().longestRepeatingSubstring("abcd"))
    }

    @Test
    fun example1() {
        assertEquals(2, Solution().longestRepeatingSubstring("abbaba"))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().longestRepeatingSubstring("aabcaabdaab"))
    }

    @Test
    fun allSame() {
        assertEquals(4, Solution().longestRepeatingSubstring("aaaaa"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(0, Solution().longestRepeatingSubstring("a"))
    }

    @Test
    fun adjacentPair() {
        assertEquals(1, Solution().longestRepeatingSubstring("aa"))
    }
}
