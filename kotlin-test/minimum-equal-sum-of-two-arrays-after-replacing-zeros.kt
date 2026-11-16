package minimumequalsumoftwoarraysafterreplacingzeros

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumEqualSumOfTwoArraysAfterReplacingZerosTest {
    @Test
    fun example1() {
        assertEquals(12L, Solution().minSum(intArrayOf(3, 2, 0, 1, 0), intArrayOf(6, 5, 0)))
    }

    @Test
    fun exampleImpossible() {
        assertEquals(-1L, Solution().minSum(intArrayOf(2, 0, 2, 0), intArrayOf(1, 4)))
    }

    @Test
    fun bothContainZerosAndAreEqual() {
        assertEquals(2L, Solution().minSum(intArrayOf(1, 0), intArrayOf(1, 0)))
    }

    @Test
    fun unequalWithoutZeros() {
        assertEquals(-1L, Solution().minSum(intArrayOf(1, 2), intArrayOf(1, 3)))
    }

    @Test
    fun singleZeroOnEachSide() {
        assertEquals(1L, Solution().minSum(intArrayOf(0), intArrayOf(0)))
    }
}
