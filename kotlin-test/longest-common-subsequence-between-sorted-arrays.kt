package longestcommonsubsequencebetweensortedarrays

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LongestCommonSubsequenceBetweenSortedArraysTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertArrayEquals(
            intArrayOf(3, 7),
            solution.longestCommomSubsequence(
                arrayOf(intArrayOf(1, 3, 4, 7), intArrayOf(2, 3, 5, 7), intArrayOf(0, 3, 6, 7))
            )
        )
    }

    @Test
    fun duplicatesAreLimitedByEveryArray() {
        assertArrayEquals(
            intArrayOf(1, 2),
            solution.longestCommomSubsequence(
                arrayOf(intArrayOf(1, 1, 2), intArrayOf(1, 1, 1, 2), intArrayOf(1, 2, 2))
            )
        )
    }

    @Test
    fun disjointArrays() {
        assertArrayEquals(
            intArrayOf(),
            solution.longestCommomSubsequence(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5)))
        )
    }

    @Test
    fun emptyArray() {
        assertArrayEquals(
            intArrayOf(),
            solution.longestCommomSubsequence(arrayOf(intArrayOf(1, 2), intArrayOf(), intArrayOf(2)))
        )
    }
}
