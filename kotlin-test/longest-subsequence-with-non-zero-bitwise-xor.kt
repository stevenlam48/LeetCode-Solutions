package longestsubsequencewithnonzerobitwisexor

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSubsequenceWithNonZeroBitwiseXorTest {
    @Test
    fun zeroTotalXorDropsOneElement() {
        assertEquals(2, Solution().longestSubsequence(intArrayOf(1, 2, 3)))
    }

    @Test
    fun nonzeroTotalXorKeepsEveryElement() {
        assertEquals(4, Solution().longestSubsequence(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun allZeroesCannotProduceNonzeroXor() {
        assertEquals(0, Solution().longestSubsequence(intArrayOf(0, 0, 0)))
    }

    @Test
    fun zeroesCanBeRetainedWithANonzeroValue() {
        assertEquals(3, Solution().longestSubsequence(intArrayOf(0, 1, 0)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, Solution().longestSubsequence(intArrayOf()))
    }
}
