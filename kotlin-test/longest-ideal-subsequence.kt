package longestidealsubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestIdealSubsequenceTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(4, solution.longestIdealString("acfgbd", 2))
    }

    @Test
    fun consecutiveAlphabet() {
        assertEquals(4, solution.longestIdealString("abcd", 1))
    }

    @Test
    fun repeatedCharactersWithZeroDifference() {
        assertEquals(3, solution.longestIdealString("aaa", 0))
    }

    @Test
    fun decreasingCharacters() {
        assertEquals(3, solution.longestIdealString("zyx", 1))
    }

    @Test
    fun maximumDifferenceAllowsWholeString() {
        assertEquals(6, solution.longestIdealString("azbycx", 25))
    }
}
