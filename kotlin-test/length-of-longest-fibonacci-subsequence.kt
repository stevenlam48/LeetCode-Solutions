package lengthoflongestfibonaccisubsequence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LengthOfLongestFibonacciSubsequenceTest {
    @Test
    fun findsFiveElementSubsequenceInFirstExample() {
        assertEquals(5, Solution().lenLongestFibSubseq(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)))
    }

    @Test
    fun findsThreeElementSubsequenceInSecondExample() {
        assertEquals(3, Solution().lenLongestFibSubseq(intArrayOf(1, 3, 7, 11, 12, 14, 18)))
    }

    @Test
    fun findsLongerSubsequenceThatDoesNotStartAtFirstElement() {
        assertEquals(5, Solution().lenLongestFibSubseq(intArrayOf(1, 2, 4, 6, 10, 16)))
    }

    @Test
    fun returnsZeroWhenNoFibonacciLikeSubsequenceExists() {
        assertEquals(0, Solution().lenLongestFibSubseq(intArrayOf(1, 3, 8)))
        assertEquals(0, Solution().lenLongestFibSubseq(intArrayOf(2, 2, 2, 2)))
    }

    @Test
    fun returnsZeroForFewerThanThreeElements() {
        assertEquals(0, Solution().lenLongestFibSubseq(intArrayOf()))
        assertEquals(0, Solution().lenLongestFibSubseq(intArrayOf(1, 2)))
    }
}
