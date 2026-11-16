package findsubsequenceoflengthkwiththelargestsum

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindSubsequenceOfLengthKWithTheLargestSumTest {
    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(3, 3), Solution().maxSubsequence(intArrayOf(2, 1, 3, 3), 2))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            intArrayOf(-1, 3, 4),
            Solution().maxSubsequence(intArrayOf(-1, -2, 3, 4), 3)
        )
    }

    @Test
    fun testTieKeepsEarlierOccurrence() {
        assertArrayEquals(intArrayOf(3, 4), Solution().maxSubsequence(intArrayOf(3, 4, 3, 3), 2))
    }

    @Test
    fun testSingleElement() {
        assertArrayEquals(intArrayOf(1), Solution().maxSubsequence(intArrayOf(1), 1))
    }

    @Test
    fun testAllElements() {
        assertArrayEquals(
            intArrayOf(5, 1, 4),
            Solution().maxSubsequence(intArrayOf(5, 1, 4), 3)
        )
    }
}
