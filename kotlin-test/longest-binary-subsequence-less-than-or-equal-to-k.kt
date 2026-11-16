package longestbinarysubsequencelessthanorequaltok

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestBinarySubsequenceLessThanOrEqualToKTest {
    @Test
    fun mixedBits() {
        assertEquals(5, Solution().longestSubsequence("1001010", 5))
    }

    @Test
    fun manyZerosWithSmallK() {
        assertEquals(6, Solution().longestSubsequence("00101001", 1))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().longestSubsequence("0", 1))
        assertEquals(0, Solution().longestSubsequence("1", 0))
    }

    @Test
    fun onesOnly() {
        assertEquals(2, Solution().longestSubsequence("111", 4))
        assertEquals(0, Solution().longestSubsequence("111", 0))
    }

    @Test
    fun allZeros() {
        assertEquals(4, Solution().longestSubsequence("0000", 0))
    }

    @Test
    fun largeK() {
        assertEquals(6, Solution().longestSubsequence("101010", 1000000000))
    }
}
