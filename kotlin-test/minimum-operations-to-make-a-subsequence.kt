package minimumoperationstomakeasubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeASubsequenceTest {
    @Test
    fun testIgnoreValuesOutsideTarget() {
        assertEquals(
            1,
            Solution().minOperations(intArrayOf(5, 1, 3), intArrayOf(9, 4, 1, 5, 3, 2))
        )
    }

    @Test
    fun testLongestCommonSubsequenceLengthThree() {
        assertEquals(
            3,
            Solution().minOperations(
                intArrayOf(6, 4, 8, 1, 3, 2),
                intArrayOf(4, 7, 6, 2, 3, 8, 6, 1)
            )
        )
    }

    @Test
    fun testEmptyArr() {
        assertEquals(3, Solution().minOperations(intArrayOf(1, 2, 3), intArrayOf()))
    }

    @Test
    fun testEmptyTarget() {
        assertEquals(0, Solution().minOperations(intArrayOf(), intArrayOf(1, 2)))
    }
}
