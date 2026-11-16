package longestincreasingsubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestIncreasingSubsequenceTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(4, solution.lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
    }

    @Test
    fun strictlyIncreasingLongerExample() {
        assertEquals(5, solution.lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3, 4)))
    }

    @Test
    fun duplicates() {
        assertEquals(1, solution.lengthOfLIS(intArrayOf(7, 7, 7, 7)))
    }

    @Test
    fun negatives() {
        assertEquals(3, solution.lengthOfLIS(intArrayOf(-2, -1, -1, 0)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, solution.lengthOfLIS(intArrayOf()))
    }
}
